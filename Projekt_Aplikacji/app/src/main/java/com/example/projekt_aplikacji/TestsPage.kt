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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projekt_aplikacji.ui.theme.Projekt_AplikacjiTheme

@Composable
fun TestsScreen() {
    var showTestEx by remember { mutableStateOf(false) }
    var numberTest by remember { mutableStateOf(0) }

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
                text = "EXAMS",
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
                        onClick = {numberTest = 1; showTestEx = true;})
                    {
                        ButtonText(value = "Test -1-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberTest = 2; showTestEx = true;})
                    {
                        ButtonText(value = "Test -2-")
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
                        onClick = {numberTest = 3; showTestEx = true; })
                    {
                        ButtonText(value = "Test -3-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberTest = 4; showTestEx = true; })
                    {
                        ButtonText(value = "Test -4-")
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
                        onClick = {numberTest = 5; showTestEx = true; })
                    {
                        ButtonText(value = "Test -5-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberTest = 6; showTestEx = true; })
                    {
                        ButtonText(value = "Test -6-")
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
                        onClick = {numberTest = 7; showTestEx = true; })
                    {
                        ButtonText(value = "Test -7-")
                    }
                    OutlinedButton(modifier = Modifier
                        .height(150.dp)
                        .width(150.dp),
                        onClick = {numberTest = 8; showTestEx = true; })
                    {
                        ButtonText(value = "Test -8-")
                    }
                }
            }
        }
        if (showTestEx) {
            return when (numberTest){
                1 -> TestExScreen(numberTest)
                2 -> TestExScreen(numberTest)
                else -> ComeSoonScreen()
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun TestsPreview() {
    Projekt_AplikacjiTheme {
        TestsScreen()
    }
}