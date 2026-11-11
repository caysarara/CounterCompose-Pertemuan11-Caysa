package com.example.countercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.countercompose.ui.theme.CounterComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

private const val SCREEN_COUNTER = "counter"
private const val SCREEN_DATA_DIRI = "data_diri"

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    var currentScreen by rememberSaveable { mutableStateOf(SCREEN_COUNTER) }

    when (currentScreen) {
        SCREEN_COUNTER -> CounterApp(
            onNext = { currentScreen = SCREEN_DATA_DIRI },
            modifier = modifier
        )

        SCREEN_DATA_DIRI -> {
            BackHandler { currentScreen = SCREEN_COUNTER }
            DataDiriApp(
                onBack = { currentScreen = SCREEN_COUNTER },
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CounterScreenView() {
    CounterComposeTheme {
        CounterScreen(
            counter = 7,
            onIncrement = {},
            onDecrement = {},
            onReset = {},
            onNext = {}
        )
    }
}

