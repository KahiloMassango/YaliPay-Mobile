package com.example.yalipay.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yalipay.ui.theme.YaliPayTheme
import com.example.yalipay.ui.utils.ui.CustomButton
import com.example.yalipay.ui.utils.ui.CustomOutlinedButton
import com.example.yalipay.ui.utils.ui.InitialText

@Composable
fun WelcomeScreen(windowSizeClass: WindowWidthSizeClass, onSignIn: () -> Unit, onSignUp: () -> Unit){
    when(windowSizeClass){
        WindowWidthSizeClass.Compact -> CompactScreen(onSignIn = onSignIn, onSignUp = onSignUp)
        else -> ExpandedScreen(onSignIn = onSignIn, onSignUp = onSignUp)
    }
}

@Composable
private fun CompactScreen(onSignIn: () -> Unit, onSignUp: () -> Unit){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InitialText(
            modifier = Modifier
        )

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 120.dp,
                    bottom = 30.dp
                ),
            text = "Já Tenho Conta",
            onClick = { onSignIn() }
        )
        CustomOutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Me Cadastrar",
            onClick = { onSignUp() }
        )
        Spacer(modifier = Modifier.height(120.dp))
    }
}

@Composable
private fun ExpandedScreen(onSignIn: () -> Unit, onSignUp: () -> Unit){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InitialText(
            modifier = Modifier
        )

        CustomButton(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(
                    top = 120.dp,
                    bottom = 30.dp
                ),
            text = "Já Tenho Conta",
            onClick = { onSignIn() }
        )
        CustomOutlinedButton(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            text = "Me Cadastrar",
            onClick = { onSignUp() }
        )
        Spacer(modifier = Modifier.height(120.dp))
    }
}


@Preview
@Composable
fun Preview2(){
    YaliPayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

        }
    }
}

