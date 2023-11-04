package com.raerossi.pulsescore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raerossi.pulsescore.composeutils.ProgressTopBar
import com.raerossi.pulsescore.composeutils.TitleAndDescription
import com.raerossi.pulsescore.ui.theme.PulseScoreTheme
import com.raerossi.pulsescore.utils.PreferencePage
import com.raerossi.pulsescore.views.login.LoginBody
import com.raerossi.pulsescore.views.preferences.PreferenceScreen
import com.raerossi.pulsescore.views.preferences.convertTeamToPreference
import com.raerossi.pulsescore.views.preferences.getTeamList

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PulseScoreTheme {
                SetStatusBarColor(Color(0xFFFCFCFC))
                //SetStatusBarColor(Color(0xFF004F4E))
                // A surface container using the 'background' color from the theme
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)

                ) {
                    PreferenceScreen(
                        preferencePage = PreferencePage.Notifications,
                        preferenceList = convertTeamToPreference(list = getTeamList())
                    )
                }
            }
        }
    }
}

@Composable
fun SetStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }
}

@Composable
fun MyProgressBarStatus() {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = progressStatus,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row {
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTest() {
    Scaffold(
        topBar = { ProgressTopBar() }
    ) {
        Column(Modifier.fillMaxSize().padding(it)){
            Spacer(modifier = Modifier.height(16.dp))
            TitleAndDescription(
                title = "Login",
                description = "Por favor, a continuación ingresa tu correo y contraseña para acceder."
            )
            LoginBody()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 800
)
@Composable
fun GreetingPreview() {
    PulseScoreTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            ScaffoldTest()
        }
    }
}
