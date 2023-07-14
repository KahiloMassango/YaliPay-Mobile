package com.example.yalipay.ui

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yalipay.R
import com.example.yalipay.ui.theme.YaliPayTheme
import com.example.yalipay.ui.utils.CampoPassword
import com.example.yalipay.ui.utils.CampoCustomizado
import com.example.yalipay.ui.utils.CustomButton
import com.example.yalipay.ui.utils.TextoCustomizado

@Composable
fun TelaLogin(
    windowSizeClass: WindowWidthSizeClass,
    onLogin: () -> Unit,
    onRecovery: () -> Unit,
    onSignUp: () -> Unit
){
    when(windowSizeClass){
        WindowWidthSizeClass.Compact ->
            TelaCompacta(onLogin = onLogin, onRecovery = onRecovery, onSignUp = onSignUp)
        WindowWidthSizeClass.Medium ->
            TelaMedia(onLogin = onLogin, onRecovery = onRecovery, onSignUp = onSignUp)
        else -> TelaExpandida(onLogin = onLogin, onRecovery = onRecovery, onSignUp = onSignUp)
    }
}

@Composable
private fun TelaCompacta(
    onLogin: () -> Unit,
    onRecovery: () -> Unit,
    onSignUp: () -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            },
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                modifier = Modifier.padding(bottom = 60.dp),
                text = "Entre no seu cofre",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            CampoCustomizado(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = telefone,
                title = "Número Telefone",
                placeholder = "+244 912 345 678",
                onValueChange = { telefone = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
            CampoPassword(
                modifier = Modifier
                    .fillMaxWidth(),
                normal = true,
                value = password,
                onValueChange = { password = it }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp, bottom = 100.dp),
                text1 = "Esqueci minha senha. ",
                text2 = "Recuperar",
                onClick =  { onRecovery() }
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Entrar",
                onClick =  { onLogin() }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                text1 = "Não tenho conta ",
                text2 = "Criar",
                onClick =  { onSignUp() }
            )

        }

    }

}

@Composable
private fun TelaMedia(
    onLogin: () -> Unit,
    onRecovery: () -> Unit,
    onSignUp: () -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                modifier = Modifier.padding(bottom = 60.dp),
                text = "Entre no seu cofre",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            CampoCustomizado(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                title = "Número Telefone",
                placeholder = "+244 912 345 678",
                value = telefone,
                onValueChange = { telefone = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
            CampoPassword(
                modifier = Modifier
                    .fillMaxWidth(),
                normal = true,
                value = password,
                onValueChange = { password = it }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp, bottom = 80.dp),
                text1 = "Esqueci minha senha. ",
                text2 = "Recuperar",
                onClick =  { onRecovery() }
            )
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Entrar",
                onClick =  { onLogin() }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                text1 = "Não tenho conta ",
                text2 = "Criar",
                onClick =  { onSignUp() }
            )

        }

    }

}

@Composable
private fun TelaExpandida(
    onLogin: () -> Unit,
    onRecovery: () -> Unit,
    onSignUp: () -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                modifier = Modifier.padding(bottom = 60.dp),
                text = "Entre no seu cofre",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            CampoCustomizado(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                title = "Número Telefone",
                placeholder = "+244 912 345 678",
                value = telefone,
                onValueChange = { telefone = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
            CampoPassword(
                modifier = Modifier
                    .fillMaxWidth(),
                normal = true,
                value = password,
                onValueChange = { password = it }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp, bottom = 100.dp),
                text1 = "Esqueci minha senha. ",
                text2 = "Recuperar",
                onClick =  { onRecovery() }
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Entrar",
                onClick =  { onLogin() }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp, bottom = 40.dp),
                text1 = "Não tenho conta ",
                text2 = "Criar",
                onClick =  { onSignUp() }
            )

        }

    }

}


@Preview
@Composable
fun Preview6(){
    YaliPayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TelaCompacta({}, {}, {} )
        }
    }
}