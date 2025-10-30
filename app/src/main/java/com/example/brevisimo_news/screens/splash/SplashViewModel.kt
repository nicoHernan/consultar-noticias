package com.example.brevisimo_news.screens.splash

import androidx.lifecycle.ViewModel
import com.example.brevisimo_news.HOME_SCREEN
import com.example.brevisimo_news.SPLASH_SCREEN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    fun onAppStart(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(HOME_SCREEN, SPLASH_SCREEN)
    }
}