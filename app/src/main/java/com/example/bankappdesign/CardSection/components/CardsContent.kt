package com.example.bankappdesign.CardSection.components

import android.graphics.Color.alpha
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappdesign.R
import com.example.bankappdesign.ui.theme.CardColor1
import com.example.bankappdesign.ui.theme.CardColor2
import com.example.bankappdesign.ui.theme.TextColorEnd

@Preview(showBackground = true, device = Devices.PIXEL_2, showSystemUi = true)
@Composable
fun Cards() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(15.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items) { item ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
                ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .height(height = 90.dp)
                        .background(brush = cardColor, shape = RoundedCornerShape(15.dp)),
                ) {
                    Row(
                        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 10.dp)
                        )
                    }

                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()) {
                        Text(
                            text = item.cardTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 10.dp),
                            style = TextStyle(
                                brush = Brush.linearGradient(
                                    colors = textColor
                                )
                            )
                        )
                        Text(
                            text = item.cardSub,
                            fontSize = 8.5.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }
        }
    }
}



