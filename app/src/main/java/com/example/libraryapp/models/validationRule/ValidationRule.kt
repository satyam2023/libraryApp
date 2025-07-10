package com.example.libraryapp.models.validationRule

data class ValidationRule(
    val regex: Regex,
    val errorMessage: String
)