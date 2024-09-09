package com.example.searchjob.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.searchjob.view.empy_screen.EmptyScreen
import com.example.searchjob.view.favorites_screen.FavoritesScreen
import com.example.searchjob.view.jobs_page_screen.JobsPageScreen
import com.example.searchjob.view.login_one_screen.LoginScreenOneActivity
import com.example.searchjob.view.login_two_screen.LoginScreenTwoActivity
import com.example.searchjob.view.mainscreen.MainScreen
import com.example.searchjob.view.mainscreen.viewmodel.MainVM

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    mainVM: MainVM,
    navHostController: NavHostController,
) {
    val vacancy by mainVM.vacancy.collectAsState()

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = RouteNavigation.LOGIN_ONE_ACTIVITY.route
    ) {
        composable(RouteNavigation.LOGIN_ONE_ACTIVITY.route) {
            LoginScreenOneActivity(
                navigation = {
                    navHostController.navigate(RouteNavigation.LOGIN_TWO_ACTIVITY.route + "?$it") {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            RouteNavigation.LOGIN_TWO_ACTIVITY.route + "?{email}",
            arguments = listOf(
                navArgument("email") { type = NavType.StringType }
            )
        ) { argument ->
            val userEmail = argument.arguments?.getString("email") ?: ""
            LoginScreenTwoActivity(
                emailUser = userEmail,
                navController = navHostController
            )
        }
        composable(RouteNavigation.MAIN_ACTIVITY.route) {
            MainScreen(
                mainVM,
                navController = navHostController
            )
        }
        composable(RouteNavigation.EMPTY_ACTIVITY.route){
            EmptyScreen()
        }
        composable(RouteNavigation.JOBS_PAGE_ACTIVITY.route) {
            JobsPageScreen(
                vacancy = vacancy,
                updateFavorites = {
                    mainVM.updateIsFavorites(it)
                }
            ) {
                navHostController.popBackStack()
            }
        }
        composable(RouteNavigation.FAVORITES_ACTIVITY.route) {
            FavoritesScreen(
                onClickFavorites = {
                    mainVM.updateIsFavorites(it)
                },
                viewVacancy = {
                    mainVM.viewVacancy(it)
                },
                navigation = {
                    navHostController.navigate(RouteNavigation.JOBS_PAGE_ACTIVITY.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }

}
