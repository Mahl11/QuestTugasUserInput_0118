package com.example.questtugasuserinput_0118

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun FormBiodataScreen() {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var expDropdownExpanded by remember { mutableStateOf(false) }

    val expOptions = listOf(
        stringResource(id = R.string.exp_1_2),
        stringResource(id = R.string.exp_3_5),
        stringResource(id = R.string.exp_more_5)
    )

    val skillAndroid = stringResource(id = R.string.skill_android)
    val skillUiUx = stringResource(id = R.string.skill_uiux)
    val skillWeb = stringResource(id = R.string.skill_web)

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.bg_dark))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ghibli_bg),
                contentDescription = stringResource(id = R.string.desc_ghibli_bg),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.header_bg_height))
            )

            // Komponen Box yang mengapung di atas Scaffold
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = dimensionResource(id = R.dimen.floating_box_top),
                        start = dimensionResource(id = R.dimen.padding_md),
                        end = dimensionResource(id = R.dimen.padding_md),
                        bottom = dimensionResource(id = R.dimen.padding_md)
                    )
                    .shadow(
                        elevation = dimensionResource(id = R.dimen.elevation_card),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_card))
                    )
                    .background(
                        color = colorResource(id = R.color.card_surface),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_card))
                    )
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_card)))
                    .padding(dimensionResource(id = R.dimen.padding_lg))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.form_title),
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(id = R.dimen.text_size_title).value.sp,
                        color = colorResource(id = R.color.purple_primary)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xs)))
                    Text(
                        text = stringResource(id = R.string.form_subtitle),
                        fontSize = dimensionResource(id = R.dimen.text_size_subtitle).value.sp,
                        color = colorResource(id = R.color.text_secondary)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_md)))

                    // Input Baris Nama Depan & Belakang
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            label = { Text(text = stringResource(id = R.string.label_nama_depan)) },
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_field)),
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_sm)))
                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            label = { Text(text = stringResource(id = R.string.label_nama_belakang)) },
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_field)),
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_sm)))

                    // Input Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = stringResource(id = R.string.label_email)) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_field)),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_sm)))

                    // Input Baris Tgl Lahir & Experience Dropdown
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = tglLahir,
                            onValueChange = { tglLahir = it },
                            label = { Text(text = stringResource(id = R.string.label_tgl_lahir)) },
                            singleLine = true,
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_calendar),
                                    contentDescription = stringResource(id = R.string.desc_calendar_icon),
                                    modifier = Modifier.size(dimensionResource(id = R.dimen.icon_sm)),
                                    tint = colorResource(id = R.color.text_secondary)
                                )
                            },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_field)),
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_sm)))
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = {},
                                readOnly = true,
                                singleLine = true,
                                label = { Text(text = stringResource(id = R.string.label_experience)) },
                                trailingIcon = {
                                    IconButton(onClick = { expDropdownExpanded = !expDropdownExpanded }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_dropdown),
                                            contentDescription = stringResource(id = R.string.desc_dropdown_icon),
                                            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_sm)),
                                            tint = colorResource(id = R.color.text_secondary)
                                        )
                                    }
                                },
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_field)),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expDropdownExpanded = true }
                            )
                            DropdownMenu(
                                expanded = expDropdownExpanded,
                                onDismissRequest = { expDropdownExpanded = false }
                            ) {
                                expOptions.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            experience = item
                                            expDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_md)))
                }
            }
        }
    }
}
