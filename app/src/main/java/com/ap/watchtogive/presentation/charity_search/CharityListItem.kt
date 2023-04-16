package com.ap.watchtogive.presentation.charity_search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ap.watchtogive.domain.model.Charity

@Composable
fun CharityListItem(charityItem : Charity, charitySearchViewModel: CharitySearchViewModel = hiltViewModel()){
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = charityItem.name,
            modifier = Modifier
                .weight(0.6f)
        )
        Button(
            onClick = {
                charitySearchViewModel.getCharityDetails(context, charityItem.registrationNumber)
                      },
            modifier = Modifier
                .weight(0.4f)
                .padding(start = 8.dp)
        ) {
            Text(text = "INFO")
        }
    }
}