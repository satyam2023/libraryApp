package com.example.libraryapp.presentation.components.customSpacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacer(
    height: Int = 16,
) {
Spacer(
        modifier = Modifier
            .height(height.dp).fillMaxWidth()

    )
}