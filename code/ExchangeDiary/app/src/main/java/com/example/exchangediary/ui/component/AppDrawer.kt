package com.example.exchangediary.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawer(
    onNavigate: (String) -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.75f),
        drawerContainerColor = Color(0xFFF7F0E8)
    ) {
        Text(
            text = "Exchange Diary",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(24.dp)
        )

        NavigationDrawerItem(
            label = { Text("Home") },
            selected = false,
            onClick = { onNavigate("home") }
        )

        NavigationDrawerItem(
            label = { Text("Write Entry") },
            selected = false,
            onClick = { onNavigate("write") }
        )

        NavigationDrawerItem(
            label = { Text("Shared Diary") },
            selected = false,
            onClick = { onNavigate("list") }
        )

        NavigationDrawerItem(
            label = { Text("Login") },
            selected = false,
            onClick = { onNavigate("login") }
        )

        NavigationDrawerItem(
            label = { Text("Add Friend") },
            selected = false,
            onClick = { onNavigate("addFriend") }
        )
    }
}