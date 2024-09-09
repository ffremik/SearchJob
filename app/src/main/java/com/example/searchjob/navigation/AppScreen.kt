package com.example.searchjob.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.searchjob.view.mainscreen.viewmodel.MainVM

@Composable
fun AppScreen(mainVM: MainVM = hiltViewModel()) {
    val navHostController = rememberNavController()
    val listFavorites by mainVM.favoritesList.collectAsState(initial = emptyList())
    val sizeFavorites = listFavorites.size
    Scaffold(
        bottomBar = {
            BottomMenu(navHostController, sizeFavorites)
        }
    ) { paddingValues ->
        NavigationHost(
            modifier = Modifier.padding(paddingValues),
            mainVM = mainVM,
            navHostController
        )
    }
}