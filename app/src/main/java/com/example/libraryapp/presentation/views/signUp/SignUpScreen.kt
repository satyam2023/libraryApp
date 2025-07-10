package com.example.libraryapp.presentation.views.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libraryapp.data.LOCAL_IMAGES
import com.example.libraryapp.presentation.components.clickableText.ClickableText
import com.example.libraryapp.presentation.components.commonImage.CommonImage
import com.example.libraryapp.presentation.components.customButton.CustomButton
import com.example.libraryapp.presentation.components.customSpacer.CustomSpacer
import com.example.libraryapp.presentation.viewModel.SignUpViewModel
import com.example.libraryapp.ui.components.CommonTextInput

@Composable
fun SignUpScreen(viewModel: SignUpViewModel = viewModel()) {

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(WindowInsets.ime.asPaddingValues()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CustomSpacer(40)
                CommonImage(
                    LOCAL_IMAGES.AppLOGO,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.TopCenter)
                )
                CustomSpacer(40)
            }
            itemsIndexed(viewModel.signUpPlaceholder) { index, item ->
                CommonTextInput(
                    value = viewModel.signUpValue[index],
                    onValueChange = { viewModel.handleEnteredData(it, index) },
                    label = item.placeholder,
                    validationRules = item.validationSchema,
                    keyboardType = item.keyboardType,

                    )
                CustomSpacer(16)
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                CustomButton(
                    text = "Sign Up",
                    onClick = {
                        viewModel.handleSignUp()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    isPrimary = true
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            ClickableText(
                text = "have an account? Sign In",
                textAlign = TextAlign.Center,
                onClick = {
                    viewModel.navigateToSignIn()
                },
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
