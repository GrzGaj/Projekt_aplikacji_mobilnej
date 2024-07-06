package com.example.projekt_aplikacji

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projekt_aplikacji.ui.theme.Projekt_AplikacjiTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    )
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color(0xFF4d1b7b)),
            contentAlignment = Alignment.Center)
        {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                text = "WELCOME",
                fontSize = 40.sp,
                letterSpacing = 10.sp
            )
    }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center) {
            Text(modifier = Modifier
                .padding(10.dp),
                textAlign = TextAlign.Center,
                text = "Aplikacja została stworzona do ułatwienia nauki słówek, w języku angileskim. Znajdują się tutaj fiszki do nauki słówek, proste zdania utrwalające gramatyke oraz testy sprawdzające wiedzę.",
                fontSize = 25.sp,
                )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color(0xFFc79dd7)),
            contentAlignment = Alignment.Center)
        {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                text = "TIPS",
                fontSize = 40.sp,
                letterSpacing = 10.sp
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),) {
            Text(fontSize = 15.sp,
                text =
                    "Codzienna Praktyka: Zrób z nauki angielskiego codzienny nawyk. Nawet 15 minut dziennie pomoże Ci zrobić ogromne postępy!\n" +
                    "\n" +
                    "Ustal Cele: Ustal sobie małe, osiągalne cele. Na przykład: nauka 10 nowych słówek dziennie lub przetłumaczenie jednego tekstu tygodniowo.\n" +
                            "\n" +
                    "Korzystaj z wielu żródeł: Oglądaj filmy, słuchaj muzyki lub podcastów, graj w gry po angielsku. Zanurzenie się w języku sprawia, że nauka staje się przyjemniejsza i bardziej naturalna."
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Projekt_AplikacjiTheme {
        HomeScreen()
    }
}