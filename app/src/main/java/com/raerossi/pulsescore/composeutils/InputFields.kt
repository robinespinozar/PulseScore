package com.raerossi.pulsescore.composeutils

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.description
import com.raerossi.pulsescore.ui.theme.md_light_description
import com.raerossi.pulsescore.ui.theme.md_theme_light_outlineVariant
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_40
import com.raerossi.pulsescore.ui.theme.md_theme_ref_neutralVariant_95
import com.raerossi.pulsescore.ui.theme.md_theme_ref_primary50
import com.raerossi.pulsescore.ui.theme.neutralVariant40
import com.raerossi.pulsescore.ui.theme.neutralVariant95
import com.raerossi.pulsescore.ui.theme.primary50
import com.raerossi.pulsescore.utils.InputFieldColors


@Composable
fun InputField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textLabel: String,
    textPlaceHolder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    inputFieldColors: InputFieldColors,
) {
    var isFocused by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = modifier
            .getTextFieldModifiers(
                isFocused = isFocused,
                isEmpty = !text.isNotEmpty(),
                focusedIndicatorColor = inputFieldColors.focusedIndicatorColor,
                unfocusedBorderColor = inputFieldColors.unfocusedBorderColor
            )
            .onFocusChanged { focusState -> isFocused = focusState.isFocused },
        value = text,
        onValueChange = { newText -> onTextChanged(newText) },
        enabled = true,
        singleLine = true,
        maxLines = 1,
        keyboardOptions = keyboardOptions,
        cursorBrush = SolidColor(inputFieldColors.cursorColor),
        textStyle = MaterialTheme.typography.bodySmall,
        interactionSource = interactionSource
    ) {
        ConfigureTextFieldValues(
            interactionSource = interactionSource,
            text = text,
            textLabel = textLabel,
            textPlaceHolder = textPlaceHolder,
            isFocused = isFocused,
            innerTextField = it,
            inputFieldColors = inputFieldColors
        )
    }
}

@Composable
fun TextLabel(textLabel: String,textPlaceHolder: String,isEmpty: Boolean, isFocused: Boolean) {
    Text(
        text = if (isFocused || !isEmpty) textLabel else textPlaceHolder,
        style = if (isFocused) MaterialTheme.typography.labelSmall else MaterialTheme.typography.bodySmall
    )
}

@Composable
fun TextPlaceHolder(textPlaceholder: String) {
    Text(
        text = textPlaceholder,
        style = MaterialTheme.typography.bodySmall
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigureTextFieldValues(
    interactionSource: MutableInteractionSource,
    text: String,
    textLabel: String,
    textPlaceHolder: String,
    isFocused: Boolean,
    innerTextField: @Composable () -> Unit,
    inputFieldColors: InputFieldColors
) = TextFieldDefaults.TextFieldDecorationBox(
    value = text,
    innerTextField = innerTextField,
    singleLine = true,
    enabled = true,
    visualTransformation = VisualTransformation.None,
    label = { TextLabel(textLabel, textPlaceHolder,!text.isNotEmpty(),isFocused) },
    placeholder = { TextPlaceHolder(textPlaceHolder) },
    interactionSource = interactionSource,
    contentPadding = TextFieldDefaults.textFieldWithLabelPadding(top = 22.dp),
    colors = getTextFieldColors(!text.isNotEmpty(), inputFieldColors),
    shape = getTextFieldShape()
)

fun Modifier.customFocusedIndicator(
    isFocused: Boolean,
    indicatorColor: Color
): Modifier {
    val cornerRadius = 12.dp

    return then(
        background(
            color = if (isFocused) indicatorColor else Color.Transparent,
            shape = RoundedCornerShape(0.dp, 0.dp, cornerRadius, cornerRadius)
        )
    )
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.getTextFieldModifiers(
    isFocused: Boolean,
    isEmpty: Boolean,
    focusedIndicatorColor: Color,
    unfocusedBorderColor: Color
): Modifier {
    return then(
        fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .customFocusedIndicator(isFocused, focusedIndicatorColor)
            .border(
                width = if (isEmpty) 1.dp else 0.dp,
                color = if (isFocused || !isEmpty) Color.Transparent else unfocusedBorderColor,
                shape = RoundedCornerShape(12.dp)
            )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getTextFieldColors(
    isEmpty: Boolean,
    inputFieldColors: InputFieldColors
) =
    TextFieldDefaults.textFieldColors(
        textColor = inputFieldColors.contentColor,
        containerColor = inputFieldColors.containerColor,
        focusedIndicatorColor = inputFieldColors.focusedIndicatorColor,
        unfocusedIndicatorColor = inputFieldColors.unfocusedIndicatorColor,
        focusedLabelColor = inputFieldColors.focusedLabelColor,
        unfocusedLabelColor = if (isEmpty) inputFieldColors.unfocusedEmptyLabelColor else inputFieldColors.unfocusedLabelColor,
        placeholderColor = inputFieldColors.placeholderColor
    )

fun getTextFieldShape() = RoundedCornerShape(
    topStart = 0.0.dp,
    topEnd = 0.0.dp,
    bottomEnd = 16.0.dp,
    bottomStart = 16.0.dp
)

@Preview(showBackground = true)
@Composable
fun TextFieldPreviews() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            InputField(
                text = "",
                onTextChanged = { /*TODO*/ },
                textLabel = "Nombre",
                textPlaceHolder = "Ingrese su nombre",
                inputFieldColors = InputFieldColors(
                    cursorColor = MaterialTheme.colorScheme.primary50,
                    contentColor = MaterialTheme.colorScheme.description,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
                    containerColor = MaterialTheme.colorScheme.neutralVariant95,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary50,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colorScheme.primary50,
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary50,
                    unfocusedEmptyLabelColor = MaterialTheme.colorScheme.neutralVariant40,
                    placeholderColor = MaterialTheme.colorScheme.neutralVariant40
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputField(
                text = "Robin Espinoza Rossi",
                onTextChanged = { /*TODO*/ },
                textLabel = "Nombre",
                textPlaceHolder = "Ingrese su nombre",
                inputFieldColors = InputFieldColors(
                    cursorColor = MaterialTheme.colorScheme.primary50,
                    contentColor = MaterialTheme.colorScheme.description,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
                    containerColor = MaterialTheme.colorScheme.neutralVariant95,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary50,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colorScheme.primary50,
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary50,
                    unfocusedEmptyLabelColor = MaterialTheme.colorScheme.neutralVariant40,
                    placeholderColor = MaterialTheme.colorScheme.neutralVariant40
                )
            )
        }
    }
}