package com.example.brevisimo_news.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme
import kotlin.math.absoluteValue

@Composable
fun MediaSourceIcon(
    name: String,
    modifier: Modifier = Modifier
) {
    val colorPalette = remember {
        listOf(
            Color(0xFFF44336),
            Color(0xFFE91E63),
            Color(0xFF9C27B0),
            Color(0xFF3F51B5),
            Color(0xFF2196F3),
            Color(0xFF00BCD4),
            Color(0xFF009688),
            Color(0xFF4CAF50),
            Color(0xFFFFC107),
            Color(0xFFFF9800)
        )
    }

    val colorIndex = name.hashCode().absoluteValue % colorPalette.size
    val color = colorPalette[colorIndex]

    val initials = name
        .split(" ")
        .mapNotNull { it.firstOrNull()?.toString() }
        .take(2)
        .joinToString("")
        .uppercase()

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(color.copy(alpha = 0.7f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "MediaSourceDarkPreview"
)
@Preview
@Composable
fun MediaSourcePreview(){
    Brevisimo_NewsTheme {
        MediaSourceIcon(
            name = "BBC Sport"
        )
    }
}