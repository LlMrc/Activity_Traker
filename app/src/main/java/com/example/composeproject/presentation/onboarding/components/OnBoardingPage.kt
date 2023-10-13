package com.example.composeproject.presentation.onboarding.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeproject.R
import com.example.composeproject.presentation.Dimention.MediumPadding1
import com.example.composeproject.presentation.Dimention.MediumPadding2
import com.example.composeproject.presentation.onboarding.Page

@Composable
fun OnboardingPage(
    page: Page,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
      Image(
          modifier = Modifier
              .fillMaxWidth()
              .fillMaxHeight(fraction = 0.6f),
          painter = painterResource(id = page.image),
          contentDescription = page.title ,
          contentScale = ContentScale.Crop )
        
        Spacer(modifier = Modifier.height(MediumPadding1))
        
        Text(text = page.title, modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.black)
         )

        Text(text = page.description, modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.black)
        )


    }
}
