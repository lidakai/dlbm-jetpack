package com.example.dlbm.config

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dlbm.ui.view.detailsScreen.DetailsScreen
import com.example.dlbm.ui.view.profileScreen.ProfileScreen
import com.example.dlbm.ui.view.settingsScreen.SettingsScreen
import com.example.dlbm.ui.view.homeScreen.HomeScreen
import com.example.dlbm.ui.view.shopping.ShoppingScreen
import com.example.dlbm.ui.view.toolbox.Toolbox
import com.example.dlbm.ui.view.user.UserScreen


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Toolbox : Screen("toolbox")
    object User : Screen("user")
    object Shopping : Screen("shopping")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object Details : Screen("details/{id}") {
        fun createRoute(id: Int) = "details/$id"
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
        composable(Screen.Shopping.route) {
            ShoppingScreen()
        }
        composable(Screen.User.route) {
            UserScreen()
        }
        composable(Screen.Toolbox.route) {
            Toolbox()
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailsScreen(navController,id = id)
        }
    }
}