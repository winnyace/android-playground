package com.example.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    val systemBars = WindowInsets.systemBars

    Column(modifier = Modifier.fillMaxSize().then(modifier)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InsertAvatar()
            Text(
                text = "Hello, world! I'm winny!",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
        }
        Row(
            modifier = Modifier
                .padding(systemBars.asPaddingValues())
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Email:",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = "winnyace@proton.me",
                fontSize = 24.sp
            )
        }
    }
}

@Composable
fun InsertAvatar(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.pfp)
    Box(
        modifier = Modifier
            .size(250.dp)
            .then(modifier)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
    }
}