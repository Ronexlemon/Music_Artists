package com.example.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.data.Data

@Composable
fun ProfileScreen(data: Data){
    Column(modifier= Modifier
        .background(color = MaterialTheme.colors.primary)
        .verticalScroll(
            rememberScrollState()
        )){
        Column{
            Image(painter = painterResource(id = data.puppyImageId),
                contentDescription = null,
                modifier= Modifier
                    .fillMaxWidth()
                    ,contentScale = ContentScale.Crop)}
            DataDetail(data = data)
        }

    }

@Composable
fun DataDetail(data:Data){
    Column{
        Text(text="Name : ${data.title}",modifier=Modifier.padding(16.dp),style= TextStyle(color= Color.Black,fontWeight = FontWeight.Bold,fontSize =30.sp))
        Text(text="Description : ${data.description}",modifier=Modifier.padding(16.dp),style= TextStyle(color= Color.Black,fontWeight = FontWeight.Light,fontSize =16.sp))
        Text(text="Sex : ${data.sex}",modifier=Modifier.padding(16.dp),style= TextStyle(color= Color.Black,fontWeight = FontWeight.Light,fontSize =16.sp))
        Text(text="Age : ${data.age}",modifier=Modifier.padding(16.dp),style= TextStyle(color= Color.Black,fontWeight = FontWeight.Light,fontSize =16.sp))
        Text(text="Songs : ${data.song}",modifier=Modifier.padding(16.dp),style= TextStyle(color= Color.Black,fontWeight = FontWeight.Light,fontSize =16.sp))// Text(text="Name : ${data.id}")
    }
}
