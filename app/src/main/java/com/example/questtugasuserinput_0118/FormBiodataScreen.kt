package com.example.questtugasuserinput_0118

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp

@Composable
fun FormBiodataScreen() {
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
                }
            }
        }
    }
}
