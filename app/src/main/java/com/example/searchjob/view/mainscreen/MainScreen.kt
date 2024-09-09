package com.example.searchjob.view.mainscreen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.searchjob.view.mainscreen.model.StateMainScreen
import com.example.searchjob.view.mainscreen.viewmodel.MainVM


@Composable
@Preview(showBackground = true)
fun PreviewMainScreen() {
    // MainScreen(mainVM = viewModel())
}

@Composable
fun MainScreen(
    mainVM: MainVM,
    navController: NavController
) {
    val uiStateScreen by mainVM.uiStateMainScreen.collectAsState()
    val timer by mainVM.progressLoadingTimer.collectAsState()

    when(uiStateScreen) {
        is StateMainScreen.Loading -> {
            LoadingMainScreen(uiStateScreen, timer ){
                mainVM.updateTimerLoadingProgress()
            }
        }
        is StateMainScreen.Success -> {
            SuccessMainScreen(
                mainVM = mainVM,
                navController = navController
            )
        }
        is StateMainScreen.Error -> {
            ErrorMainScreen()
        }
    }

}