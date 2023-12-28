package com.mj.naverencyclopedia.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mj.naverencyclopedia.R
import com.mj.naverencyclopedia.ui.encyclopediaColors
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000L

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    onTimeOut: () -> Unit,
) {
    val currentOnTimeout by rememberUpdatedState(newValue = onTimeOut)

    LaunchedEffect(Unit) {
        delay(SplashWaitTime)
        currentOnTimeout()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(encyclopediaColors.surface)
    ) {
        Image(
            painterResource(id = R.drawable.ic_crane_drawer),
            contentDescription = null,
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(),
        )
    }
}