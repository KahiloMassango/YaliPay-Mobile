package com.example.yalipay.ui.utils.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yalipay.R
import com.example.yalipay.ui.CompactScreenn
import com.example.yalipay.ui.theme.YaliPayTheme
import java.text.NumberFormat
import java.util.Locale


enum class Screen(val icon: Int){
    Home(R.drawable.home),
    Transfer(R.drawable.transfer),
    Cards(R.drawable.cards)
}

val screens = listOf(
    Screen.Home,
    Screen.Transfer,
    Screen.Cards
)



@Composable
fun BottomAppBar(modifier: Modifier = Modifier, onClick: (String) -> Unit = { }){
    var selectedItem by remember { mutableStateOf(0) }
    Box(
        modifier = modifier.background(Color(0xFF202020))
    ) {
        NavigationBar(
            modifier = Modifier.height(61.dp),
            containerColor = Color.Transparent,
        ) {
            screens.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = item.name,
                            tint = if (selectedItem == index) MaterialTheme.colorScheme.inverseOnSurface else
                                MaterialTheme.colorScheme.onBackground
                        )
                    },
                    selected = selectedItem == index,
                    onClick = { onClick(item.name);
                        if (selectedItem != index) { selectedItem = index }
                              },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(0xFF202020),
                    )
                )
            }
        }
    }
}

fun formattedCurrency(value: Double): String {
    return NumberFormat.getInstance(Locale.US).format(value)
}

fun formattedAccountNumber(valeue: String): String {
    val number = valeue.trim()
    val formattedNumber = StringBuilder()

    for (i in number.indices) {
        formattedNumber.append(number[i])

        if ((i + 1) % 4 == 0 && i != number.length - 1) {
            formattedNumber.append(" ")
        }
    }
    return formattedNumber.toString()
}


@Preview
@Composable
fun UtilPreview44(){
    YaliPayTheme {
        Scaffold(
            topBar = {
                TopBar(title = "Home", canNavigate = true, onClick = { })
            },
            bottomBar = {
                BottomAppBar(onClick = { it })
            }
        ) {
            CompactScreenn(modifier = Modifier.padding(it), {})
        }
    }
}
