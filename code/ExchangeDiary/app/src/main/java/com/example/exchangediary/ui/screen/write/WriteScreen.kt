package com.example.exchangediary.ui.screen.write

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exchangediary.ui.component.MenuButton

@Composable
fun WriteScreen(
    partnerName: String,
    onSaveClick: (String, String, Boolean) -> Unit,
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var isTemporary by remember { mutableStateOf(false) }

    val beige = Color(0xFFF7F0E8)
    val brown = Color(0xFF8C6A5D)
    val lightBrown = Color(0xFFD8C2B5)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(beige)
            .statusBarsPadding()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            MenuButton(onMenuClick = onMenuClick)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Write Entry",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "For partner: $partnerName")

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                placeholder = { Text("#mood:Happy\nWrite your diary here...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                minLines = 10
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "24-hour disappearing diary",
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = isTemporary,
                    onCheckedChange = { isTemporary = it }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { onSaveClick(title, content, isTemporary) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = brown,
                    contentColor = Color.White
                )
            ) {
                Text("Save Entry")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = lightBrown,
                    contentColor = Color.Black
                )
            ) {
                Text("Go Back")
            }
        }
    }
}