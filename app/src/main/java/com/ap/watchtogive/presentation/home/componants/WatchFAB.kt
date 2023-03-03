package com.ap.watchtogive.presentation.home.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ap.watchtogive.presentation.theme.BackgroundDark
import com.ap.watchtogive.presentation.theme.DarkTextColour

@Composable
fun WatchFAB(
    clickEvent : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        ExtendedFloatingActionButton(
            text = {
                Text(
                    text = "Watch Ad",
                    color = BackgroundDark
                )},
            icon = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "",
                    tint = BackgroundDark
                )},
            backgroundColor = DarkTextColour,
            onClick = clickEvent
        )
    }
}

/*
{
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "",
                tint = Color.DarkGray
            )
        }
 */