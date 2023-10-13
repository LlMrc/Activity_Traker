package com.example.composeproject.presentation.nvgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.composeproject.presentation.onboarding.OnBoardindViewModel
import com.example.composeproject.presentation.onboarding.OnBoardingScreen


@Composable
fun NavGraph(destination: String){
val navController = rememberNavController()
  NavHost(navController = navController, startDestination = destination) {
      navigation(
          route = Route.AppStartNavigation.route,
          startDestination = Route.OnBoardingScreen.route
      ) {
          composable(route = Route.OnBoardingScreen.route) {
              val viewModel: OnBoardindViewModel = hiltViewModel()
              OnBoardingScreen(event = viewModel::onEvent)
          }
      }


      navigation(
          route = Route.NewsNavigation.route,
          startDestination = Route.HomeScreen.route
      ) {
          composable(route = Route.NewsNavigatorScreen.route) {
              Box (contentAlignment = Alignment.Center){
                  Text(text = "News Navigator screen")
              }
          }
          composable(route = Route.HomeScreen.route) {

          }
          composable(route = Route.SearchScreen.route) {

          }
          composable(route = Route.BookmarkScreen.route) {

          }
          composable(route = Route.DetailsScreen.route) {

          }
      }
  }
}