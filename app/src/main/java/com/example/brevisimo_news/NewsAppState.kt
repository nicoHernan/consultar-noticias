package com.example.brevisimo_news

import androidx.compose.material3.DrawerState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NewsAppState (
    val navHostController: NavHostController,
    val windowSizeClass: WindowSizeClass,
    val drawerState: DrawerState,
    private val coroutineScope: CoroutineScope
){

    fun popUp() {
        navHostController.popBackStack()
    }

    fun navigate(route: String) {
        navHostController.navigate(route) {
            launchSingleTop = true
        }
    }

    fun navigateAndPopUp(route: String, popUp: String) {
        navHostController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) {
                inclusive = true
            }
        }
    }

    fun clearAndNavigate(route: String) {
        navHostController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) {
                inclusive = true
            }
        }
    }

    fun openDrawer() {
        coroutineScope.launch {
            drawerState.open()
        }
    }

    fun navigateToCategory(categoryName: String) {
        navHostController.navigate(route = "$CATEGORY_SCREEN/$categoryName") {
            launchSingleTop = true
        }
    }

}
