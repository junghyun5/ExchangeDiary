package com.example.exchangediary.ui.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exchangediary.model.DiaryEntry
import com.example.exchangediary.ui.component.MenuButton

@Composable
fun DiaryListScreen(
    entries: List<DiaryEntry>,
    partnerName: String,
    onEntryClick: (Int) -> Unit,
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    val visibleEntries = entries.filterNot { it.isExpired() }

    val filteredEntries = visibleEntries.filter { entry ->
        entry.title.contains(searchText, ignoreCase = true) ||
                entry.content.contains(searchText, ignoreCase = true)
    }

    val beige = Color(0xFFF7F0E8)
    val lightBrown = Color(0xFFD8C2B5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(beige)
            .statusBarsPadding()
            .padding(24.dp)
    ) {
        MenuButton(onMenuClick = onMenuClick)

        Text(
            text = "Shared Diary",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Partner: $partnerName",
            modifier = Modifier.padding(top = 8.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search entries") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            itemsIndexed(filteredEntries) { _, entry ->
                val originalIndex = entries.indexOf(entry)
                val moodTag = entry.extractMoodTag()
                val cleanContent = entry.extractCleanContent()

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onEntryClick(originalIndex) }
                        .padding(vertical = 12.dp)
                ) {
                    Text(
                        text = entry.title,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "From me · To $partnerName",
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    if (entry.isTemporary) {
                        Text(
                            text = "Temporary · disappears after 24 hours",
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    if (moodTag != null) {
                        Text(
                            text = "Mood: $moodTag",
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    if (entry.reactionEmoji != null) {
                        Text(
                            text = "Partner reaction: ${entry.reactionEmoji}",
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    Text(
                        text = cleanContent,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }

                HorizontalDivider()
            }
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = lightBrown,
                contentColor = Color.Black
            )
        ) {
            Text("Go Back")
        }
    }
}