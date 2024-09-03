package com.example.bankappdesign.BalanceSection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.bankappdesign.BalanceSection.components.Content
import com.example.bankappdesign.ui.theme.BlurLeft
import com.example.bankappdesign.ui.theme.BlurRight
import com.example.bankappdesign.ui.theme.LinearPurple
import com.example.bankappdesign.ui.theme.LinearPurple45
import com.example.bankappdesign.ui.theme.LinearPurple48
import com.example.bankappdesign.ui.theme.LinearRed
//@Preview(showBackground = true, device = Devices.PIXEL_2, showSystemUi = true)
@Composable
fun BalanceSection(){
    val linear = Brush.linearGradient(listOf(LinearRed, LinearPurple, LinearPurple45, LinearPurple48))
    val blurBg = Brush.linearGradient(listOf(BlurLeft, BlurRight))

    Box {
        // Blurred background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(blurBg, shape = RoundedCornerShape(20.dp))
                .blur(radius = 500.dp) // Apply blur to the background
        )

        // Content
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .border(2.dp, linear, shape = RoundedCornerShape(20.dp))
        ) {
            Content() // Separate composable for content

        }
    }
}