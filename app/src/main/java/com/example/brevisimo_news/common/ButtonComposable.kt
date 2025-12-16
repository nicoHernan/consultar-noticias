package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.GMobiledata
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brevisimo_news.R
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun ButtonComposable(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @StringRes text: Int,
    icon: ImageVector
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
        )
    ) {
        Icon(imageVector = icon,
            contentDescription = null
        )
        Spacer(Modifier.width(8.dp))
        Text(stringResource(text))
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "ButtonDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Brevisimo_NewsTheme {
        ButtonComposable(
            modifier = Modifier,
            onClick = {},
            text = R.string.button_composable,
            icon = Icons.Filled.FlashOn
        )
    }
}

@Composable
fun OutlinedButtonComposable(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @StringRes text: Int,
    icon: ImageVector
){
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Icon(
            modifier = Modifier.size(35.dp),
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(8.dp))
        Text(stringResource(text))
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "OutlinedButtonDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun OutlinedButtonPreview() {
    Brevisimo_NewsTheme {
        OutlinedButtonComposable(
            modifier = Modifier,
            onClick = {},
            text = R.string.outlinedButton_composable,
            icon = Icons.Filled.GMobiledata
        )
    }
}

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
