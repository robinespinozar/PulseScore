package com.raerossi.pulsescore.composeutils

import android.graphics.BlurMaskFilter
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.ui.theme.extraSmallShadow
import com.raerossi.pulsescore.ui.theme.largeShadow
import com.raerossi.pulsescore.ui.theme.midShadow
import com.raerossi.pulsescore.ui.theme.smallShadow

object ShadowSizes {
    const val xsSize = 1
    const val smSize = 2
    const val mdSize = 3
    const val lgSize = 4
}

@Composable
fun Modifier.shadow(size: Int) = when (size) {
    ShadowSizes.xsSize -> getShadow(
        color = MaterialTheme.colorScheme.extraSmallShadow,
        alpha = 0.05f,
        blurRadius = 24.dp,
        offsetY = 12.dp,
        spread = 10f.dp
    )
    ShadowSizes.smSize -> getShadow(
        color = MaterialTheme.colorScheme.smallShadow,
        alpha = 0.15f,
        blurRadius = 32.dp,
        offsetY = 24.dp,
        spread = 15f.dp
    )
    ShadowSizes.mdSize -> getShadow(
        color = MaterialTheme.colorScheme.midShadow,
        alpha = 0.15f,
        blurRadius = 48.dp,
        offsetY = 32.dp,
        spread = 20f.dp
    )
    ShadowSizes.lgSize -> getShadow(
        color = MaterialTheme.colorScheme.largeShadow,
        alpha = 0.15f,
        blurRadius = 56.dp,
        offsetY = 48.dp,
        spread = 25f.dp
    )
    else -> getShadow(
        color = Color.Black,
        alpha = 0.2f,
        blurRadius = 30.dp,
        offsetY = 25.dp,
        spread = 20f.dp
    )
}

fun Modifier.getShadow(
    color: Color = Color.Black,
    alpha: Float = 0f,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx()
            val topPixel = (0f - spreadPixel) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel)
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = Color(color.red, color.green, color.blue, alpha).toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)

fun Modifier.shadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter = (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }
            //frameworkPaint.color = color.toArgb()
            frameworkPaint.color = Color(color.red, color.green, color.blue, 0.2f).toArgb()

            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + topPixel
            val bottomPixel = size.height + leftPixel

            canvas.drawRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                paint = paint,
            )
        }
    }
)