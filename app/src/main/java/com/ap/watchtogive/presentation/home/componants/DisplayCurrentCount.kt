package com.ap.watchtogive.presentation.home.componants

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.text.NumberFormat
import androidx.compose.ui.unit.sp
import com.ap.watchtogive.presentation.theme.DarkTextColour
import com.ap.watchtogive.presentation.theme.TextColour

@Composable
fun DisplayCurrentCount(
    currentTotal : Int
) {

    val displayedTotal = NumberFormat.getInstance().format(currentTotal)

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.2f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = displayedTotal,
            color = TextColour,
            fontSize = 64.sp
        )

        Text(
            text = "Ads Watched",
            color = DarkTextColour
        )
    }
}