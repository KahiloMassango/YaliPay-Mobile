package com.example.yalipay.ui.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yalipay.R
import com.example.yalipay.ui.theme.YaliPayTheme
import com.example.yalipay.ui.theme.spanStyle
import com.example.yalipay.ui.theme.spanStyle1

@Composable
fun TextoInicial(modifier: Modifier = Modifier){
    Column(
        //verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(190.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.displayLarge,
        )
        Text(
            text = stringResource(R.string.texto_inicial),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun CustomOutlinedButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit){
    OutlinedButton(
        modifier = modifier
            .height(70.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
fun CustomButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit){
    Button(
        modifier = modifier.height(70.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }

}

@Composable
fun TextoCustomizado(text1: String, text2: String,  modifier: Modifier = Modifier, onClick: () -> Unit) {
    Text(
        buildAnnotatedString {
            withStyle(style = spanStyle1){
                append(text1)
            }
            withStyle(style = spanStyle) {
                append(text2)
            }
        },
        modifier = modifier.clickable { onClick() },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoTelefone(modifier: Modifier = Modifier, value: String, onValueChange: (String) -> Unit){
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 5.dp),
            text = stringResource(R.string.numero_telefone),
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        OutlinedTextField(
            modifier = Modifier
                .height(67.dp)
                .fillMaxWidth(),
            value = value,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            placeholder = { Text(text = "+244 912 345 678") },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoPassword(modifier: Modifier = Modifier, value: String, onValueChange: (String) -> Unit){
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
            text = stringResource(R.string.senha),
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        OutlinedTextField(
            modifier = Modifier
                .height(67.dp)
                .fillMaxWidth(),
            value = value,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.secondary),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = "***********************") }
        )
    }
}



@Preview
@Composable
fun UtilPreview(){
    YaliPayTheme {

     //   CustomButton(text = "Hello World ", onClick = {})
        CustomOutlinedButton(text = "Hello World ", onClick = {})

    }
}