package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.brevisimo_news.R
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchComposable(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholder: Int,
    icon: ImageVector
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        value = value,
        onValueChange = {newValue->
            onValueChange(newValue)
        },
        placeholder = {
            Text(
                text = stringResource(placeholder)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "search icon"
            )
        }
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DarkPreview"
)
@Preview(showBackground = true)
@Composable
fun SearchPreview(){
    SearchComposable(
        modifier = Modifier,
        value = "",
        onValueChange = {},
        placeholder = R.string.placeholder_search,
        icon = Icons.Filled.Search
    )
}
