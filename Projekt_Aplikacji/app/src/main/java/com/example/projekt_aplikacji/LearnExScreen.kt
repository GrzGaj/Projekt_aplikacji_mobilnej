package com.example.projekt_aplikacji

import android.content.Context
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.projekt_aplikacji.ui.theme.Projekt_AplikacjiTheme

@Composable
fun LearnExScreen(value: Int) {
    val context = LocalContext.current
    val words = remember { readWordsFromFile(context, "words"+value+".csv") }
    val name = "lesson$value"
    val imageId = LocalContext.current.resources.getIdentifier(name, "drawable", LocalContext.current.packageName)

    var currentIndex by remember { mutableStateOf(0) }
    var showTranslation by remember { mutableStateOf(false) }

    var rotationState by remember { mutableStateOf(0f) }


    val animated by animateFloatAsState(
        targetValue = rotationState,
        animationSpec = tween(durationMillis = 1000))

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
                text = "LESSSON "+value,
                fontSize = 40.sp,
                letterSpacing = 10.sp
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),) {
            if (words.isNotEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                    Text(
                        text = if (showTranslation) words[currentIndex].second else words[currentIndex].first,
                        fontSize = 58.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .width(500.dp)
                            .height(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(4.dp, Color(0xFF969696), RoundedCornerShape(10.dp))
                            .graphicsLayer {
                                rotationY = animated
                            }
                            .clickable { rotationState += 360f; showTranslation = !showTranslation; }
                    )
                        }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        FilledTonalButton(modifier = Modifier
                            .height(75.dp)
                            .width(150.dp),
                            onClick = {
                                if (currentIndex > 0) {
                                    currentIndex--
                                    showTranslation = false
                                }
                            }
                        ) {
                            ButtonText("❮❮❮")
                        }

                        FilledTonalButton(modifier = Modifier
                            .height(75.dp)
                            .width(150.dp),
                            onClick = {
                                if (currentIndex < words.size - 1) {
                                    currentIndex++
                                    showTranslation = false
                                }
                            }
                        ) {
                            ButtonText("❯❯❯")
                        }
                    }
                }
            } else {
                Text("Brak słówek do wyświetlenia", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(4f)
            .verticalScroll(rememberScrollState()),)
        {
            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "Lesson Image",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text("Zdjęcie nie istnieje", Modifier.fillMaxWidth())
            }
        }
    }
}


fun readWordsFromFile(context: Context, filename: String): List<Pair<String, String>> {
    return try {
        val words = mutableListOf<Pair<String, String>>()
        context.assets.open(filename).bufferedReader().useLines { lines ->
            lines.forEach { line ->
                val parts = line.split(",")
                if (parts.size == 2) {
                    words.add(parts[0].trim() to parts[1].trim())
                }
            }
        }
        return words
    }catch (e: Exception) {
        e.printStackTrace()
        Log.e("LearnExScreen", "Błąd wczytywania pliku: ${e.message}")
        emptyList()
    }
}



@Preview(showBackground = true)
@Composable
fun LearnExPreview() {
    Projekt_AplikacjiTheme {
        LearnExScreen(1)
    }
}
