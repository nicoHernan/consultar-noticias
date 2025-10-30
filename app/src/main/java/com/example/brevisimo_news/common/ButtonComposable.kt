package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun FabComposable(
    modifier: Modifier = Modifier,
    onFabClick: () -> Unit,
    icon: ImageVector
) {
    ExtendedFloatingActionButton(
        onClick = onFabClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Ir al inicio"
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "FabDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun FabPreview(){
    Brevisimo_NewsTheme{
        FabComposable(
            modifier = Modifier,
            onFabClick = {},
            icon = Icons.Filled.ArrowUpward
        )
    }
}
