package com.example.composeproject.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.domain.manager.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardindViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
)   : ViewModel() {
 fun onEvent(event: OnBoardingEvent){
     when(event){
is OnBoardingEvent.saveDataEntry ->{
    saveAppEntry()
}

     }
 }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveEntry()
        }
    }
}