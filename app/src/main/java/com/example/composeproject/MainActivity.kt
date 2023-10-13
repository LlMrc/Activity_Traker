package com.example.composeproject
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.composeproject.presentation.onboarding.OnBoardindViewModel
import com.example.composeproject.presentation.onboarding.OnBoardingScreen
import com.example.composeproject.ui.theme.ComposeProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.composeproject.presentation.nvgraph.NavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel> ()
    @Inject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       WindowCompat.setDecorFitsSystemWindows( window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .systemBarsPadding()
                        .background(MaterialTheme.colorScheme.background)) {
                    val startDestination = viewModel.startDestination
                    NavGraph(destination = startDestination)

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    val viewModel: OnBoardindViewModel = hiltViewModel()
    OnBoardingScreen( event = viewModel::onEvent)
}