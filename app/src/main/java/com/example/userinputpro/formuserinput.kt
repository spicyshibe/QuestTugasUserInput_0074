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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodataScreen(modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }

    val experienceOptions = stringArrayResource(id = R.array.experience_options)
    var expanded by remember { mutableStateOf(false) }
    var selectedExperience by remember { mutableStateOf("") }

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
                .fillMaxWidth()
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
            ) {
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
                ) {
                    OutlinedTextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text(text = stringResource(id = R.string.label_first_name)) },
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )

                    OutlinedTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text(text = stringResource(id = R.string.label_last_name)) },
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = stringResource(id = R.string.label_email)) },
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                // Row Tanggal Lahir & Dropdown
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_medium)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = tglLahir,
                        onValueChange = { tglLahir = it },
                        label = { Text(text = stringResource(id = R.string.label_tgl_lahir)) },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = stringResource(id = R.string.desc_date_icon)
                            )
                        },
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded },
                        modifier = Modifier.weight(1f)
                    ) {
                        OutlinedTextField(
                            value = selectedExperience,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text(text = stringResource(id = R.string.label_experience)) },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                            },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                            singleLine = true,
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            experienceOptions.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(text = option) },
                                    onClick = {
                                        selectedExperience = option
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                } // Penutup Row Tanggal & Dropdown yang benar

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                Text(
                    text = stringResource(id = R.string.label_pilih_skill),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                // Row Checkbox Skills
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = isAndroidChecked,
                            onCheckedChange = { isAndroidChecked = it }
                        )
                        Text(
                            text = stringResource(id = R.string.skill_android),
                            fontSize = 12.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = isUIXChecked,
                            onCheckedChange = { isUIXChecked = it }
                        )
                        Text(
                            text = stringResource(id = R.string.skill_uiux),
                            fontSize = 12.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = isWebChecked,
                            onCheckedChange = { isWebChecked = it }
                        )
                        Text(
                            text = stringResource(id = R.string.skill_web),
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))


                val isFormValid = firstName.isNotBlank() &&
                        lastName.isNotBlank() &&
                        email.isNotBlank() &&
                        tglLahir.isNotBlank() &&
                        selectedExperience.isNotBlank() &&
                        (isAndroidChecked || isUIXChecked || isWebChecked)

                Button(
                    onClick = { },
                    enabled = isFormValid,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_title),
                        disabledContainerColor = colorResource(id = R.color.btn_disabled_bg),
                        disabledContentColor = colorResource(id = R.color.btn_disabled_text)
                    ),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.btn_proceed),
                        fontWeight = FontWeight.Bold
                    )
                }


                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))
            }
        }
    }
}
