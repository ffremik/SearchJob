package com.example.searchjob.view.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun PreviewErrorScreenHome(){
    ErrorMainScreen()
}

@Composable
fun ErrorMainScreen(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Упс... \nЧто-то пошло не так",
            fontSize = 21.sp
        )

        Text(
            modifier = Modifier.padding(top = 4.dp),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            text = "Проверьте подключение к интернету."
        )
    }
}