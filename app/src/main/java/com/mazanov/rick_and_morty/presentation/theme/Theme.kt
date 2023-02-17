package com.mazanov.rick_and_morty.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Color.White,
    secondary = TitleColor,
    background = PersonBackgroundColor,
    surface = AppBarColor,
    onPrimary = CardColor,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Color.Black,
    secondary = TitleColor,
    background = Color.LightGray,
    surface = CardColor.copy(alpha = 0.2f),
    onPrimary = Color.White,
)

//val AppBarColor = Color(0xff1C1D1F)
//val MainBackgroundColor = Color(0xff1C1D1F)
//val PersonBackgroundColor = Color(0xff242632)
//val CardColor = Color(0xff3C3E44)
//val TitleColor = Color(0xff62849E)

@Composable
fun Rick_and_mortyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}