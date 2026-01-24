package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brevisimo_news.R
import com.example.brevisimo_news.screens.home.NavigationDestination
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun navigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = MaterialTheme.colorScheme.primary,
    selectedTextColor = MaterialTheme.colorScheme.primary,
    indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBarComposable(
    modifier: Modifier = Modifier,
    @StringRes titleText: Int,
    onNavigationIconClick: () -> Unit,
    navigationIconVector: ImageVector
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(titleText),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = navigationIconVector,
                    contentDescription = "go back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}


@Composable
fun BottomNavigationBarComposable(
    modifier: Modifier = Modifier,
    @StringRes textHome: Int,
    @StringRes textProfile: Int,
    @StringRes textBookmarks: Int,
    iconHome: ImageVector,
    iconBookmarks: ImageVector,
    iconProfile: ImageVector,
    onHomeNavigationIcon: () -> Unit,
    onBookmarksNavigationIcon: () -> Unit,
    onProfileNavigationIcon: () -> Unit,
    selectedDestination: NavigationDestination
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        tonalElevation = 0.dp
    ) {
        val isHomeSelected = selectedDestination == NavigationDestination.HOME
        NavigationBarItem(
            selected = isHomeSelected,
            onClick = onHomeNavigationIcon,
            icon = {
                Icon(
                    imageVector = if (isHomeSelected) iconHome else Icons.Outlined.Home,
                    contentDescription = "home icon"
                )
            },
            label = {
                Text(
                    text = stringResource(textHome),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = if (isHomeSelected) FontWeight.ExtraBold else FontWeight.Medium,
                    letterSpacing = 0.5.sp
                )
            },
            colors = navigationBarItemColors()
        )
        val isProfileSelected = selectedDestination == NavigationDestination.PROFILE
        NavigationBarItem(
            selected = isProfileSelected,
            onClick = onProfileNavigationIcon,
            icon = {
                Icon(
                    imageVector = if (isProfileSelected) iconProfile else Icons.Outlined.Person,
                    contentDescription = "profile icon"
                )
            },
            label = {
                Text(
                    text = stringResource(textProfile),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = if (isProfileSelected) FontWeight.ExtraBold else FontWeight.Medium
                )
            },
            colors = navigationBarItemColors()
        )
        val isBookmarksSelected = selectedDestination == NavigationDestination.BOOKMARKS
        NavigationBarItem(
            selected = isBookmarksSelected,
            onClick = onBookmarksNavigationIcon,
            icon = {
                Icon(
                    imageVector = if (isBookmarksSelected) iconBookmarks else Icons.Outlined.BookmarkBorder,
                    contentDescription = "BOOKMARKS"
                )
            },
            label = {
                Text(
                    text = stringResource(textBookmarks),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = if (isBookmarksSelected) FontWeight.ExtraBold else FontWeight.Medium
                )
            },
            colors = navigationBarItemColors()
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "TopNavigationDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun TopNavigationPreview(){
    Brevisimo_NewsTheme {
        TopNavigationBarComposable(
           modifier = Modifier,
            titleText = R.string.top_navigation_bar,
            onNavigationIconClick = {},
            navigationIconVector = Icons.Filled.ArrowBack
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "BottomNavigationDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview(){
    Brevisimo_NewsTheme {
        BottomNavigationBarComposable(
            modifier = Modifier,
            textHome = R.string.home_navigation_bar,
            textProfile = R.string.profile_navigation_bar,
            iconHome = Icons.Filled.Home,
            iconProfile = Icons.Filled.Person,
            onHomeNavigationIcon = {},
            onProfileNavigationIcon = {},
            selectedDestination = NavigationDestination.HOME,
            textBookmarks = R.string.bookmarks_navigation_bar,
            iconBookmarks = Icons.Filled.BookmarkBorder,
            onBookmarksNavigationIcon = {}
        )
    }
}