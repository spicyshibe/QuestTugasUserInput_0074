package com.example.userinputpro

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun FormBiodataScreen(modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }


}