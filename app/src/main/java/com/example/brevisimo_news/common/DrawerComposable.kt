package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brevisimo_news.R
import com.example.brevisimo_news.domain.model.MediaDto
import com.example.brevisimo_news.domain.model.SourceDto
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerComposable (
    onSourceSelected: (MediaDto) -> Unit,
    mediaDto: List<MediaDto>,
    @StringRes text: Int,
    onSignOut: () -> Unit
){
    DrawerContent(
        onSignOut = onSignOut,
        onSourceSelected = onSourceSelected,
        text = text,
        mediaDto = mediaDto
    )
}


@Composable
fun DrawerContent(
    onSignOut: () -> Unit,
    onSourceSelected: (MediaDto) -> Unit,
    mediaDto: List<MediaDto>,
    @StringRes text: Int,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showFab by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    ModalDrawerSheet(Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        HorizontalDivider()

        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.weight(1f)) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    state = listState
                ) {
                    items(mediaDto) { mediaDto ->
                        DrawerItem(
                            modifier = Modifier,
                            onClick = {
                                onSourceSelected(mediaDto)
                            },
                            mediaDto = mediaDto
                        )
                    }
                }

                if (showFab) {
                    FabComposable(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp),
                        onFabClick = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(0)
                            }
                        },
                        icon = Icons.Filled.ArrowUpward
                    )
                }
            }

            HorizontalDivider()

            NavigationDrawerItem(
                label = { Text("Cerrar Sesión") },
                selected = false,
                icon = { Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null) },
                onClick = onSignOut,
                modifier = Modifier.padding(16.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent,
                    unselectedIconColor = MaterialTheme.colorScheme.error,
                    unselectedTextColor = MaterialTheme.colorScheme.error
                )
            )
        }
    }
}


@Composable
fun DrawerItem(
    modifier: Modifier = Modifier,
    mediaDto: MediaDto,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = mediaDto.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            thickness = 1.dp
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DrawerDarkPreview"
)
@Preview
@Composable
fun DrawerPreview() {
    Brevisimo_NewsTheme {
        val mediaDto = List(5) {
            MediaDto(
                id = null,
                name = "medio_de_noticias",
                description = "",
                url = "",
                category = "",
                language = "",
                country = ""
            )
        }

        DrawerComposable(
            onSourceSelected = {},
            text = R.string.drawer_composable,
            mediaDto = mediaDto,
            onSignOut = {}
        )
    }
}