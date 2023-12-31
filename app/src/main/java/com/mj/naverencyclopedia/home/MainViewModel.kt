package com.mj.naverencyclopedia.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {
    val shownSplash = mutableStateOf(SplashState.Shown)
}

enum class SplashState { Shown, Completed }