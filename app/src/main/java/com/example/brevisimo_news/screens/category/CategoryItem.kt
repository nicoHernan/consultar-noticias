package com.example.brevisimo_news.screens.category

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.brevisimo_news.R
import com.example.brevisimo_news.common.CategoryCardComposable
import com.example.brevisimo_news.common.VerticalCardComposable
import com.example.brevisimo_news.domain.model.MediaDto
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun CategoryItem (
    modifier: Modifier = Modifier,
    mediaDto: MediaDto,
    onClick: (MediaDto) -> Unit
){
    CategoryCardComposable(
        modifier = modifier,
        onClick = onClick,
        mediaDto = mediaDto
    )
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "CategoryItemDarkPreview"
)
@Preview
@Composable
fun CategoryItemPreview(){
    Brevisimo_NewsTheme {
        val mediaDto = MediaDto(
            id = null,
            name = "BBC Sport",
            description = "The home of BBC Sport online. Includes live sports coverage, breaking news, results, video, audio and analysis on Football, F1, Cricket, Rugby Union, Rugby League, Golf, Tennis and all the main world sports, plus major events such as the Olympic Games.",
            url = "http://www.bbc.co.uk/sport",
            category = "sports",
            language = "en",
            country = "gb"
        )

        CategoryItem(
            modifier = Modifier,
            mediaDto = mediaDto,
            onClick = {}
        )
    }
}