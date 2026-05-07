package com.example.exchangediary.ui.screen.friend

import androidx.compose.foundation.background
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exchangediary.ui.component.MenuButton

@Composable
fun AddFriendScreen(
    currentPartnerName: String,
    onSavePartner: (String) -> Unit,
    onMenuClick: () -> Unit
) {
    var partnerName by remember { mutableStateOf(currentPartnerName) }
    var friendCode by remember { mutableStateOf("") }

    val beige = Color(0xFFF7F0E8)
    val brown = Color(0xFF8C6A5D)
    val lightBrown = Color(0xFFD8C2B5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(beige)
            .statusBarsPadding()
            .padding(24.dp)
    ) {
        MenuButton(onMenuClick = onMenuClick)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Add Friend Prototype",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Frontend-only demo page")

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = partnerName,
            onValueChange = { partnerName = it },
            label = { Text("Partner Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = friendCode,
            onValueChange = { friendCode = it },
            label = { Text("Friend Code") },
            placeholder = { Text("Optional demo code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { onSavePartner(partnerName) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = brown,
                contentColor = Color.White
            )
        ) {
            Text("Save Friend")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onSavePartner(currentPartnerName) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = lightBrown,
                contentColor = Color.Black
            )
        ) {
            Text("Back Home")
        }
    }
}