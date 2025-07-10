package com.example.libraryapp.presentation.components.commonImage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun CommonImage(
    @DrawableRes drawableResId: Int,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale= ContentScale.FillWidth
) {
    Image(
        painter = painterResource(id = drawableResId),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale =contentScale
    )
}
