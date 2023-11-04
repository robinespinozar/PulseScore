package com.raerossi.pulsescore.composeutils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_40
import com.raerossi.pulsescore.ui.theme.md_light_title
import com.raerossi.pulsescore.ui.theme.neutralVariant40
import com.raerossi.pulsescore.ui.theme.title

object Sizes {
    const val sizeBig = 0
    const val sizeMed = 1
}

@Composable
fun TitleAndDescription(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    size: Int = Sizes.sizeBig,
    centerAlign: Boolean = false,
    darkMode: Boolean = false
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        val alignment = if (centerAlign) TextAlign.Center else TextAlign.Left

        TitleText(text = title, alignment = alignment, darkMode = darkMode, size = size)
        Spacer(modifier = getSpacerHeight(size))
        DescriptionText(text = description, alignment = alignment, darkMode = darkMode, size = size)
    }
}

@Composable
fun TitleText(
    text: String,
    alignment: TextAlign,
    darkMode: Boolean,
    size: Int
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        textAlign = alignment,
        color = if (darkMode) Color.White else MaterialTheme.colorScheme.title,
        style = if (size == Sizes.sizeBig) MaterialTheme.typography.displaySmall else MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun DescriptionText(
    text: String,
    alignment: TextAlign,
    darkMode: Boolean,
    size: Int
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        textAlign = alignment,
        color = if (darkMode) Color.White else MaterialTheme.colorScheme.neutralVariant40,
        style = if (size == Sizes.sizeBig) MaterialTheme.typography.bodySmall else MaterialTheme.typography.bodyMedium
    )
}

fun getSpacerHeight(size: Int) = when (size) {
    Sizes.sizeBig -> Modifier.height(4.dp)
    Sizes.sizeMed -> Modifier.height(8.dp)
    else -> Modifier.height(16.dp)
}

@Preview(showBackground = true)
@Composable
fun MyTitlesPreviews() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            TitleAndDescription(
                title = "Confirm your email",
                description = "We just sent you an email to\n" + "office@designmesocial.com"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(Modifier.background(Color.Gray)) {
                TitleAndDescription(
                    title = "Confirm your email",
                    darkMode = true,
                    description = "We just sent you an email to\n" + "office@designmesocial.com"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TitleAndDescription(
                title = "Confirm your email",
                centerAlign = true,
                description = "We just sent you an email to\n" + "office@designmesocial.com"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(Modifier.background(Color.Gray)) {
                TitleAndDescription(
                    title = "Confirm your email",
                    darkMode = true,
                    centerAlign = true,
                    description = "We just sent you an email to\n" + "office@designmesocial.com"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TitleAndDescription(
                title = "Login",
                description = "Enter the email address you’d like to use to sign in to SmartBank.",
                size = Sizes.sizeMed
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(Modifier.background(Color.Gray)) {
                TitleAndDescription(
                    title = "Login",
                    darkMode = true,
                    description = "Enter the email address you’d like to use to sign in to SmartBank.",
                    size = Sizes.sizeMed
                )
            }
        }
    }
}