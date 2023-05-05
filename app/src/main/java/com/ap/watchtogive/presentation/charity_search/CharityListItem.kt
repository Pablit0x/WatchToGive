package com.ap.watchtogive.presentation.charity_search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.presentation.navigation.CHARITY_KEY
import com.ap.watchtogive.presentation.navigation.Screen

@Composable
fun CharityListItem(charityItem: Charity, navController: NavController) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = charityItem.name,
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.6f),
        )
        Button(
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set(key = CHARITY_KEY, value = charityItem)
                navController.navigate(route = Screen.Detail.route)
            }, modifier = Modifier
                .weight(0.4f)
                .padding(start = 8.dp)
        ) {
            Text(text = "INFO", color = Color.White)
        }
    }
}