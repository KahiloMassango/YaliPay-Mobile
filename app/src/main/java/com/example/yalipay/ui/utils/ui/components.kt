package com.example.yalipay.ui.utils.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
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
import com.example.yalipay.ui.theme.YaliPayTheme
import java.text.NumberFormat
import java.util.Locale


private val icons = listOf(
    R.drawable.home,
    R.drawable.transfer,
    R.drawable.cards
)

private val navRoutes = listOf(
    "home",
    "transfer",
    "cards"
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
            navRoutes.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = icons[index]),
                            contentDescription = item,
                            tint = if (selectedItem == index) MaterialTheme.colorScheme.inverseOnSurface else
                                MaterialTheme.colorScheme.onBackground
                        )
                    },
                    selected = selectedItem == index,
                    onClick = {
                        if (selectedItem != index) { selectedItem = index; onClick(item) } },
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

@Composable
fun MediumNavigationRail(modifier: Modifier = Modifier, onClick: (String) -> Unit = { }){
    var selectedItem by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier.background(Color(0xFF202020))
    ) {
        NavigationRail(
            modifier = modifier.height(61.dp),
            containerColor = Color.Transparent,
        ) {
            navRoutes.forEachIndexed { index, item ->
                NavigationRailItem(
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = icons[index]),
                            contentDescription = item,
                            tint = if (selectedItem == index) MaterialTheme.colorScheme.inverseOnSurface else
                                MaterialTheme.colorScheme.onBackground
                        )
                    },
                    selected = selectedItem == index,
                    onClick = {
                        if (selectedItem != index) { selectedItem = index; onClick(item) } },
                    colors = NavigationRailItemDefaults.colors(
                        indicatorColor = Color(0xFF202020),
                    )
                )
            }
        }
    }
}


@Preview
@Composable
fun UtilPreview44(){
    YaliPayTheme {
        MediumNavigationRail(modifier = Modifier.fillMaxHeight(), onClick = { it })
    }
}
