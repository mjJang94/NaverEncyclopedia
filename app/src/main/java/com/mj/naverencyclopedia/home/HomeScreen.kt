package com.mj.naverencyclopedia.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mj.naverencyclopedia.ui.EncyclopediaTheme
import com.mj.naverencyclopedia.ui.encyclopediaColors

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(encyclopediaColors.surface)
    ) {
        Text(
            text = "Hello World!",
            color = encyclopediaColors.primary,
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    EncyclopediaTheme {
        val mainViewModel = hiltViewModel<MainViewModel>()
        HomeScreen(
            modifier = Modifier.alpha(1f),
            viewModel = mainViewModel
        )
    }
}
