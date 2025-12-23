package com.example.brevisimo_news

import androidx.compose.material3.DrawerState
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NewsAppState (
    val navHostController: NavHostController,
    val windowSizeClass: WindowSizeClass,
    val drawerState: DrawerState,
    private val coroutineScope: CoroutineScope,
    val snackbarHostState: SnackbarHostState
){

    fun showSnackbar(message: String){
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Short
            )
        }
    }

    /*fun navigateToProfile(isGuest: Boolean) {
        if (isGuest) {
            showSnackbar("Debe loguearse con una cuenta de Google para acceder al perfil")
        } else {
            navHostController.navigate(PROFILE_SCREEN)
        }
    }*/
    fun navigateBack() {
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
