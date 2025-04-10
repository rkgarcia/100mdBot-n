package com.garcialuis.roberto.ohmdbtn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.garcialuis.roberto.ohmdbtn.ui.theme.Botón100MinerosDijeronTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Botón100MinerosDijeronTheme {
                GameTable()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    Botón100MinerosDijeronTheme {
        GameTable()
    }
}

@Composable
fun GameTable() {
    var buttonAColor by remember { mutableStateOf(Color.Green) }
    var buttonBColor by remember { mutableStateOf(Color.Red) }
    var resetTrigger by remember { mutableIntStateOf(0) }
    var buttonsEnabled by remember { mutableStateOf(true) }

    LaunchedEffect(resetTrigger) {
        if (resetTrigger > 0) {
            buttonsEnabled = false
            delay(5000)
            buttonAColor = Color.Green
            buttonBColor = Color.Red
            buttonsEnabled = true
        }
    }

    Column (
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Button(// GreenButton
            onClick = {
                buttonBColor = Color.Green
                resetTrigger++
            },
            enabled = buttonsEnabled,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors().copy(containerColor = buttonAColor, disabledContainerColor = buttonAColor),
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {}
        Button(// Red button
            onClick = {
                buttonAColor = Color.Red
                resetTrigger++
            },
            enabled = buttonsEnabled,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors().copy(containerColor = buttonBColor, disabledContainerColor = buttonBColor),
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {}
    }
}
