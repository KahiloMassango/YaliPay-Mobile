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
import com.example.yalipay.ui.utils.ui.PasswordField
import com.example.yalipay.ui.utils.ui.CustomField
import com.example.yalipay.ui.utils.ui.CustomButton
import com.example.yalipay.ui.utils.ui.CustomText

@Composable
fun RegisterScreen(
    windowSizeClass: WindowWidthSizeClass,
    onSignIn: () -> Unit,
    onSignUp: () -> Unit
){
    when(windowSizeClass){
        WindowWidthSizeClass.Compact ->
            CompactScreen(onLogin = onSignIn, onSignUp = onSignUp)
        WindowWidthSizeClass.Medium ->
            MediumScreen(onLogin = onSignIn, onSignUp = onSignUp)
        else -> ExpandedScreen(onLogin = onSignIn, onSignUp = onSignUp)
    }
}

@Composable
private fun CompactScreen(
    onLogin: () -> Unit,
    onSignUp: () -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

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
            CustomField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = telefone,
                title = "Número Telefone",
                placeholder = "+244 912 345 678",
                onValueChange = { telefone = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next,
                )
            )
            CustomField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = email,
                title = "E-mail",
                placeholder = "Exemplo@email.com",
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                )
            )
            PasswordField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                normal = false,
                value = password,
                onValueChange = { password = it }
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Cadastrar",
                onClick =  { onSignUp() }
            )
            CustomText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp, bottom = 40.dp),
                text1 = "Já tenho conta ",
                text2 = "Entrar",
                onClick =  { onLogin() }
            )

        }

    }

}

@Composable
private fun MediumScreen(
    onLogin: () -> Unit,
    onSignUp: () -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email  by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(24.dp)
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
            CustomField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = telefone,
                title = "Número Telefone",
                placeholder = "+244 912 345 678",
                onValueChange = { telefone = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next,
                )
            )
            CustomField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = email,
                title = "E-mail",
                placeholder = "Exemplo@email.com",
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                )
            )
            PasswordField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                normal = false,
                value = password,
                onValueChange = { password = it }
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Cadastrar",
                onClick =  { onSignUp() }
            )
            CustomText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                text1 = "Já tenho conta ",
                text2 = "Entrar",
                onClick =  { onLogin() }
            )

        }

    }

}

@Composable
private fun ExpandedScreen(
    onLogin: () -> Unit,
    onSignUp: () -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(24.dp)
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
                .fillMaxWidth(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                modifier = Modifier.padding(bottom = 50.dp),
                text = "Entre no seu cofre",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            CustomField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = telefone,
                title = "Número Telefone",
                placeholder = "+244 912 345 678",
                onValueChange = { telefone = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next,
                )
            )
            CustomField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                value = email,
                title = "E-mail",
                placeholder = "Exemplo@email.com",
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                )
            )
            PasswordField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp),
                normal = false,
                value = password,
                onValueChange = { password = it }
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                    text = "Cadastrar",
                onClick =  { onSignUp() }
            )
            CustomText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                text1 = "Já tenho conta ",
                text2 = "Entrar",
                onClick =  { onLogin() }
            )

        }

    }

}


@Preview
@Composable
fun Preview7(){
    YaliPayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CompactScreen({}, {})
        }
    }
}