package com.example.bankappdesign.BalanceSection.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappdesign.R
import com.example.bankappdesign.ui.theme.DefaultButton

@Preview(showBackground = true, device = Devices.PIXEL_2, showSystemUi = true)
@Composable
fun Content() {
    var showBalance by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .padding(start = 5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), // Fill the width
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text =  "1234567$" ,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                modifier = if (!showBalance) Modifier.blur(radius = 10.dp).padding(end = 10.dp) else Modifier // Blur if balance is hidden
                    .padding(end = 10.dp)
            )
            Box(modifier = Modifier.size(24.dp)) { // Fixed size container for icons
                if (showBalance) {
                    Image(
                        painter = painterResource(id = R.drawable.eyes),
                        contentDescription = "open eyes",
                        modifier = Modifier.clickable { showBalance = false }.fillMaxSize()
                    )} else {
                    Image(
                        painter = painterResource(id = R.drawable.close_eyes),
                        contentDescription = "close eyes",
                        modifier = Modifier.clickable { showBalance = true }.fillMaxSize()
                    )
                }
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 5.dp)
        ) {
            Text(
                "Default",
                color = Color.White,
                fontSize = 8.sp,
                modifier = Modifier
                    .width(43.dp)
                    .height(20.dp)
                    .background(
                        color = DefaultButton,
                        shape = RoundedCornerShape(5.dp)
                    ),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Saving",
                color = Color.White,
                fontSize = 8.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }


        // Received and sent money

        Row(
            modifier = Modifier.padding(top = 35.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.money_receive),
                contentDescription = "", modifier = Modifier.size(15.dp)
            )
            Text(
                text = "Received Money",
                fontSize = 11.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.money_send),
                contentDescription = "",
                modifier = Modifier.size(15.dp)
            )
            Text(
                text = "Send Money",
                fontSize = 11.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}