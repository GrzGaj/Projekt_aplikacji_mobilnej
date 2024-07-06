package com.example.projekt_aplikacji

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.io.BufferedReader
import java.io.InputStreamReader

@Composable
fun TranslationScreen(number: Int) {
    val context = LocalContext.current
    val fileName = "words$number.txt"
    val (wordEntries, setWordEntries) = remember { mutableStateOf<List<Pair<String, String>>>(emptyList()) }
    val (answers, setAnswers) = remember { mutableStateOf(mutableMapOf<String, String>()) }

    LaunchedEffect(Unit) {
        val words = loadWordsFromFile(context, fileName)
        setWordEntries(words)
        setAnswers(words.associate { it.first to "" }.toMutableMap())
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        wordEntries.forEach { (polish, _) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = polish, modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = answers[polish] ?: "",
                    onValueChange = { newAnswer -> setAnswers(answers.toMutableMap().apply { this[polish] = newAnswer }) },
                    label = { Text("Tłumaczenie") },
                    modifier = Modifier.weight(2f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            FilledTonalButton(onClick = { checkAnswers(wordEntries, answers, context) }) {
                Text(text = "Sprawdź")
            }
            FilledTonalButton(onClick = { setAnswers(wordEntries.associate { it.first to "" }.toMutableMap()) }) {
                Text(text = "Resetuj")
            }
        }
    }
}

fun loadWordsFromFile(context: Context,fileName: String): List<Pair<String, String>> {
    val words = mutableListOf<Pair<String, String>>()
    val inputStream = context.assets.open(fileName)
    val reader = BufferedReader(InputStreamReader(inputStream))
    reader.useLines { lines ->
        lines.forEach { line ->
            val (polish, english) = line.split('\t')
            words.add(Pair(polish, english))
        }
    }
    return words
}

private fun checkAnswers(wordEntries: List<Pair<String, String>>, answers: Map<String, String>, context: Context) {
    val correctCount = wordEntries.count { (polish, correctAnswer) ->
        answers[polish]?.trim()?.equals(correctAnswer, ignoreCase = true) == true
    }

    val message = "Zgadłeś $correctCount z ${wordEntries.size} słówek!"

    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
