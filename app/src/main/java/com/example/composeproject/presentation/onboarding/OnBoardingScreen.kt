package com.example.composeproject.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeproject.presentation.Dimention.MediumPadding2
import com.example.composeproject.presentation.Dimention.PageIndicatorWidth
import com.example.composeproject.presentation.common.NewsButton
import com.example.composeproject.presentation.common.NewsTextButton
import com.example.composeproject.presentation.onboarding.components.OnboardingPage
import com.example.composeproject.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
){
     Column(modifier = Modifier) {
         val pagerState = rememberPagerState(initialPage = 0) {
                pages.size
         }
val buttomState = remember {
    derivedStateOf {
        when(pagerState.currentPage){
            0 -> listOf("", "Next")
            1 -> listOf("Back", "Next")
            2 -> listOf("Back", "Get Started")
else  -> listOf("", "")

        }
    }

}

         HorizontalPager(state = pagerState) { index ->
             OnboardingPage(page = pages[index])
         }
         
         Spacer(modifier = Modifier.weight(1f))
         Row(modifier = Modifier
             .fillMaxWidth()
             .padding(horizontal = MediumPadding2)
             .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
             verticalAlignment = Alignment.CenterVertically
             ) {
                PageIndicator(
                    modifier = Modifier.width(PageIndicatorWidth),
                    pagesSize = pages.size, selectedPage = pagerState.currentPage)


             Row(verticalAlignment = Alignment.CenterVertically) {
                 val scope = rememberCoroutineScope()

                 if (buttomState.value[0].isNotEmpty() ){
                     NewsTextButton(
                         text = buttomState.value[0],
                         onClick = {
                             scope.launch {
                                 pagerState.animateScrollToPage(page = pagerState.currentPage - 1 )
                             }
                         }
                     )


                 }
                 NewsButton(text = buttomState.value[1], onClick = {
                     scope.launch {
                         if(pagerState.currentPage == 2){
                             event(OnBoardingEvent.saveDataEntry)
                         }else{
                             pagerState.animateScrollToPage(
                                 page = pagerState.currentPage + 1
                             )
                         }
                     }
                 })

             }
         }


         Spacer(modifier = Modifier.weight(0.5f))
         
     }
}