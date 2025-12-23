package com.example.brevisimo_news

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.brevisimo_news.common.DrawerComposable
import com.example.brevisimo_news.screens.ProfileScreen
import com.example.brevisimo_news.screens.category.CategoryScreen
import com.example.brevisimo_news.screens.home.HomeScreen
import com.example.brevisimo_news.screens.home.HomeSideEffect
import com.example.brevisimo_news.screens.home.HomeViewModel
import com.example.brevisimo_news.screens.login.LoginScreen
import com.example.brevisimo_news.screens.splash.SplashScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun NewsApp(
    windowSizeClass: WindowSizeClass,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val appState = rememberAppState(windowSizeClass = windowSizeClass, coroutineScope = coroutineScope)


    val uiState by homeViewModel.homeUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        homeViewModel.sideEffects.collect { effect ->
            when (effect) {
                is HomeSideEffect.OpenExternalUrl -> {
                    appState.drawerState.close()

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(effect.url))
                    context.startActivity(intent)
                }
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = appState.drawerState,
        drawerContent = {
            DrawerComposable(
                onSourceSelected = { mediaDto ->
                    homeViewModel.onDrawerMediaClick(mediaDto = mediaDto )
                },
                text = R.string.drawer_composable,
                mediaDto = uiState.newsByDomain
            )
        },

        content = {
            Scaffold() { paddingValues ->
                NavHost(
                    modifier = Modifier.padding(paddingValues),
                    navController = appState.navHostController,
                    startDestination = SPLASH_SCREEN
                ) {
                    newsGraph(appState)
                }
            }
        }
    )

}


@Composable
fun rememberAppState(
    navHostController: NavHostController = rememberNavController(),
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): NewsAppState {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    return remember(navHostController, windowSizeClass, coroutineScope, snackbarHostState) {
        NewsAppState(
            navHostController,
            windowSizeClass = windowSizeClass ,
            drawerState = drawerState,
            coroutineScope = coroutineScope,
            snackbarHostState = snackbarHostState
        )
    }
}

fun NavGraphBuilder.newsGraph(newsAppState: NewsAppState) {
    composable(SPLASH_SCREEN) {
        SplashScreen(
            openAndPopUp = { route, popUp ->
                newsAppState.navigateAndPopUp(route = route, popUp = popUp)
            },
            splashViewModel = hiltViewModel()
        )
    }

    composable(LOGIN_SCREEN) {
        LoginScreen(
            modifier = Modifier,
            onSignInGuest = {
                newsAppState.navigateAndPopUp(HOME_SCREEN, LOGIN_SCREEN)
            },
            onSignInGoogle = {}
        )
    }

    composable(HOME_SCREEN) {
        HomeScreen(
            modifier = Modifier,
            homeViewModel = hiltViewModel(),
            windowSizeClass = newsAppState.windowSizeClass,
            newsAppState = newsAppState
        )
    }

    composable(PROFILE_SCREEN) {
        ProfileScreen(
        )
    }

    composable(
        route = "$CATEGORY_SCREEN/{category_name}",
        arguments = listOf(
            navArgument(CATEGORY_ARGUMENTS) { type = NavType.StringType }
        )
    ){backstackentry ->
        val categoryName = backstackentry
            .arguments?.getString(CATEGORY_ARGUMENTS) ?: "general"

        CategoryScreen(
            modifier = Modifier,
            categoryViewModel = hiltViewModel(),
            windowSizeClass = newsAppState.windowSizeClass,
            categoryName = categoryName,
            newsAppState = newsAppState
        )
    }
}