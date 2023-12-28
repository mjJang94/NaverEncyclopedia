package com.mj.naverencyclopedia.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mj.naverencyclopedia.ui.EncyclopediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EncyclopediaTheme {
                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel = mainViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val transitionState = remember { MutableTransitionState(viewModel.shownSplash.value) }
    val transition = updateTransition(transitionState, label = "splashTransition")
    val splashAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 100) }, label = "splashAlpha"
    ) {
        if (it == SplashState.Shown) 1f else 0f
    }
    val contentAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) }, label = "contentAlpha"
    ) {
        if (it == SplashState.Shown) 0f else 1f
    }

    Box {
        LandingScreen(
            modifier = Modifier.alpha(splashAlpha),
            onTimeOut = {
                transitionState.targetState = SplashState.Completed
                viewModel.shownSplash.value = SplashState.Completed
            }
        )

        HomeScreen(
            modifier = Modifier.alpha(contentAlpha),
            viewModel = viewModel,
        )
    }
}