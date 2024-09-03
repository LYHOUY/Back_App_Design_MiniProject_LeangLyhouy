package com.example.bankappdesign.CardSection.components

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.bankappdesign.R
import com.example.bankappdesign.ui.theme.TextColorEnd

data class CardData(
    val image: Int,
    val cardTitle: String,
    val cardSub: String,
)

val textColor = listOf(TextColorEnd, Color.Black)
val cardColor = Brush.horizontalGradient(listOf(Color(0xFFEBF2F9).copy(0.65f), Color(0xFFC6D7EB)))

val items = listOf(
    CardData(image = R.drawable.wallet, cardTitle = "Accounts", cardSub = "Your balance"),
    CardData(image = R.drawable.pay_bills,cardTitle = "Pay bills",cardSub = "School, Shop, ect"),
    CardData(image = R.drawable.transfer2, cardTitle = "Transfer", cardSub = "Send money"),
    CardData(image = R.drawable.favorite, cardTitle = "Favorites", cardSub = "Users"),
    CardData(image = R.drawable.scan, cardTitle = "BAB Scan", cardSub = "School, Shop, etc"),
    CardData(image = R.drawable.service, cardTitle = "Service", cardSub = "Your balance")
)