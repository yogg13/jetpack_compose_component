package com.example.composecomponent

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecomponent.navigationitems.Home
import com.example.composecomponent.navigationitems.Profile
import com.example.composecomponent.navigationitems.Screens
import com.example.composecomponent.navigationitems.Settings
import com.example.composecomponent.ui.theme.GreenJC
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationDrawer(modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet{
                Box(
                    modifier = Modifier
                        .background(GreenJC)
                        .fillMaxWidth()
                        .height(64.dp)
                ){
                    IconButton(
                        onClick = {
                            coroutineScope.launch {drawerState.close()} },
                        modifier = Modifier.fillMaxHeight().align(Alignment.CenterStart)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = "Menu Button",
                            tint = Color.White,
                        )
                    }
                }
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {Text(text = "Home", color = GreenJC)},
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home icon", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen){
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {Text(text = "Profile", color = GreenJC)},
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "profile icon", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {Text(text = "Settings", color = GreenJC)},
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "settings icon", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen){
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {Text(text = "Logout", color = GreenJC)},
                    selected = false,
                    icon = { Icon(imageVector = Icons.AutoMirrored.Default.ExitToApp, contentDescription = "settings icon", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "Android") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenJC,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu Button")
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen
            ) {
               composable(Screens.Home.screen){ Home() }
               composable(Screens.Profile.screen){ Profile() }
               composable(Screens.Settings.screen){ Settings() }
            }
        }
    }
}