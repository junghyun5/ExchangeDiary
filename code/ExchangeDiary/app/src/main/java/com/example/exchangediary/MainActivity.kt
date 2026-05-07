package com.example.exchangediary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import com.example.exchangediary.model.DiaryEntry
import com.example.exchangediary.ui.component.AppDrawer
import com.example.exchangediary.ui.screen.detail.DiaryDetailScreen
import com.example.exchangediary.ui.screen.friend.AddFriendScreen
import com.example.exchangediary.ui.screen.home.HomeScreen
import com.example.exchangediary.ui.screen.list.DiaryListScreen
import com.example.exchangediary.ui.screen.login.LoginScreen
import com.example.exchangediary.ui.screen.write.WriteScreen
import com.example.exchangediary.ui.theme.ExchangeDiaryTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExchangeDiaryTheme {
                ExchangeDiaryApp()
            }
        }
    }
}

@Composable
fun ExchangeDiaryApp() {
    var currentScreen by remember { mutableStateOf("home") }
    val diaryEntries = remember { mutableStateListOf<DiaryEntry>() }
    var selectedEntryIndex by remember { mutableStateOf(-1) }

    var currentUser by remember { mutableStateOf("Guest") }
    var partnerName by remember { mutableStateOf("No partner connected") }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navigateTo: (String) -> Unit = { screen ->
        currentScreen = screen
        scope.launch { drawerState.close() }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(onNavigate = navigateTo)
        }
    ) {
        when (currentScreen) {
            "home" -> HomeScreen(
                currentUser = currentUser,
                partnerName = partnerName,
                onWriteClick = { currentScreen = "write" },
                onListClick = { currentScreen = "list" },
                onMenuClick = { scope.launch { drawerState.open() } }
            )

            "write" -> WriteScreen(
                partnerName = partnerName,
                onSaveClick = { title, content, isTemporary ->
                    diaryEntries.add(
                        DiaryEntry(
                            title = title,
                            content = content,
                            isTemporary = isTemporary
                        )
                    )
                    currentScreen = "list"
                },
                onBackClick = { currentScreen = "home" },
                onMenuClick = { scope.launch { drawerState.open() } }
            )

            "list" -> DiaryListScreen(
                entries = diaryEntries,
                partnerName = partnerName,
                onEntryClick = { index ->
                    selectedEntryIndex = index
                    currentScreen = "detail"
                },
                onBackClick = { currentScreen = "home" },
                onMenuClick = { scope.launch { drawerState.open() } }
            )

            "detail" -> {
                if (selectedEntryIndex in diaryEntries.indices) {
                    DiaryDetailScreen(
                        entry = diaryEntries[selectedEntryIndex],
                        partnerName = partnerName,
                        onReactionClick = { emoji ->
                            val oldEntry = diaryEntries[selectedEntryIndex]
                            diaryEntries[selectedEntryIndex] =
                                oldEntry.copy(reactionEmoji = emoji)
                        },
                        onBackClick = { currentScreen = "list" },
                        onMenuClick = { scope.launch { drawerState.open() } }
                    )
                }
            }

            "login" -> LoginScreen(
                currentUser = currentUser,
                onLoginClick = { username ->
                    currentUser = if (username.isBlank()) "Guest" else username
                    currentScreen = "home"
                },
                onMenuClick = { scope.launch { drawerState.open() } }
            )

            "addFriend" -> AddFriendScreen(
                currentPartnerName = partnerName,
                onSavePartner = { newPartnerName ->
                    partnerName =
                        if (newPartnerName.isBlank()) "No partner connected" else newPartnerName
                    currentScreen = "home"
                },
                onMenuClick = { scope.launch { drawerState.open() } }
            )
        }
    }
}