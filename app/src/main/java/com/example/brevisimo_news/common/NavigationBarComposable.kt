package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.brevisimo_news.R
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun NavigationBarComposable(
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
    name = "NavigationBarDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun NavigationBarPreview(){
    Brevisimo_NewsTheme {
        NavigationBarComposable(
            modifier = Modifier,
            textHome = R.string.home_navigation_bar,
            textProfile = R.string.profile_navigation_bar,
            iconHome = Icons.Filled.Home,
            iconProfile = Icons.Filled.Person,
            onClick = {}
        )
    }
}