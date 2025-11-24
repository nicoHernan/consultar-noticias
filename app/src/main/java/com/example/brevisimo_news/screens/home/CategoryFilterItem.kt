package com.example.brevisimo_news.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun CategoryFilterItem (
    modifier: Modifier = Modifier,
    categoryName: String,
    onClick: (String) -> Unit
){
    Text(
        text = categoryName,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable{
                onClick(categoryName)
            },
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "CategoryItemDarkPreview"
)
@Preview
@Composable
fun CategoryItemPreview() {
    Brevisimo_NewsTheme{
        CategoryFilterItem(
          modifier = Modifier,
            categoryName = "Technology",
            onClick = {}
        )
    }
}