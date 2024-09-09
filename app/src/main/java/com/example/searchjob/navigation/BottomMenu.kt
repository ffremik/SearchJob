package com.example.searchjob.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.searchjob.R
import com.example.searchjob.style.TabText

@Composable
fun BottomMenu(
    navController: NavController,
    sizeFavorites: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .safeDrawingPadding(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ListItemsBottomMenu.listItems.forEach { itemMenu ->
            IconBottomMenu(
                itemMenu,
                sizeFavorites = sizeFavorites
            ) {
                navController.navigate(it) {
                    launchSingleTop = true
                }
            }
        }
    }
}

@Composable
fun IconBottomMenu(
    menuItem: BottomMenuItem,
    sizeFavorites: Int,
    onClick: (String) -> Unit
) {
    val isCount = sizeFavorites > 0 && menuItem.route == RouteNavigation.FAVORITES_ACTIVITY.route
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onClick(menuItem.route)
        }
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                painter = painterResource(id = menuItem.iconRes),
                contentDescription = stringResource(id = menuItem.titleRes)
            )
            Box(
                contentAlignment = Alignment.Center
            ) {
                if (isCount) {
                    Icon(
                        modifier = Modifier.size(13.dp),
                        tint = Color.Red,
                        painter = painterResource(id = R.drawable.elements),
                        contentDescription = ""
                    )
                    TabText(
                        color = colorResource(id = R.color.white),
                        text = "$sizeFavorites",
                    )

                }


            }
        }

        TabText(
            text = stringResource(id = menuItem.titleRes)
        )


    }



}