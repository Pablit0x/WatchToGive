package com.ap.watchtogive.presentation.charity_search

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EmptyListIndicator(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = Icons.Default.Search, contentDescription = "Empty Charity List Icon", modifier = Modifier.size(64.dp), tint = Color.LightGray)
        Text(text = "Sorry, no matching charities found. Please try again.", textAlign = TextAlign.Center, modifier = Modifier.padding(top = 16.dp))
    }
}