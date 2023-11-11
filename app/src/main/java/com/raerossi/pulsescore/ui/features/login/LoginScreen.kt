package com.raerossi.pulsescore.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.raerossi.pulsescore.R
import com.raerossi.pulsescore.composeutils.IconAndTextButton
import com.raerossi.pulsescore.composeutils.InputField
import com.raerossi.pulsescore.composeutils.LinkButton
import com.raerossi.pulsescore.composeutils.PrimaryButton
import com.raerossi.pulsescore.composeutils.ProgressTopBar
import com.raerossi.pulsescore.composeutils.TitleAndDescription
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.ui.theme.description
import com.raerossi.pulsescore.ui.theme.neutralVariant40
import com.raerossi.pulsescore.ui.theme.neutralVariant95
import com.raerossi.pulsescore.ui.theme.primary50
import com.raerossi.pulsescore.utils.InputFieldColors

/*TODO: Implementar el método LoginScreen(viewModel: ViewModel){LoginScreen()} el
*  cual deribará en el la vista como ejemplo ver la app de google sunflower-main
*  la GalleryScreen */

/*TODO: Meter el TopBar en un Scaffold y el resto en el Content ver GalleryScreen o HomeScreen */

/*TODO: Agregar Scroll para que funcione en devices con pantalla pequeña */

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(Modifier.fillMaxSize()) {
        LoginHeader(Modifier.align(Alignment.TopCenter))
        LoginBody(Modifier.align(Alignment.Center))
        LoginFooter(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun LoginHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ProgressTopBar()
        Spacer(modifier = Modifier.height(16.dp))
        TitleAndDescription(
            title = "Login",
            description = "Por favor, a continuación ingresa tu correo y contraseña para acceder."
        )
    }
}

@Composable
fun LoginBody(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Email(email = email) {
            email = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        Password(password = password) {
            password = it
        }
        Spacer(modifier = Modifier.height(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(text = "Sign up") {}
        Spacer(modifier = Modifier.height(32.dp))
        LoginDivider()
        Spacer(modifier = Modifier.height(16.dp))
        IconAndTextButton(
            icon = R.drawable.ic_google,
            textPrefix = "Continue with",
            textSuffix = "Google"
        ) {
        }
    }
}


@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary50,
        modifier = modifier
    )
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginFooter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 16.dp)) {
        LinkButton(
            textDescription = "Don´t have an account",
            textAction = "Sign Up"
        ) {
            /*TODO*/
        }
    }
}

@Composable
fun Email(
    email: String,
    onTextChanged: (String) -> Unit
) {
    CustomInputField(
        text = email,
        onTextChanged = { newText -> onTextChanged(newText) },
        textLabel = "Email",
        textPlaceHolder = "Enter your email",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun Password(
    password: String,
    onTextChanged: (String) -> Unit
) {
    CustomInputField(
        text = password,
        onTextChanged = { newText -> onTextChanged(newText) },
        textLabel = "Password",
        textPlaceHolder = "Enter your password",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun CustomInputField(
    text: String,
    onTextChanged: (String) -> Unit,
    textLabel: String,
    textPlaceHolder: String,
    keyboardOptions: KeyboardOptions
) {
    InputField(
        text = text,
        onTextChanged = { newText -> onTextChanged(newText) },
        textLabel = textLabel,
        textPlaceHolder = textPlaceHolder,
        keyboardOptions = keyboardOptions,
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

@Preview(showBackground = true)
@Composable
fun LoginScreenPreviews() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            val navigationController = rememberNavController()
            LoginScreen(navigationController)
        }
    }
}

