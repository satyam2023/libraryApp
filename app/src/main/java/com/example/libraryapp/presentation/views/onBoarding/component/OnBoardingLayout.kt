import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.libraryapp.presentation.components.clickableText.ClickableText
import com.example.libraryapp.presentation.components.commonImage.CommonImage
import com.example.libraryapp.presentation.components.customButton.CustomButton
import com.example.libraryapp.presentation.components.customSpacer.CustomSpacer
import com.example.libraryapp.ui.theme.red
import com.example.libraryapp.utils.getColor

@Composable
fun OnBoardingLayout(
    onNextClick: () -> Unit,
    onSkipClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            "skip",
            onClick = onSkipClick,
            textStyle = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Right
        )

        Column(
            modifier = Modifier.fillMaxSize().background(getColor(red)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

        }




        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)
        ) {

            CustomSpacer(34)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CustomButton(
                    text = "Back",
                    onClick = onBackClick,
                    modifier = Modifier.weight(1f),
                    isPrimary = false
                )
                Spacer(modifier = Modifier.width(100.dp))
                CustomButton(text = "Next", onClick = onNextClick, modifier = Modifier.weight(1f))
            }

        }
    }
}