package com.example.brevisimo_news.screens.home

import android.R.attr.navigationIcon
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.brevisimo_news.NewsAppState
import com.example.brevisimo_news.R
import com.example.brevisimo_news.common.NavigationBarComposable
import com.example.brevisimo_news.common.SearchComposable
import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.SourceDto
import com.example.brevisimo_news.ui.theme.Brevisimo_NewsTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    windowSizeClass: WindowSizeClass,
    appState: NewsAppState
) {
    val homeUiState by homeViewModel.homeUiState.collectAsStateWithLifecycle()

    HomePortraitLayout(
        modifier = modifier,
        categories = homeUiState.categories,
        homeUiState = homeUiState,
        onSearch = homeViewModel::onSearch,
        articleDto = homeUiState.newsInUs,
        openDrawer = appState::openDrawer
    )
}



@Composable
fun HomeContent (
    modifier: Modifier = Modifier,
    categories: List<String>,
    articleDto: List<ArticleDto>,
    homeUiState: HomeUiState,
    onSearch: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        SearchComposable(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = homeUiState.valueSearch,
            onValueChange = onSearch,
            placeholder = R.string.placeholder_search,
            icon = Icons.Filled.Search
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                Text(
                    text = category,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))


        if (articleDto.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No hay noticias para mostrar o la búsqueda no arrojó resultados.",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(32.dp)
                )
            }
        } else {

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(articleDto) { articleDto ->
                    VerticalArticleItem(
                        modifier = Modifier.fillMaxWidth(),
                        articleDto = articleDto,
                        previewImage = R.drawable.imagen_para_renderizar,
                        onClick = {}
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePortraitLayout (
    modifier: Modifier = Modifier,
    categories: List<String>,
    articleDto: List<ArticleDto>,
    homeUiState: HomeUiState,
    onSearch: (String) -> Unit,
    openDrawer: () -> Unit
){
    Brevisimo_NewsTheme{
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    navigationIcon = {
                        IconButton(onClick = openDrawer) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Abrir Menú"
                            )
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues = paddingValues)
                        .fillMaxSize()
                ) {
                    HomeContent(
                        modifier = Modifier.fillMaxSize(),
                        categories = categories,
                        homeUiState = homeUiState,
                        onSearch = onSearch,
                        articleDto = articleDto
                    )
                }
            },
            bottomBar = {
                NavigationBarComposable(
                    modifier = modifier,
                    textHome = R.string.home_navigation_bar,
                    textProfile = R.string.profile_navigation_bar,
                    iconHome = Icons.Filled.Home,
                    iconProfile = Icons.Filled.Person,
                    onClick = {}
                )
            }
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "PortraitDarkPreview"
)
@Preview(showBackground = true)
@Composable
fun PortraitPreview() {

    val uiState = HomeUiState(valueSearch = "")
    val previewCategories = listOf("Business", "General", "Entertainment", "Health", "Science", "Sports", "Technology")

    val articleDto = List(10){
        ArticleDto(
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
    }
    Brevisimo_NewsTheme{
        HomePortraitLayout(
            modifier = Modifier,
            categories = previewCategories,
            homeUiState = uiState,
            onSearch = {},
            articleDto = articleDto,
            openDrawer = {}
        )
    }
}