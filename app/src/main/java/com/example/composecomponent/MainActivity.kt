package com.example.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponent.ui.theme.ComposeComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeComponentTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
//                    TopAppBarComponent(modifier = Modifier.padding(innerPadding))
//                    NavigationDrawer(modifier = Modifier.padding(innerPadding))
                    /*FlowRow {
                        ImageCard(
                            model = R.drawable.android_studio,
                            contentDescription = "Image Icon Android Studio",
                            title = "Android Studio",
                            modifier = Modifier.padding(innerPadding)
                        )
                        ImageCard(
                            model = R.drawable.ninja_working_computer_cartoon,
                            contentDescription = "Image Ninja Working Computer Cartoon",
                            title = "Ninja Computer",
                            modifier = Modifier.padding(innerPadding)
                        )
                        ImageCard(
                            model = R.drawable.kotlin,
                            contentDescription = "Image Icon Kotlin",
                            title = "Kotlin",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }*/
                    ShowSnackbars(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeComponentTheme {
//        TopAppBarComponent()
//        NavigationDrawer()
//        ImageCard(
//            model = R.drawable.ninja_working_computer_cartoon,
//            contentDescription = "Image Ninja Working Computer Cartoon",
//            title = "Ninja Computer",
//        )
    }
}