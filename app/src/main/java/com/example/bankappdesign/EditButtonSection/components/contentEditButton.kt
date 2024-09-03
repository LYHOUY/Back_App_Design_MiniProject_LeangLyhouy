package com.example.bankappdesign.EditButtonSection.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappdesign.R
import com.example.bankappdesign.ui.theme.Customblue

@Composable
fun ContentEditButton(isDarkMode: Boolean, onDarkModeChange: (Boolean) -> Unit) {
    var selectedItem by remember { mutableStateOf<String?>(null) }
    MaterialTheme(
        colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Appearance",
                modifier = Modifier
                    .padding(10.dp)
                    .padding(top = 5.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsLists.forEach { it ->
                    AssistChip(
                        onClick = { selectedItem = it },
                        label = { Text(text = it) },
                        border = BorderStroke(0.dp, color = Color.White),
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = if (selectedItem == it) Color(0xFFCBE5FF)
                            else Color(0xFFE4E4E4), // Change colorbased on selection
                            leadingIconContentColor = Color.Black
                        ),
                        enabled = true,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            // Content selectedItem
            when (selectedItem) {

   //Themes

                "Themes" -> {
                    LazyRow {
                        items(list) { item ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(enabled = true) {}
                                    .clip(RoundedCornerShape(50.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = item),
                                    contentDescription = "",
                                    modifier = Modifier.size(120.dp)
                                )
                            }
                        }

                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        colors = ButtonDefaults.buttonColors(Customblue)
                    ) {
                        Text(text = "Save")
                    }
                }

// Dark Mode
                "Dark Mode" -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Dark Mode")
                        Switch(
                            checked = isDarkMode,
                            onCheckedChange = onDarkModeChange, // Use the callback here
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                uncheckedThumbColor = Color.White
                            )
                        )
                    }
                }

// Language

                "Language" -> {
                    LazyColumn {
                        items(language) { (contry, flag) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp, horizontal = 20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(id = flag),
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(text = contry, modifier = Modifier.padding(start = 20.dp), fontSize = 14.sp)

                            }
                        }
                    }
                }
            }
        }
    }
}


