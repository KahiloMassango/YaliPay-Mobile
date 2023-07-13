package com.example.yalipay.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yalipay.R
import com.example.yalipay.ui.theme.YaliPayTheme
import com.example.yalipay.ui.utils.CampoPassword
import com.example.yalipay.ui.utils.CampoTelefone
import com.example.yalipay.ui.utils.CustomButton
import com.example.yalipay.ui.utils.TextoCustomizado


@Composable
fun TelaLogin(){
    var telefone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
            CampoTelefone(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 3.dp),
                value = telefone,
                onValueChange = { telefone = it }
            )
            CampoPassword(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it }
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp, bottom = 100.dp),
                text1 = "Esqueci minha senha. ",
                text2 = "Recuperar",
                onClick =  {/* TODO */}
            )
            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Entrar",
                onClick =  {/* TODO */}
            )
            TextoCustomizado(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp, bottom = 40.dp),
                text1 = "Não tenho conta ",
                text2 = "Criar",
                onClick =  {/* TODO */}
            )

        }

    }

}





@Preview
@Composable
fun Preview3(){
    YaliPayTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TelaLogin()
        }
    }
}