package com.example.libraryapp.presentation.components.clickableText

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.libraryapp.ui.theme.darkGray
import com.example.libraryapp.utils.getColor

@Composable
fun ClickableText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = getColor(darkGray),
    onClick: () -> Unit,
    textStyle: TextStyle=MaterialTheme.typography.bodySmall
) {
    Text(
        text = text,
        modifier = modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onClick()
        }.fillMaxWidth(),
        textAlign = textAlign,
        color = color,
        style =textStyle
    )
}
