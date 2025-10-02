package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableIntStateOf(1) }
    var necessarySqueezes by remember { mutableIntStateOf((2..4).random()) }

    when (currentStep) {
        1 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(215.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.Yellow.copy(alpha = 0.3f))
                        .clickable {
                            currentStep = 2
                        }
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.collect_lemon))
            }
        }

        2 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(215.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.Yellow.copy(alpha = 0.3f))
                        .clickable {
                            if (necessarySqueezes == 0) {
                                currentStep = 3
                            } else {
                                necessarySqueezes--
                            }
                        }
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.squeeze_lemon))
            }
        }

        3 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(215.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.Yellow.copy(alpha = 0.3f))
                        .clickable {
                            currentStep = 4
                        }
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.glass_lemonade),
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.drink_lemon))
            }
        }

        4 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(215.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(Color.Yellow.copy(alpha = 0.3f))
                        .clickable {
                            necessarySqueezes = (2..4).random()
                            currentStep = 1
                        }
                ) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass),
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.start_over))
            }
        }
    }
}