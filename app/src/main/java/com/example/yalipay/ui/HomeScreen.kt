package com.example.yalipay.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yalipay.R
import com.example.yalipay.ui.theme.YaliPayTheme
import com.example.yalipay.ui.theme.poppins
import com.example.yalipay.ui.utils.ui.BottomAppBar
import com.example.yalipay.ui.utils.ui.MediumNavigationRail
import com.example.yalipay.ui.utils.ui.StatelessCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowWidthSizeClass,
){
    when(windowSizeClass){
        WindowWidthSizeClass.Compact ->
            CompactScreen(modifier)
        WindowWidthSizeClass.Medium ->
            MediumScreen(modifier)
        else -> CompactScreen(modifier)
    }
}

@Composable
private fun CompactScreen(modifier: Modifier = Modifier){
    var scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.cartoes),
                fontSize = 24.sp,
                fontFamily = poppins,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {  }) {
                Image(
                    modifier = Modifier
                        .size(25.dp),
                    painter = painterResource(id = R.drawable.paper_plus),
                    contentDescription = null
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 25.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            StatelessCard(balance = 2534768.00, accountNumber = "1234 4567 6553 1389", onCLick = {})
            StatelessCard(balance = 2534768.00, accountNumber = "1234 4567 6553 1389", onCLick = {})
        }
        BottomAppBar(modifier = Modifier, onClick = {  })
    }


}

@Composable
private fun MediumScreen(modifier: Modifier = Modifier){

    var scrollState = rememberScrollState()
    Row(modifier = modifier.fillMaxSize()
    ) {
        MediumNavigationRail(modifier = Modifier.fillMaxHeight(), onClick = { it })
    Column(
        modifier = modifier
            //.fillMaxSize()
            .padding(horizontal = 18.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.cartoes),
                fontSize = 24.sp,
                fontFamily = poppins,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = { }) {
                Image(
                    modifier = Modifier
                        .size(25.dp),
                    painter = painterResource(id = R.drawable.paper_plus),
                    contentDescription = null
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 25.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            StatelessCard(balance = 2534768.00, accountNumber = "1234 4567 6553 1389", onCLick = {})
            StatelessCard(balance = 2534768.00, accountNumber = "1234 4567 6553 1389", onCLick = {})
        }
    } }
}

@Preview(name = "Main")
@Composable
fun Preview22() {
    YaliPayTheme {
        MediumScreen()
    }
}