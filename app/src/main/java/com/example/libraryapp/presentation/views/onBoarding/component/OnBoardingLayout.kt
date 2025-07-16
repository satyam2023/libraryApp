import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.libraryapp.data.IllustrationData
import com.example.libraryapp.data.LOCAL_IMAGES
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
    val onboardingData = remember { IllustrationData }
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val imageHeight = remember(screenHeight) { (screenHeight * 0.3).dp }
    val pagerState = rememberPagerState(pageCount = { onboardingData.size })
    val currentPage = pagerState.currentPage
    val activeIndicatorColor = remember { getColor(red) }
    val inactiveIndicatorColor = remember { Color.LightGray }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // Skip button
        ClickableText(
            text = "skip",
            onClick = onSkipClick,
            textStyle = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Right,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )

        // Main content pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(bottom = 10.dp)
                .align(Alignment.Center)
        ) { page ->
            OnBoardingPage(
                data = onboardingData[page],
                imageHeight = imageHeight
            )
        }

        // Page indicators (optimized)
        PageIndicators(
            pageCount = onboardingData.size,
            currentPage = currentPage,
            activeColor = activeIndicatorColor,
            inactiveColor = inactiveIndicatorColor,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        )

        // Bottom buttons
        BottomButtons(
            currentPage = currentPage,
            onBackClick = onBackClick,
            onNextClick = onNextClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}

@Composable
private fun OnBoardingPage(
    data:IllustrationData,
    imageHeight: androidx.compose.ui.unit.Dp
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CommonImage(
             data.imageUrl,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight)
        )

        CustomSpacer(30)

        Text(
            text = data.title.orEmpty(),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        CustomSpacer(8)

        Text(
            text = data.description.orEmpty(),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun PageIndicators(
    pageCount: Int,
    currentPage: Int,
    activeColor: Color,
    inactiveColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(
                        if (index == currentPage) activeColor else inactiveColor
                    )
            )
        }
    }
}

@Composable
private fun BottomButtons(
    currentPage: Int,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomButton(
            text = "Back",
            onClick = onBackClick,
            modifier = Modifier
                .weight(1f)
                .alpha(if (currentPage != 0) 1f else 0f),
            isPrimary = false
        )
        
        Spacer(modifier = Modifier.width(100.dp))
        
        CustomButton(
            text = "Next",
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        )
    }
}