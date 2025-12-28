package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brevisimo_news.R
import com.example.brevisimo_news.screens.home.NavigationDestination
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme


@Composable
fun NavigationRailComposable(
    modifier: Modifier = Modifier,
    @StringRes textHome: Int,
    @StringRes textProfile: Int,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onDrawerClick: () -> Unit,
    iconHome: ImageVector,
    iconProfile: ImageVector,
    iconMenu: ImageVector,
    selectedDestination: NavigationDestination
) {
    NavigationRail(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        header = {
            IconButton(onClick = onDrawerClick) {
                Icon(imageVector = iconMenu,
                    contentDescription = "Abrir menú"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            NavigationRailItem(
                selected = selectedDestination == NavigationDestination.HOME,
                onClick = onHomeClick,
                icon = {
                    Icon(
                        imageVector = iconHome,
                        contentDescription = "Inicio")
                       },
                label = { Text(stringResource(textHome)) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            NavigationRailItem(
                selected = selectedDestination == NavigationDestination.PROFILE,
                onClick = onProfileClick,
                icon = {
                    Icon(
                        imageVector = iconProfile,
                        contentDescription = "Perfil") },
                label = { Text(stringResource(textProfile)) }
            )
        }
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "NavigationRailDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun NavigationRailPreview() {
    Brevisimo_NewsTheme{
        NavigationRailComposable(
            modifier = Modifier,
            onHomeClick = {},
            onProfileClick = {},
            onDrawerClick = {},
            selectedDestination = NavigationDestination.HOME,
            textHome = R.string.home_navigation_bar ,
            textProfile = R.string.profile_navigation_bar,
            iconMenu = Icons.Default.Menu,
            iconHome = Icons.Default.Home,
            iconProfile = Icons.Default.AccountCircle
        )
    }
}