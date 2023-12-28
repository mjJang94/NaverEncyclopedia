package com.mj.naverencyclopedia.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val encyclopediaColors = lightColors(
    primary = Color(0xFFFFFFFF),
    surface = Color(0xFF1D1D1D),
)

@Composable
fun EncyclopediaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = encyclopediaColors,
        typography = craneTypography,
    ) {
        content()
    }
}
