package com.example.userinputpro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun FormBiodataScreen(modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUIXChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.card_bg))
    ) {
        Image(
            painter = painterResource(id = R.drawable.header_bg),
            contentDescription = stringResource(id = R.string.desc_header_img),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .height(dimensionResource(id = R.dimen.header_height))
        )

    }
}