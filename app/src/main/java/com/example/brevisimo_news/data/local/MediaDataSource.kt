package com.example.brevisimo_news.data.local

import com.example.brevisimo_news.domain.model.MediaDto
import javax.inject.Inject


class MediaDataSource @Inject constructor() {
    val media = listOf(
        MediaDto(
            id = "abc-news",
            name = "ABC News",
            description = "Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
            url = "https://abcnews.go.com",
            category = "general",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "aftenposten",
            name = "Aftenposten",
            description = "Norges ledende nettavis med alltid oppdaterte nyheter innenfor innenriks, utenriks, sport og kultur.",
            url = "https://www.aftenposten.no",
            category = "general",
            language = "no",
            country = "no"
        ),
        MediaDto(
            id = "al-jazeera-english",
            name = "Al Jazeera English",
            description = "News, analysis from the Middle East and worldwide, multimedia and interactives, opinions, documentaries, podcasts, long reads and broadcast schedule.",
            url = "https://www.aljazeera.com",
            category = "general",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "ansa",
            name = "ANSA.it",
            description = "Agenzia ANSA: ultime notizie, foto, video e approfondimenti su: cronaca, politica, economia, regioni, mondo, sport, calcio, cultura e tecnologia.",
            url = "https://www.ansa.it",
            category = "general",
            language = "it",
            country = "it"
        ),
        MediaDto(
            id = "ars-technica",
            name = "Ars Technica",
            description = "The PC enthusiast's resource. Power users and the tools they love, without computing religion.",
            url = "https://arstechnica.com",
            category = "technology",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "ary-news",
            name = "Ary News",
            description = "ARY News is a Pakistani news channel committed to bring you up-to-the minute Pakistan news and featured stories from around Pakistan and all over the world.",
            url = "https://arynews.tv/ud/",
            category = "general",
            language = "ud",
            country = "pk"
        ),
        MediaDto(
            id = "associated-press",
            name = "Associated Press",
            description = "The AP delivers in-depth coverage on the international, politics, lifestyle, business, and entertainment news.",
            url = "https://apnews.com/",
            category = "general",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "australian-financial-review",
            name = "Australian Financial Review",
            description = "The Australian Financial Review reports the latest news from business, finance, investment and politics, updated in real time. It has a reputation for independent, award-winning journalism and is essential reading for the business and investor community.",
            url = "http://www.afr.com",
            category = "business",
            language = "en",
            country = "au"
        ),
        MediaDto(
            id = "axios",
            name = "Axios",
            description = "Axios are a new media company delivering vital, trustworthy news and analysis in the most efficient, illuminating and shareable ways possible.",
            url = "https://www.axios.com",
            category = "general",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "bbc-news",
            name = "BBC News",
            description = "Use BBC News for up-to-the-minute news, breaking news, video, audio and feature stories. BBC News provides trusted World and UK news as well as local and regional perspectives. Also entertainment, business, science, technology and health news.",
            url = "https://www.bbc.co.uk/news",
            category = "general",
            language = "en",
            country = "gb"
        ),
        MediaDto(
            id = "bild",
            name = "Bild",
            description = "Die Seite 1 für aktuelle Nachrichten und Themen, Bilder und Videos aus den Bereichen News, Wirtschaft, Politik, Show, Sport, und Promis.",
            url = "http://www.bild.de",
            category = "general",
            language = "de",
            country = "de"
        ),
        MediaDto(
            id = "blasting-news-br",
            name = "Blasting News (BR)",
            description = "Descubra a seção brasileira da Blasting News, a primeira revista feita pelo  público, com notícias globais e vídeos independentes. Junte-se a nós e torne- se um repórter.",
            url = "https://br.blastingnews.com",
            category = "general",
            language = "pt",
            country = "br"
        ),
        MediaDto(
            id = "bloomberg",
            name = "Bloomberg",
            description = "Bloomberg delivers business and markets news, data, analysis, and video to the world, featuring stories from Businessweek and Bloomberg News.",
            url = "http://www.bloomberg.com",
            category = "business",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "cbc-news",
            name = "CBC News",
            description = "CBC News is the division of the Canadian Broadcasting Corporation responsible for the news gathering and production of news programs on the corporation's English-language operations, namely CBC Television, CBC Radio, CBC News Network, and CBC.ca.",
            url = "http://www.cbc.ca/news",
            category = "general",
            language = "en",
            country = "ca"
        ),
        MediaDto(
            id = "cnn",
            name = "CNN",
            description = "View the latest news and breaking news today for U.S., world, weather, entertainment, politics and health at CNN",
            url = "http://us.cnn.com",
            category = "general",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "crypto-coins-news",
            name = "Crypto Coins News",
            description = "Providing breaking cryptocurrency news - focusing on Bitcoin, Ethereum, ICOs, blockchain technology, and smart contracts.",
            url = "https://www.ccn.com",
            category = "technology",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "espn",
            name = "ESPN",
            description = "ESPN has up-to-the-minute sports news coverage, scores, highlights and commentary for NFL, MLB, NBA, College Football, NCAA Basketball and more.",
            url = "https://www.espn.com",
            category = "sports",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "fox-sports",
            name = "Fox Sports",
            description = "Find live scores, player and team news, videos, rumors, stats, standings, schedules and fantasy games on FOX Sports.",
            url = "http://www.foxsports.com",
            category = "sports",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "fox-news",
            name = "Fox News",
            description = "Breaking News, Latest News and Current News from FOXNews.com. Breaking news and video. Latest Current News: U.S., World, Entertainment, Health, Business, Technology, Politics, Sports.",
            url = "http://www.foxnews.com",
            category = "general",
            language = "en",
            country = "us"
        ),
        MediaDto(
            id = "globo",
            name = "Globo",
            description = "Só na globo.com você encontra tudo sobre o conteúdo e marcas do Grupo Globo. O melhor acervo de vídeos online sobre entretenimento, esportes e jornalismo do Brasil.",
            url = "http://www.globo.com/",
            category = "general",
            language = "pt",
            country = "br"
        ),
        MediaDto(
            id = "infobae",
            name = "Infobae",
            description = "Noticias de Argentina y del mundo en tiempo real. Información, videos y fotos sobre los hechos más relevantes y sus protagonistas. Léelo antes en infobae.",
            url = "http://www.lagaceta.com.ar",
            category = "general",
            language = "es",
            country = "ar"
        ),
        MediaDto(
            id = "la-nacion",
            name = "La Nacion",
            description = "Información confiable en Internet. Noticias de Argentina y del mundo - ¡Informate ya!",
            url = "http://www.lanacion.com.ar",
            category = "general",
            language = "es",
            country = "ar"
        ),
        MediaDto(
            id = "national-geographic",
            name = "National Geographic",
            description = "Reporting our world daily: original nature and science news from National Geographic.",
            url = "https://www.reuters.com",
            category = "science",
            language = "en",
            country = "us"
        )
    )
}