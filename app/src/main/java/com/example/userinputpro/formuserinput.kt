package com.example.userinputpro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


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

        Surface(
            shape = RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen.card_corner_radius),
                topEnd = dimensionResource(id = R.dimen.card_corner_radius)
            ),
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(id = R.dimen.card_top_offset))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_large))
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                Text(
                    text = stringResource(id = R.string.form_title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.purple_title)
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                Text(
                    text = stringResource(id = R.string.form_subtitle),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_subtitle),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_medium))
                ){
                    OutlinedTextField(
                        value = firstName,
                        onValueChange = {firstName = it},
                        label = { Text(text = stringResource(id = R.string.label_first_name))},
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )

                    OutlinedTextField(
                        value = lastName,
                        onValueChange = {lastName = it},
                        label = { Text(text = stringResource(id = R.string.label_last_name))},
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )


                }

            }
        }

    }
}