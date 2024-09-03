package com.example.bankappdesign.TopBarSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.bankappdesign.Configuration.QRCodeGenerator
import com.example.bankappdesign.R
import com.example.bankappdesign.ui.theme.Customblue

@Preview(showBackground = true, device = Devices.PIXEL_2, showSystemUi = true)
@Composable
fun TopBarSection() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    val link = "https://pay.ababank.com/FWBWSkjgKqN7qYoW7"   // Link for QR-Code

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Customblue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            //Profile
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .size(45.dp)
                    .clip(shape = CircleShape)
                    .border(width = 2.dp, color = Color.White, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            // profile name

            Column {
                Text(
                    text = "Hello,Ly Houy!",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "View Profile",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }

        // Icon Noti & QR-Cdde
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.noti),
                contentDescription = "Notification",
                modifier = Modifier
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.qr_code),
                contentDescription = "QR_Code",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { showDialog = true }
            )
        }
    }

    // show Dialog QR Code

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(16.dp) // Add padding for content
            ) {
                Column {Image(
                    painter = painterResource(id = R.drawable.khqr),
                    contentDescription = "KHQR"
                )
                }

                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 38.dp)
                ) {
                    QRCodeGenerator(link)
                }
                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .align(Alignment.TopStart)
                        .padding(top = 43.dp)
                ) {
                    Text(text = "Leang Lyhouy", fontSize = 14.sp)
                    Text(text = "0 $", fontSize = 14.sp)
                }
            }
        }
    }
}