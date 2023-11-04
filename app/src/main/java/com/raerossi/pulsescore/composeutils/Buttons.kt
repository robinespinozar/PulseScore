package com.raerossi.pulsescore.composeutils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.md_theme_light_outline
import com.raerossi.pulsescore.ui.theme.md_theme_light_primary
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_80
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_95
import com.raerossi.pulsescore.ui.theme.md_theme_ref_primary30
import com.raerossi.pulsescore.ui.theme.md_theme_ref_primary50
import com.raerossi.pulsescore.ui.theme.primary30
import com.raerossi.pulsescore.ui.theme.primary40
import com.raerossi.pulsescore.ui.theme.primaryGradient
import com.raerossi.pulsescore.ui.theme.secondaryGradient

/**
 * A Custom Buttons allows use different kind of customize buttons.
 *
 * @param modifier
 * @param text
 * @param height
 * @param enabled
 * @param darkMode
 * @param onClick
 *
 */

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    height: Int = 48,
    enabled: Boolean = true,
    darkMode: Boolean = false,
    onClick: () -> Unit
) {
    GradientButton(
        modifier = modifier
            .height(height.dp)
            .fillMaxWidth(),
        text = text,
        enabled = enabled,
        darkMode = darkMode,
        gradient = if (darkMode) secondaryGradient else primaryGradient,
        onClick = { onClick() }
    )
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    height: Int = 48,
    darkMode: Boolean = false,
    onClick: () -> Unit
) {
    GradientSecondaryButton(
        modifier = modifier
            .height(height.dp)
            .fillMaxWidth(),
        text = text,
        darkMode = darkMode,
        onClick = { onClick() }
    )
}

@Composable
fun LinkButton(
    textDescription: String,
    textAction: String,
    height: Int = 48,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .height(height.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick = { onClick() }
    ) {
        ContentLinkButton(textDescription = textDescription, textAction = textAction)
    }
}

@Composable
fun CTAButton(
    modifier: Modifier = Modifier,
    text: String,
    height: Int = 48,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .height(height.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = md_theme_ref_neutralVariant_95,
            contentColor = md_theme_ref_primary30
        ),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun IconAndTextButton(
    icon: Int,
    textPrefix: String,
    textSuffix: String = "",
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, md_theme_light_outline)
    ) {
        ContentIconText(
            textPrefix = textPrefix,
            textSuffix = textSuffix,
            icon = icon
        )
    }
}

@Composable
fun OptionButtons(
    modifier: Modifier = Modifier,
    firstText: String,
    secondText: String
) {
    Card(
        modifier = modifier
            .shadow(
                color = Color.Black,
                offsetX = 1.dp,
                offsetY = (-1.5).dp,
                blurRadius = 4.dp,
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            Modifier
                .padding(horizontal = 16.dp)
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CTAButton(
                modifier = Modifier
                    .weight(1f),
                text = firstText
            ) {
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(modifier = Modifier
                .weight(1f)
                .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary40
                ),
                onClick = { }) {
                Text(text = secondText, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Composable
fun FavoriteActions(modifier: Modifier = Modifier) {
    OptionButtons(
        modifier = modifier,
        firstText = "Skip",
        secondText = "Continue"
    )
}

@Composable
fun ContentIconText(
    textPrefix: String,
    textSuffix: String,
    icon: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LinkIcon(icon = icon)
        ContentText(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            textPrefix = textPrefix,
            textSuffix = textSuffix
        )
    }
}

@Composable
fun LinkIcon(
    icon: Int
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier.size(24.dp),
        tint = Color.Unspecified
    )
}

@Composable
fun ContentText(
    textPrefix: String,
    textSuffix: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "$textPrefix ",
                color = md_theme_ref_primary50,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = textSuffix,
                color = md_theme_ref_primary30,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Composable
fun ContentLinkButton(
    textDescription: String,
    textAction: String
) {
    Row {
        Text(
            text = "$textDescription ",
            color = md_theme_ref_primary30,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = textAction,
            color = md_theme_ref_primary50,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun GradientButton(
    text: String,
    enabled: Boolean,
    darkMode: Boolean,
    gradient: Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = md_theme_ref_neutralVariant_95
        )
    ) {
        ContentButton(
            text = text,
            darkMode = darkMode,
            enabled = enabled,
            modifier = if (enabled)
                Modifier
                    .background(gradient)
                    .then(modifier) else Modifier
        )
    }
}

@Composable
fun GradientSecondaryButton(
    text: String,
    darkMode: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            disabledContainerColor = md_theme_ref_neutralVariant_95
        )
    ) {
        ContentSecondaryButton(
            text = text,
            darkMode = darkMode,
            modifier = if (darkMode)
                Modifier
                    .background(primaryGradient)
                    .then(modifier) else Modifier
        )
    }
}

@Composable
fun ContentButton(
    text: String,
    darkMode: Boolean,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = getTextColor(enabled, darkMode),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

fun getTextColor(
    enabled: Boolean,
    darkMode: Boolean
) = if (enabled) {
    if (darkMode) md_theme_ref_primary30 else Color.White
} else {
    md_theme_ref_neutralVariant_80
}

@Composable
fun ContentSecondaryButton(
    text: String,
    darkMode: Boolean,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = if (darkMode) Color.White else md_theme_light_primary,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonsPreviews() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            PrimaryButton(text = "Sign up") {}
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(text = "Open email app", darkMode = true) {}
            Spacer(modifier = Modifier.height(16.dp))
            LinkButton(textDescription = "Don't have an account", textAction = "Sign Up") {}
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(text = "Sign up", enabled = false) {}
            Spacer(modifier = Modifier.height(16.dp))
            CTAButton(text = "Log in") {}
            Spacer(modifier = Modifier.height(16.dp))
            IconAndTextButton(
                textPrefix = "Continue with",
                textSuffix = "Google",
                icon = R.drawable.ic_google
            ) {}
            Spacer(modifier = Modifier.height(16.dp))
            SecondaryButton(text = "Skip for now") {}
            Spacer(modifier = Modifier.height(16.dp))
            SecondaryButton(text = "Skip for now", darkMode = true) {}
            Spacer(modifier = Modifier.height(16.dp))
            OptionButtons(firstText =  "Skip", secondText =  "Continue")
        }
    }
}