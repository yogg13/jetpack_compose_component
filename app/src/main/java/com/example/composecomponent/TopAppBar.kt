package com.example.composecomponent

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.composecomponent.ui.theme.GreenJC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = {
            Text(
                text = "Android",
            )

        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Android App",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Android Icon",
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Profile Component",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile",
                    tint = Color.White
                )

            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Search Component",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.SearchOff,
                    contentDescription = "Search",
                    tint = Color.White
                )

            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Menu Component",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menu",
                    tint = Color.White
                )

            }
        }
    )
}

