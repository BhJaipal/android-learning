package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.Purple40
import com.example.test.ui.theme.Purple80
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    GreetingPreview()
                    Counter()
                    BottomAppBar(
                        Modifier.absolutePadding(0.dp, 650.dp, 0.dp, 0.dp),
                        content = {
                            Row {
                                ElevatedButton(
                                    onClick = { println("Android Icon clicked") },
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(80.dp)
                                        .padding(0.dp)
                                    ,
                                    colors = buttonColors(
                                        Purple40,
                                        Color.Green,
                                        Color.Gray,
                                        Color.DarkGray
                                    ),
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_launcher_foreground),
                                        "Icon",
                                        tint = Color.Green,
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(200.dp)
                                    )
                                }
                                Text(
                                    "First App",
                                    Modifier,
                                    color = Color.White,
                                    fontSize = 50.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        },
                        windowInsets = WindowInsets(0, 0, 0, 0),
                        containerColor = Purple80
                    )
                }
            }
        }
    }
}

@Composable
fun Counter() {
    val clicks = remember {
        mutableIntStateOf(0)
    }

    Column (modifier = Modifier.absolutePadding(80.dp, 100.dp, 50.dp, 50.dp)) {
        Button(
            onClick = {
                clicks.intValue++
                println(clicks.intValue) },
            colors = buttonColors(
                Color.Red,
                Color.White,
                Color.Gray,
                Color.DarkGray
            ),
            modifier = Modifier
                .width(100.dp)
                .height(70.dp)
                .absolutePadding( 0.dp, 5.dp, 0.dp, 0.dp),
            shape =  RoundedCornerShape(0.dp)
        ) {
            Text("+", fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold)
        }
        Button(
            onClick = {  },
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            colors = buttonColors(
                Purple40,
                Purple80,
                Color.Gray,
                Color.DarkGray
            ),
            shape =  RoundedCornerShape(0.dp)
        ) {
            Text(clicks.intValue.toString(), fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold)
        }
        Button(
            onClick = {
                clicks.intValue--
                println(clicks.intValue)
            },
            colors = buttonColors(
                Color.Red,
                Color.White,
                Color.Gray,
                Color.DarkGray
            ),
            modifier = Modifier
                .width(100.dp)
                .height(70.dp)
                .absolutePadding( 0.dp, 0.dp, 0.dp, 5.dp),
            shape =  RoundedCornerShape(0.dp)
        ) {
            Text(
                "-",
                fontSize = 40.sp,
                modifier = Modifier.absolutePadding( 0.dp, 0.dp, 0.dp, 15.dp),
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Surface(color = Color.Transparent) {
            Greeting("Android")
        }
    }
}