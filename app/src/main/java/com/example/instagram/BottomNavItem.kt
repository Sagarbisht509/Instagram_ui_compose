package com.example.instagram

sealed class BottomNavItem(
    val title: String,
    val route: String,
    val icon_outlined: Int? = null,
    val icon_filled: Int? = null,
) {
    object Home : BottomNavItem("Home", "home", R.drawable.home, R.drawable.home_filled)
    object Search : BottomNavItem("Search", "search", R.drawable.search, R.drawable.search_filled)
    object Reel : BottomNavItem("Reel", "reel", R.drawable.video, R.drawable.video_filled)
    object Notification : BottomNavItem("Notification", "notification", R.drawable.notification, R.drawable.notification_filled)
    object Profile : BottomNavItem("Profile", "profile")
}
