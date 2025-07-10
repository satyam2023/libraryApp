package com.example.libraryapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryapp.models.validationRule.ValidationRule
import com.example.libraryapp.ui.theme.darkGray
import com.example.libraryapp.ui.theme.lightGray
import com.example.libraryapp.ui.theme.red
import com.example.libraryapp.utils.getColor

@Composable
fun CommonTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    validationRules: List<ValidationRule> = emptyList(),
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
) {

    var enteredText by remember { mutableStateOf(value) }
    val isError = if (enteredText.isNotEmpty()) {
        validationRules.any { !it.regex.matches(enteredText) }
    } else {
        false ;
    }
    val errorMessage = validationRules.firstOrNull { !it.regex.matches(enteredText) }?.errorMessage ?: ""

    fun handleValueChange(newValue: String) {
        enteredText = newValue
        onValueChange(newValue)
    }

    Column {
        OutlinedTextField(
            value = enteredText,
            onValueChange = { newValue ->
                handleValueChange(newValue)
            },
            label = { if (label.isNotEmpty()) Text(label) },
            modifier = Modifier.fillMaxWidth(),
            isError = isError,
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (isError) getColor(red) else getColor(darkGray),
                unfocusedBorderColor =getColor(darkGray),
                cursorColor = getColor(darkGray),
                focusedLabelColor = if (isError) getColor(red) else getColor(darkGray),
                unfocusedLabelColor = getColor(darkGray)
            ),
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color =  getColor(darkGray),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 21.sp,
            ),
        )

        if (isError && errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.fillMaxWidth().height(6.dp))
            Text(
                text = errorMessage,
                color = getColor(red),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
