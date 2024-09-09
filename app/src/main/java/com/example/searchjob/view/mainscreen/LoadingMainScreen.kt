package com.example.searchjob.view.mainscreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.searchjob.view.mainscreen.model.StateMainScreen

@Composable
fun LoadingMainScreen(
    uiState: StateMainScreen,
    timerLoading: Float,
    updateTimer: () -> Unit
) {
   // val uiState by homeVM.uiState.collectAsState()

    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (uiState == StateMainScreen.Loading){
            CircularProgressIndicator(
                progress = timerLoading,
                color = Color.Red
            )
            Text(
                text = "Получение данных",
                fontSize = 18.sp,
                color = Color.Blue
            )
            LaunchedEffect(key1 = uiState) {
                updateTimer()
                Log.i("MyLog", "Функции все ещё работает")
            }

        }
    }
}