package com.ap.watchtogive.presentation.home.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ap.watchtogive.presentation.theme.DarkTextColour
import com.ap.watchtogive.presentation.theme.TextColour
import java.text.NumberFormat

@Composable
fun DisplayCurrentCount(
    currentTotal : Long
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