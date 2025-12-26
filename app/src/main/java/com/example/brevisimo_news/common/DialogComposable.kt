package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.brevisimo_news.screens.home.HomeUiState
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun AIDialog(
    homeUiState: HomeUiState,
    onDismissDialog: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissDialog,
        title = {
            when {
                homeUiState.isAiLoading -> {
                    Text(text = "Obteniendo Contexto...")
                }

                homeUiState.entityDescription.isNotEmpty() -> {
                    Text(text = "Contexto: ${homeUiState.entityName}")
                }

                homeUiState.isError -> {
                    Text(text = "Atención")
                }
            }
        },
        text = {
            when {
                homeUiState.isAiLoading -> {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                homeUiState.isError -> {
                    Text(
                        text = "Ocurrió un error inesperado al obtener el contexto de la IA.",
                        color = MaterialTheme.colorScheme.error)
                }
                homeUiState.entityDescription.isNotEmpty() -> {
                    Text(text = homeUiState.entityDescription)
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismissDialog) {
                Text("CERRAR")
            }
        }
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "AIDialogDarkPreview"
)
@Preview
@Composable
fun AIDialogPreview() {
    Brevisimo_NewsTheme {
        val homeUiState = HomeUiState()
        AIDialog(
            homeUiState = homeUiState,
            onDismissDialog = {}
        )
    }
}