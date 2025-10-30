package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.brevisimo_news.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.MediaDto
import com.example.brevisimo_news.domain.model.SourceDto
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun VerticalCardComposable (
    modifier: Modifier = Modifier,
    articleDto: ArticleDto? = null,
    @DrawableRes previewImage: Int? = R.drawable.imagen_para_renderizar,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column() {
            AsyncImage(
                    model = if (LocalInspectionMode.current) {
                        previewImage
                    } else{
                        articleDto?.urlToImage
                    },
                placeholder = if (previewImage != null) painterResource(id = previewImage) else null,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = articleDto?.title ?: "Titulo no disponible",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 3
            )

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = articleDto?.source?.name ?:"unkown source",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = articleDto?.publishedAt ?: "",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun HorizontalCardComposable(
    modifier: Modifier = Modifier,
    articleDto: ArticleDto,
    @DrawableRes previewImage: Int? = null,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = if (LocalInspectionMode.current) {
                    previewImage
                } else {
                    articleDto.urlToImage
                },
                placeholder = if (previewImage != null) painterResource(id = previewImage) else null,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .weight(0.4f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = articleDto.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = articleDto.source?.name ?: "unkown source",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = articleDto.publishedAt,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "HorizontalDarkPreview"
)
@Preview
@Composable
fun HorizontalPreview() {
    Brevisimo_NewsTheme {
        val articleDto = ArticleDto(
            source = SourceDto(
                id = "",
                name = "Bbc News"
            ),
            author = "Josephine Walker",
            title = "These are the agencies Trump is purging during the shutdown - Axios",
            description = "Thousands are being let go from agencies overseeing health care, the environment and education.",
            url = "https://www.axios.com/2025/10/10/trump-federal-layoffs-treasury-education-health",
            urlToImage = "https://images.axios.com/aQmahivTarO_bl7hCJ7B1Pe5BNQ=/0x73:8076x4616/1366x768/2025/10/10/1760128847374.jpg",
            publishedAt = "2025-10-11T15:44:45Z",
            content = "What they're saying: A spokesperson for the largest federal employee union, the American Federation of Government Employees, told Axios that the Trump administration is \\\"illegally\\\" firing thousands o… [+4094 chars]"
        )
        HorizontalCardComposable(
            modifier = Modifier,
            articleDto = articleDto,
            previewImage = R.drawable.imagen_para_renderizar ,
            onClick = {}
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "VerticalDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun VerticalPreview() {
    Brevisimo_NewsTheme {
        val articleDto = ArticleDto(
            source = SourceDto(
                id = "",
                name = "Bbc News"
            ),
            author = "Josephine Walker",
            title = "These are the agencies Trump is purging during the shutdown - Axios",
            description = "Thousands are being let go from agencies overseeing health care, the environment and education.",
            url = "https://www.axios.com/2025/10/10/trump-federal-layoffs-treasury-education-health",
            urlToImage = "https://images.axios.com/aQmahivTarO_bl7hCJ7B1Pe5BNQ=/0x73:8076x4616/1366x768/2025/10/10/1760128847374.jpg",
            publishedAt = "2025-10-11T15:44:45Z",
            content = "What they're saying: A spokesperson for the largest federal employee union, the American Federation of Government Employees, told Axios that the Trump administration is \\\"illegally\\\" firing thousands o… [+4094 chars]"
        )
        VerticalCardComposable(
            modifier = Modifier,
            articleDto = articleDto,
            previewImage = R.drawable.imagen_para_renderizar ,
            onClick = {}
        )
    }
}