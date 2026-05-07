package com.example.exchangediary.ui.component

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuButton(
    onMenuClick: () -> Unit
) {
    TextButton(
        onClick = onMenuClick,
        modifier = Modifier
            .offset(x = (-14).dp, y = (-10).dp)
            .size(56.dp)
    ) {
        Text(
            text = "☰",
            style = MaterialTheme.typography.displaySmall
        )
    }
}