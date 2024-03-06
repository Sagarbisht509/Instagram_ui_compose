package com.example.instagram

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagram.screens.HomeScreen
import com.example.instagram.screens.NotificationScreen
import com.example.instagram.screens.ProfileScreen
import com.example.instagram.screens.ReelScreen
import com.example.instagram.screens.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {

        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }

        composable(BottomNavItem.Search.route) {
            SearchScreen()
        }

        composable(BottomNavItem.Reel.route) {
            ReelScreen()
        }

        composable(BottomNavItem.Notification.route) {
            NotificationScreen()
        }

        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
    }
}