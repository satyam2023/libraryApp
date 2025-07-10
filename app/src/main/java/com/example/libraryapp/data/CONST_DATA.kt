package com.example.libraryapp.data

import EmailRule
import IllustrationData
import NameRule
import PasswordRule
import PhoneNumberRule
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import com.example.libraryapp.models.validationRule.CommonTextPlaceHolder
import com.example.libraryapp.models.validationRule.ValidationRule

val SignInFields = listOf(
    CommonTextPlaceHolder(
        placeholder = "Enter your email",
        validationSchema = EmailRule,
        maxLength = 30,
        keyboardType = KeyboardType.Email
    ),
    CommonTextPlaceHolder(
        placeholder = "Enter your password",
        validationSchema = PasswordRule,
        maxLength = 30,
    )

)

val SignUpFields = listOf(
    CommonTextPlaceHolder(
        placeholder = "Name",
        validationSchema = NameRule,
        maxLength = 30,
    ),
    CommonTextPlaceHolder(
        placeholder = "Email",
        validationSchema = EmailRule,
        maxLength = 30,
    ),
    CommonTextPlaceHolder(
        placeholder = "Phone Number",
        validationSchema = PhoneNumberRule,
        maxLength = 10,
        keyboardType = KeyboardType.Number
    ),
    CommonTextPlaceHolder(
        placeholder = "Password",
        validationSchema = PasswordRule,
        maxLength = 30,
    ),
    CommonTextPlaceHolder(
        placeholder = "Re-Password",
        validationSchema = PasswordRule,
        maxLength = 30,

        )

);

val IllustrationData=listOf<IllustrationData>(
    object : IllustrationData {
        override val id: Int = 1
        override val title: String = "Enjoy the World of Reading and Sharing Together"
        override val description: String = "Discover thousands of books and meet your book bestie!"
        override val imageUrl: Int = LOCAL_IMAGES.OnBoardingImage1
    },
    object : IllustrationData {
        override val id: Int = 2
        override val title: String = "Read and Make Friends Without Limits"
        override val description: String = "Read Anytime, Connect Anywhere with iJogja"
        override val imageUrl: Int = LOCAL_IMAGES.OnBoardingImage2
    },
       object : IllustrationData {
        override val id: Int = 3
        override val title: String = "Welcome to the iJogja Community"
        override val description: String = "Enhance Your Reading Experience with Social Features on iJogja"
        override val imageUrl: Int = LOCAL_IMAGES.OnBoardingImage3
    }
)