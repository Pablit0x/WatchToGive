package com.ap.watchtogive.presentation.charity_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.domain.model.CharityDetail

@Composable
fun CharityDetailScreen(charity: Charity, charityDetailViewModel: CharityDetailViewModel = hiltViewModel()){
    LaunchedEffect(key1 = charity){
        charityDetailViewModel.getCharityDetails(charityRegNumber = charity.registrationNumber)
    }
    val charityDetails = charityDetailViewModel.detailState.value.charityDetails
    val state by charityDetailViewModel.detailState

    if(state.isLoading){
        ShowLoadingIndicator()
    } else {
        ShowCharityDetail(charity = charity, charityDetail = charityDetails)
    }
}

@Composable
fun ShowLoadingIndicator(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(color = Color.Black)
    }
}


@Composable
fun ShowCharityDetail(charity: Charity, charityDetail: CharityDetail){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = charity.name, fontSize = 32.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        Text(text = "Registration number : ${charity.registrationNumber}", fontWeight = FontWeight.Light, fontStyle = FontStyle.Italic, modifier = Modifier.padding(16.dp))

        Text(text = "${charityDetail.description}",  modifier = Modifier
            .padding(16.dp)
            .border(BorderStroke(1.dp, Color.LightGray))
            .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Vote", color = Color.White, fontSize = 24.sp)
        }
    }
}

