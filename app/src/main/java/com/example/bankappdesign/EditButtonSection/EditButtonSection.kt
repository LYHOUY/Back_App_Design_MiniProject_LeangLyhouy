package com.example.bankappdesign.EditButtonSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappdesign.EditButtonSection.components.ContentEditButton
import com.example.bankappdesign.R
import kotlinx.coroutines.launch

data class items(val item: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditButtonSection(isDarkMode: Boolean, onDarkModeChange: (Boolean) -> Unit) {
    var showBottomSheet by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.Center, // Vertically center content
        horizontalAlignment = Alignment.CenterHorizontally // Horizontally center content
    ){
        Button(
            onClick = { showBottomSheet = true },
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(text = "Edit Home", fontSize = 10.sp, color = Color.Black)
        }
    }

    if (showBottomSheet){
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            modifier = Modifier.fillMaxSize()
        )
        {
            Column {
                ContentEditButton(isDarkMode, onDarkModeChange)
            }
        }
    }

}