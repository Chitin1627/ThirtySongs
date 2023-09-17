package com.example.thirtysongs.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtysongs.R

// Set of Material typography styles to start with
val CroissantOne = FontFamily(
    Font(R.font.croissantone_regular)
)

val Cormorant = FontFamily(
    Font(R.font.cormorantgaramond_regular)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = CroissantOne,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = Cormorant,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )

)