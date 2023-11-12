package com.raerossi.pulsescore.ui.features.onboarding

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raerossi.pulsescore.data.preferences.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OnBoardingViewModel(context: Context) : ViewModel() {
    val repository = DataStoreRepository(context)

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }
}