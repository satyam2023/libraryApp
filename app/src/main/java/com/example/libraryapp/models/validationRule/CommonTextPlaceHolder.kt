package com.example.libraryapp.models.validationRule

import androidx.compose.ui.text.input.KeyboardType

data class CommonTextPlaceHolder (
    val placeholder: String,
    val validationSchema:List<ValidationRule>,
    val maxLength:Int=20,
    val keyboardType: KeyboardType= KeyboardType.Text,
)