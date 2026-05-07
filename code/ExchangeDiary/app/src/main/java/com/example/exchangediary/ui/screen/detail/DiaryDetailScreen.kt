package com.example.exchangediary.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exchangediary.model.DiaryEntry
import com.example.exchangediary.ui.component.MenuButton

@Composable
fun DiaryDetailScreen(
    entry: DiaryEntry,
    partnerName: String,
    onReactionClick: (String) -> Unit,
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    val beige = Color(0xFFF7F0E8)
    val brown = Color(0xFF8C6A5D)
    val lightBrown = Color(0xFFD8C2B5)

    val moodTag = entry.extractMoodTag()
    val cleanContent = entry.extractCleanContent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(beige)
            .statusBarsPadding()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        MenuButton(onMenuClick = onMenuClick)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Diary Detail",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Title: ${entry.title}")
        Text(
            text = "From me · To $partnerName",
            modifier = Modifier.padding(top = 8.dp)
        )

        if (entry.isTemporary) {
            Text(
                text = "Temporary Entry (24 hours)",
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        if (moodTag != null) {
            Text(
                text = "Mood: $moodTag",
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Text(
            text = "Content: $cleanContent",
            modifier = Modifier.padding(top = 12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Partner Reaction",
            style = MaterialTheme.typography.titleMedium
        )

        Row(modifier = Modifier.padding(top = 12.dp)) {
            listOf("❤️", "😊", "🥹", "😢").forEach { emoji ->
                Button(
                    onClick = { onReactionClick(emoji) },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = lightBrown,
                        contentColor = Color.Black
                    )
                ) {
                    Text(emoji)
                }
            }
        }

        if (entry.reactionEmoji != null) {
            Text(
                text = "Selected reaction: ${entry.reactionEmoji}",
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = brown,
                contentColor = Color.White
            )
        ) {
            Text("Go Back")
        }
    }
}