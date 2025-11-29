package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import com.example.brevisimo_news.R
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBarComposable(
    modifier: Modifier = Modifier,
    @StringRes titleText: Int,
    onNavigationIconClick: () -> Unit,
    navigationIconVector: ImageVector
) {
    NavigationBar(
        modifier = modifier
    ){
        TopAppBar(
            modifier = modifier,

            title = {
                Text(
                    text = stringResource(titleText),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.SemiBold
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = navigationIconVector,
                        contentDescription = "go back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}


@Composable
fun BottomNavigationBarComposable(
    modifier: Modifier = Modifier,
    @StringRes textHome: Int,
    @StringRes textProfile: Int,
    iconHome: ImageVector,
    iconProfile: ImageVector,
    onClick: () -> Unit
) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = iconHome,
                    contentDescription = "home icon"
                )
            },
            label = {
                Text(text = stringResource(textHome))
            },
            selected = false,
            onClick = onClick
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = iconProfile,
                    contentDescription = "profile icon"
                )
            },
            label = {
                Text(text = stringResource(textProfile))
            },
            selected = false,
            onClick = onClick
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
            onClick = {}
        )
    }
}