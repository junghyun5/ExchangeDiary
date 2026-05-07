package com.example.exchangediary.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exchangediary.ui.component.MenuButton
import com.example.exchangediary.ui.component.ProfileBanner

@Composable
fun HomeScreen(
    currentUser: String,
    partnerName: String,
    onWriteClick: () -> Unit,
    onListClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    val beige = Color(0xFFF7F0E8)
    val brown = Color(0xFF8C6A5D)
    val lightBrown = Color(0xFFD8C2B5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(beige)
            .statusBarsPadding()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        MenuButton(onMenuClick = onMenuClick)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Exchange Diary",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "A cozy shared journal where you and your partner can write, react, and keep memories together.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(18.dp))

        ProfileBanner(
            currentUser = currentUser,
            partnerName = partnerName
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onWriteClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = brown,
                contentColor = Color.White
            )
        ) {
            Text("Write Entry")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onListClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = lightBrown,
                contentColor = Color.Black
            )
        ) {
            Text("View Entries")
        }
    }
}