package com.example.yalipay.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.yalipay.R

val poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),
    bodySmall = TextStyle(
        fontFamily = poppins,
        fontSize = 13.sp,
        fontWeight = FontWeight.W500,

    ),
)

val spanStyle1 = SpanStyle(
    color = White,
    fontFamily = poppins,
    fontSize = 13.sp,
    fontWeight = FontWeight.W500
)

val spanStyle = SpanStyle(
    color = Yellow,
    fontFamily = poppins,
    fontSize = 13.sp,
    fontWeight = FontWeight.W500
)