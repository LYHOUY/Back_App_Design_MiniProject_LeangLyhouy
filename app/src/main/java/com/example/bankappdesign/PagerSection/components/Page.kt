package com.example.bankappdesign.PagerSection.components

import androidx.annotation.DrawableRes
import com.example.bankappdesign.R

data class Page(
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        image = R.drawable.slide01
    ),
    Page(
        image = R.drawable.slide02
    ),
    Page(
        image = R.drawable.slide03
    ),
)