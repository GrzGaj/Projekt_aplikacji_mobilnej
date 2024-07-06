package com.example.projekt_aplikacji

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import com.example.projekt_aplikacji.ui.theme.Projekt_AplikacjiTheme

@Composable
fun LearnScreen() {
    var showLearnEx by remember { mutableStateOf(false)}
    var numberLearn by remember { mutableStateOf(0)}
    Column (
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
                text = "PRACTICE",
                fontSize = 40.sp,
                letterSpacing = 10.sp
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(5f)
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),)
        {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = { numberLearn = 1; showLearnEx = true;})
                    {
                        ButtonText(value = "Lesson -1-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = { numberLearn = 2; showLearnEx = true; })
                    {
                        ButtonText(value = "Lesson -2-")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = { numberLearn = 3; showLearnEx = true})
                    {
                        ButtonText(value = "Lesson -3-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberLearn = 4; showLearnEx = true })
                    {
                        ButtonText(value = "Lesson -4-")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberLearn = 5; showLearnEx = true })
                    {
                        ButtonText(value = "Lesson -5-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberLearn = 6; showLearnEx = true })
                    {
                        ButtonText(value = "Lesson -6-")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                )
                {
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberLearn = 7; showLearnEx = true })
                    {
                        ButtonText(value = "Lesson -7-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberLearn = 8; showLearnEx = true })
                    {
                        ButtonText(value = "Lesson -8-")
                    }
                }
            }
        }
        if (showLearnEx) {
            return when (numberLearn){
                1 -> LearnExScreen(numberLearn)
                2 -> LearnExScreen(numberLearn)
                3 -> LearnExScreen(numberLearn)
                4 -> LearnExScreen(numberLearn)
                5 -> LearnExScreen(numberLearn)
                6 -> LearnExScreen(numberLearn)
                7 -> LearnExScreen(numberLearn)
                8 -> LearnExScreen(numberLearn)
                else -> ComeSoonScreen()
            }

        }
    }
}

@Composable
fun ButtonText(value: String) {
    Text(modifier = Modifier
        .padding(10.dp),
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        lineHeight = 25.sp,
        text = value)
}

@Preview(showBackground = true)
@Composable
fun LearnPreview() {
    Projekt_AplikacjiTheme {
        LearnScreen()
    }
}