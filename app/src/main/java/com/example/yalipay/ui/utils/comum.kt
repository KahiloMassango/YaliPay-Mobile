package com.example.yalipay.ui.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(200.dp)
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
fun TextoCustomizado(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String,
    onClick: () -> Unit) {
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
fun CampoCustomizado(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 5.dp),
            text = title,
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
            placeholder = { Text(text = placeholder) },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary,
            ),
            keyboardOptions = keyboardOptions
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoPassword(
    modifier: Modifier = Modifier,
    normal: Boolean,
    value: String,
    onValueChange: (String) -> Unit
){
    val focusManager = LocalFocusManager.current
    var passwordVisible by remember { mutableStateOf(false) }
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
        if (normal){
            OutlinedTextField(
                modifier = Modifier
                    .height(67.dp)
                    .fillMaxWidth(),
                value = value,
                onValueChange = { onValueChange(it) },
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    disabledContainerColor = MaterialTheme.colorScheme.secondary,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions( onDone = { focusManager.clearFocus() }),
                placeholder = { Text(text = "***********************") },
            )
        } else {
            OutlinedTextField(
                modifier = Modifier
                    .height(67.dp)
                    .fillMaxWidth(),
                value = value,
                onValueChange = { onValueChange(it) },
                singleLine = true,
                visualTransformation =  if (passwordVisible) {
                    VisualTransformation.None } else { PasswordVisualTransformation() },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    disabledContainerColor = MaterialTheme.colorScheme.secondary,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions( onDone = { focusManager.clearFocus() }),
                placeholder = { Text(text = "***********************") },
                trailingIcon = {
                    val image = if (passwordVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }

                    // Texto de acessibilidade
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector  = image, description, tint = Color.White)
                    }
                }
            )
        }
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