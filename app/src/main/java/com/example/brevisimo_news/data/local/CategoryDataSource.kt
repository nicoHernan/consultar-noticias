package com.example.brevisimo_news.data.local

import com.example.brevisimo_news.domain.model.SourceDto
import javax.inject.Inject


class CategoryDataSource @Inject constructor() {
    val categories = listOf(
        SourceDto(
            id = null,
            name = "Business"
        ),
        SourceDto(
            id = null,
            name = "General"
        ),
        SourceDto(
            id = null,
            name = "Entertainment"
        ),
        SourceDto(
            id = null,
            name = "Health"
        ),
        SourceDto(
            id = null,
            name = "Science"
        ),
        SourceDto(
            id = null,
            name = "Sports"
        ),
        SourceDto(
            id = null,
            name = "Technology"
        )
    )
}