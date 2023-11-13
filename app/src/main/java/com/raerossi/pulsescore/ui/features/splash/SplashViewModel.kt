package com.raerossi.pulsescore.ui.features.splash

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raerossi.pulsescore.data.preferences.DataStoreRepository
import com.raerossi.pulsescore.ui.navigation.Routes
import kotlinx.coroutines.launch

class SplashViewModel(context: Context): ViewModel() {
    val repository = DataStoreRepository(context)

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Routes.OnBoardingScreen.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Routes.HomeScreen.route
                } else {
                    _startDestination.value = Routes.OnBoardingScreen.route
                }
            }
            _isLoading.value = false
        }
    }
}