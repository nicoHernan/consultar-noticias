package com.example.brevisimo_news.screens.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ViewList
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun ProfileScreen (
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel()
){
    val profileUiState by profileViewModel.profileUiState.collectAsStateWithLifecycle()

    val pickMedia = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        profileViewModel.onProfileImage(uri)
    }

    ProfileContent(
        modifier = modifier,
        profileUiState = profileUiState,
        onPickImage = {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        },
        onLayoutChange = { isGrid ->
            profileViewModel.setLayout(isGrid)
        }
    )
}


@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    profileUiState: ProfileUiState,
    onPickImage: () -> Unit,
    onLayoutChange: (Boolean) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = profileUiState.tempLocalUri ?: profileUiState.photoUrl,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .clickable { onPickImage() },
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(16.dp))
        Text(text = profileUiState.name, style = MaterialTheme.typography.titleLarge)
        Text(text = profileUiState.email, style = MaterialTheme.typography.bodyMedium)

        HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

        ListItem(
            headlineContent = { Text("Diseño de noticias") },
            supportingContent = {
                Text(if (profileUiState.isGridLayout) "Vista Cuadrícula" else "Vista Lista")
            },
            leadingContent = {
                Icon(
                    if (profileUiState.isGridLayout) Icons.Default.GridView else Icons.Default.ViewList,
                    contentDescription = null
                )
            },
            trailingContent = {
                Switch(
                    checked = profileUiState.isGridLayout,
                    onCheckedChange = { onLayoutChange(it) }
                )
            }
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "ProfileDarkPreview"
)

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Brevisimo_NewsTheme {
        val profileUiState = ProfileUiState(
            isLoading = false,
            name = "Hernán",
            email = "email@gmail.com",
            photoUrl = null,
            isGridLayout = false,
            tempLocalUri = null,
            error = null
        )
        ProfileContent(
            modifier = Modifier,
            profileUiState = profileUiState,
            onPickImage = {},
            onLayoutChange = {}
        )
    }
}