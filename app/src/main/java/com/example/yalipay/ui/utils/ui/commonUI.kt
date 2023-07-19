package com.example.yalipay.ui.utils.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
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
import androidx.compose.ui.unit.sp
import com.example.yalipay.R
import com.example.yalipay.ui.theme.YaliPayTheme
import com.example.yalipay.ui.theme.placeholderStyle
import com.example.yalipay.ui.theme.poppins
import com.example.yalipay.ui.theme.spanStyle
import com.example.yalipay.ui.theme.spanStyle1
import com.example.yalipay.ui.theme.spanStyle2
import com.example.yalipay.ui.theme.spanStyle3

@Composable
fun InitialText(modifier: Modifier = Modifier){
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
fun CustomText(modifier: Modifier = Modifier, text1: String, text2: String, onClick: () -> Unit) {
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

@Composable
fun CustomField(
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
            textStyle = placeholderStyle,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            placeholder = { Text(text = placeholder, style = placeholderStyle) },
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

@Composable
fun PasswordField(modifier: Modifier = Modifier, normal: Boolean, value: String,
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
                textStyle = placeholderStyle,
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
                placeholder = { Text(text = "***************", style =  placeholderStyle) },
            )
        } else {
            OutlinedTextField(
                modifier = Modifier
                    .height(67.dp)
                    .fillMaxWidth(),
                value = value,
                textStyle = placeholderStyle,
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
                placeholder = { Text(text = "***************", style =  placeholderStyle) },
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

@Composable
fun AccountBalanceText(
    modifier: Modifier = Modifier,
    saldo: String
) {
    Text(
        buildAnnotatedString {
            withStyle(style = spanStyle2){
                append("AOA ")
            }
            withStyle(style = spanStyle3) {
                append(saldo)
            }
        },
        modifier = modifier,
    )
}

@Composable
fun StatelessCard
            (modifier: Modifier = Modifier, balance: Double, accountNumber: String, onCLick: () -> Unit
) {
    Card(
        modifier = modifier,
            //illMaxWidth() ,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4F339A))
    ) {
        Column(
            modifier = Modifier.padding(start = 13.dp, top = 20.dp, end = 13.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(45.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.saldo),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    IconButton(onClick = { onCLick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.vector),
                            contentDescription = null,
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                AccountBalanceText(saldo = formattedCurrency(balance))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.numero_do_cartao),
                        fontSize = 14.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                    Text(
                        text = formattedAccountNumber(accountNumber),
                        fontSize = 12.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.visa),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .size(35.dp)
                )

            }
        }
    }
}

@Composable
fun StateCard(modifier: Modifier = Modifier, balance: Double,
              accountNumber: Long, active: Boolean, onStateCLick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth() ,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF4F339A))
    ) {
        Column(
            modifier = Modifier.padding(start = 13.dp, top = 20.dp, end = 13.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(45.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Saldo",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Icon(
                        imageVector = if (active) Icons.Filled.ToggleOn else Icons.Filled.ToggleOff,
                        contentDescription = null,
                        tint = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { onStateCLick() }
                    )
                }
                AccountBalanceText(saldo = formattedCurrency(balance))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "Número do Cartão",
                        fontSize = 12.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                    Text(
                        text = formattedAccountNumber(accountNumber.toString()),
                        fontSize = 10.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.visa),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .size(35.dp)
                )
            }
        }
    }
}

@Composable
fun OperationCard(
    modifier: Modifier = Modifier, username: String, transferIn: Boolean, transferAmount: Double
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(7.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary )
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 13.dp, horizontal = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(41.dp)
                        .clip(RoundedCornerShape(50.dp))
                )
                Column {
                    Text(
                        text = username,
                        fontSize = 14.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                    Text(
                        text = "Transferência ",
                        fontSize = 10.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF858585),
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(20.dp),
                    imageVector = if(transferIn) Icons.Default.ArrowUpward else Icons.Default.ArrowDownward,
                    contentDescription = null,
                    tint = if(transferIn) Color.Green else Color.Red
                )
                Text(
                    text = formattedCurrency(transferAmount),
                    fontSize = 10.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, title: String, canNavigateBack: Boolean, navigateUp: () -> Unit){
    TopAppBar(
        modifier = modifier.padding(start = 10.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background),
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = { navigateUp() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        }
    )

}
@Preview
@Composable
fun UtilPreview(){
    YaliPayTheme {
       // TopBar("Transfer",true, { })
    }
}