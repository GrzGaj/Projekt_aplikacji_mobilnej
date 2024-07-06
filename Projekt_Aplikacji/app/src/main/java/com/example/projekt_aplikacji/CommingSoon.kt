package com.example.projekt_aplikacji

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projekt_aplikacji.ui.theme.Projekt_AplikacjiTheme

@Composable
fun ComeSoonScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            text = "Comming Soon"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComeSoonPreview() {
    Projekt_AplikacjiTheme {
        ComeSoonScreen()
    }
}