package com.example.composeproject.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.composeproject.R


data class Page(
    val title: String,
    val description :String,
    @DrawableRes val image : Int
)



val pages = listOf<Page>(
    Page(
        title = "title number 1",
        description = "description description description description description description",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "title number 1",
        description = "description description description",
        image = R.drawable.onboarding2

    ),
    Page(
        title = "title number 1",
        description = "description description description",
        image = R.drawable.onboarding3
    ),
)

