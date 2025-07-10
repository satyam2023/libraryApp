package com.example.libraryapp.presentation.components.customButton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.libraryapp.ui.theme.secondary
import com.example.libraryapp.ui.theme.white
import com.example.libraryapp.utils.getColor

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    isPrimary: Boolean = true
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(42.dp).border(
                width = 1.dp,
                color =  getColor(secondary),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(enabled = enabled) { onClick() }.background(
           color= if (isPrimary) getColor( secondary)
            else getColor( white),
                shape = RoundedCornerShape(16.dp)
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = if (isPrimary) getColor(white) else getColor(secondary),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
