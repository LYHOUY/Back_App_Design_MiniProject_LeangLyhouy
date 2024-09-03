package com.example.bankappdesign.PagerSection

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankappdesign.PagerSection.components.PageIndicator
import com.example.bankappdesign.PagerSection.components.SinglePage
import com.example.bankappdesign.PagerSection.components.pages
import kotlinx.coroutines.delay

@Preview(showBackground = true, device = Devices.PIXEL_2, showSystemUi = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagererSection() {

    val pagerState = rememberPagerState(pageCount = { 3})

    Text(text = "News and Information", color = Color.White)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        contentAlignment = Alignment.Center,
    )
    {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(0.dp))
        { index ->
            SinglePage(page = pages[index])
        }
        PageIndicator(
            pagerState = pagerState,
            pageCount = pages.size
        )
    }

    // Auto display pager

    LaunchedEffect(Unit) {
        while(true) {
            delay(3000) // Delay for 3 seconds
            val nextPage = (pagerState.currentPage + 1) % pages.size
            pagerState.animateScrollToPage(nextPage)
        }
    }
}


