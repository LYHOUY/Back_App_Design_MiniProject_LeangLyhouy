package com.example.bankappdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankappdesign.BalanceSection.BalanceSection
import com.example.bankappdesign.CardSection.CardSection
import com.example.bankappdesign.EditButtonSection.EditButtonSection
import com.example.bankappdesign.PagerSection.PagererSection
import com.example.bankappdesign.TopBarSection.TopBarSection
import com.example.bankappdesign.ui.theme.BankAppDesignTheme
import com.example.bankappdesign.ui.theme.Customblue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var isDarkMode by remember { mutableStateOf(false) }
            MaterialTheme(
                colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()
            ) {
                BankAppDesignTheme {
                    // A Surface container using the backgroundcolor from theme
                    SetBarColor(color = if (isDarkMode) Color.Black else Customblue)
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .safeDrawingPadding(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        HomeScreen(isDarkMode) { newIsDarkMode ->
                            isDarkMode = newIsDarkMode as Boolean
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color
        )
    }
}

// Main Screen
@Composable
fun HomeScreen(isDarkMode: Boolean, onDarkModeChange: (Boolean) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .background(color = Customblue)
            .fillMaxSize()
            .padding(18.dp)
    ) {
        item { TopBarSection() }
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item { BalanceSection() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { CardSection() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { PagererSection() }
        item { EditButtonSection(isDarkMode, onDarkModeChange) }
    }

}