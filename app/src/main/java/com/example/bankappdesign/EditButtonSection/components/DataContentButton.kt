package com.example.bankappdesign.EditButtonSection.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.bankappdesign.R

// List for Appearance Button
val itemsLists = listOf("Themes", "Dark Mode", "Language")

// Image in Themes
val list = listOf(
    (R.drawable.imgthemes),
    (R.drawable.imgthemes),
    (R.drawable.imgthemes),
    (R.drawable.imgthemes),
)
// Data for Language
val language = listOf(
    Pair("Khmer", R.drawable.cambo),
    Pair("Thai", R.drawable.thai),
    Pair("Japanese", R.drawable.japan),
    Pair("Chinese", R.drawable.china),
)