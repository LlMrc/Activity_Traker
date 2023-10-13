package com.example.composeproject


import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composeproject.domain.manager.usecases.AppEntryUseCases
import com.example.composeproject.presentation.nvgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel(){
 var splashCondition  by mutableStateOf(true)
     private set

     var  startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init{
          appEntryUseCases.readAppEntry().onEach {  shouldStartFromHomeScreen ->
                if(shouldStartFromHomeScreen){
                    startDestination = Route.NewsNavigation.route
                }else{
                    startDestination = Route.AppStartNavigation.route
                }
              delay(300)
              splashCondition = false
          }
    }
}