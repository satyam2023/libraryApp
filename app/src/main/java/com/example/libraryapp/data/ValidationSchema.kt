import com.example.libraryapp.models.validationRule.ValidationRule

object REGEX {
    val EmailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
   val PhoneNumberRegex = Regex("^\\d{10}\$")
    val NameRegex = Regex("^[A-Za-z ]+\$")
//    val UsernameRegex = Regex("^[a-zA-Z0-9_]{4,16}\$")
    val PasswordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")
//    val PinCodeRegex = Regex("^\\d{6}\$")
//    val UrlRegex = Regex("^(https?|ftp)://[^\\s/$.?#].[^\\s]*\$")
//    val OnlyDigits = Regex("^\\d+\$")
//    val OnlyAlphabets = Regex("^[A-Za-z]+\$")
//    val AlphaNumeric = Regex("^[A-Za-z0-9]+\$")
}


val EmailRule= listOf(
    ValidationRule(REGEX.EmailRegex, "Invalid email format"),
)

val PasswordRule= listOf(
    ValidationRule(REGEX.PasswordRegex, "Invalid password format"),
)

val PhoneNumberRule = listOf(
    ValidationRule(REGEX.PhoneNumberRegex, errorMessage = "Phone number must be 10 digits")
)

val NameRule = listOf(
    ValidationRule(REGEX.NameRegex, errorMessage = "Invalid name format")
)


