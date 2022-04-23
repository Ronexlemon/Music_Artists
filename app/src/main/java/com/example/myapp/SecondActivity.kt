package com.example.myapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.data.Data
import com.example.myapp.ui.theme.MyAppTheme

class SecondActivity : ComponentActivity() {
    private val musician:Data by lazy{
        intent?.getSerializableExtra(Musician_id) as Data
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Text(text="Hello ${musician.title}")
                    ProfileScreen(data = musician)
                }
            }

        }
    }
    companion object{
        private const val Musician_id="musician_id"
        fun newIntent(context: Context, musician:Data)= Intent(context,SecondActivity::class.java).apply{
            putExtra(Musician_id,musician)

        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyAppTheme {
        Greeting2("Android")
    }
}


