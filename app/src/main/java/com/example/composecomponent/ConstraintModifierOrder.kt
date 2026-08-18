package com.example.composecomponent

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ConstraintModifierOrder(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.width(300.dp).height(300.dp).border(width = 4.dp, color = Color.DarkGray)
    ){
        //Ukuran akhir yang dikembalikan dari child ke parent tetap 100.dp x 100.dp,
        // karena padding tidak menambah ukurang total, melainkan padding hanya memakan ruang isi di dalam (content)
        Box(
            modifier = Modifier
                .background(Color.Green)
                .size(100.dp)
                .background(Color.Black)
                .padding(16.dp) //ukuran ini bertindak sebagai padding(inner) untuk content-nya
                .background(Color.Blue)//Akan menimpa & menggunakan ukuran 200.dp - 32.dp = 168.dp
                .border(width = 2.dp, color = Color.White)
        ){
            //Maka content akan mengisi ruang sebesar 100.dp - (16.dp x 2) = 68.dp
            Text("Box One", color = Color.White)
        }
        Spacer(Modifier.height(20.dp))
        //Ukuran akhir yang dikembalikan dari child ke parent menjadi 100.dp + (16.dp x 2)
        // = 132.dp x 132.dp untuk total ukurannya)
        Box(
            modifier = Modifier
                .background(Color.Green)
                .padding(16.dp)//ukuran ini bertindak sebagai padding(outer)/margin diluar constraint
                .size(100.dp)
                .background(Color.Red)
                .border(width = 2.dp, color = Color.Black)
        ){
            //Maka content akan tetap mengisi ruang sebesar 100.dp
            Text("Box Two", color = Color.White)
        }
    }
}