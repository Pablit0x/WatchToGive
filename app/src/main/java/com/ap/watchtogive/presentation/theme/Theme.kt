package com.ap.watchtogive.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = BackgroundDark,
    // primaryVariant = LightBlue
)

private val LightColorPalette = lightColors(
    primary = BackgroundDark,
    // primaryVariant = LightBlue

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun WatchToGiveTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }


    val systemUiController = rememberSystemUiController()
    if(darkTheme) {
        systemUiController.setSystemBarsColor(
            color = BackgroundDark
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}