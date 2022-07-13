package com.prmto.borutoapp.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.prmto.borutoapp.ui.theme.*

@Composable
fun ShimmerEffect() {

}

@Composable
fun AnimatedShimmerItem() {
    val transition = rememberInfiniteTransition()
    val alphaAnim by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    ShimmerItem(alpha = alphaAnim)
}

@Composable
fun ShimmerItem(alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = if (isSystemInDarkTheme())
            Color.Black else ShimmerLightGray,
        shape = RoundedCornerShape(LARGE_PADDING)
    ) {
        Column(
            modifier = Modifier.padding(MEDIUM_PADDING),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .fillMaxWidth(0.5f)
                    .height(NAME_PLACEHOLDER_HEIGHT),
                color = if (isSystemInDarkTheme())
                    ShimmerDarkGray else ShimmerMediumGray,
                shape = RoundedCornerShape(SMALL_PADDING)
            ) {}
            Spacer(modifier = Modifier.padding(SMALL_PADDING))
            repeat(3) {
                Surface(
                    modifier = Modifier
                        .alpha(alpha = alpha)
                        .fillMaxWidth()
                        .height(ABOUT_PLACEHOLDER_HEIGHT),
                    color = if (isSystemInDarkTheme())
                        ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(SMALL_PADDING)
                ) {}
                Spacer(modifier = Modifier.padding(EXTRA_SMALL_PADDING))
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                repeat(5) {
                    Surface(
                        modifier = Modifier
                            .alpha(alpha = alpha)
                            .size(RATING_PLACEHOLDER_HEIGHT),
                        color = if (isSystemInDarkTheme())
                            ShimmerDarkGray else ShimmerMediumGray,
                        shape = RoundedCornerShape(SMALL_PADDING)
                    ) {}
                    Spacer(modifier = Modifier.padding(SMALL_PADDING))
                }
            }
        }
    }
}

@Preview
@Composable
fun ShimmerItemPreview() {
    AnimatedShimmerItem()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerDarkItemPreview() {
    AnimatedShimmerItem()
}