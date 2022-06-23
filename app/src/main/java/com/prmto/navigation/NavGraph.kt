package com.prmto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.prmto.util.Constants

@Composable
fun setupNavhGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {

        }
        composable(Screen.Welcome.route) {

        }
        composable(Screen.Home.route) {

        }
        composable(
            Screen.Details.route,
            arguments = listOf(navArgument(Constants.DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(Screen.Search.route) {

        }

    }

}