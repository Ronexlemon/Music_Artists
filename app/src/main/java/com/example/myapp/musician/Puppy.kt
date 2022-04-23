package com.example.myapp.musician

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.MusicianObject
import com.example.myapp.data.Data


@Composable
fun MyApp(profileActivity: (Data) -> Unit){
    Scaffold(content = {
        MusicianApp(profileActivity)
    })


}

@Composable
fun MusicianApp(profileActivity: (Data) -> Unit) {
    val musician = remember{ MusicianObject.list}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp,vertical = 16.dp)){
        items(
            items=musician,
            itemContent = {list->
                MusicianList(list=list,profileActivity )
            }
        )
    }
}

@Composable
fun MusicianList(list: Data,profileActivity:(Data)->Unit) {
    Card(elevation = 15.dp,shape= RoundedCornerShape(15.dp),modifier= Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp).background(color=MaterialTheme.colors.secondaryVariant)){
        Row(modifier=Modifier.background(color = Color(0xE6E6FA)).clickable{profileActivity(list)}){
            Row(modifier = Modifier){
                Image(painter = painterResource(id = list.puppyImageId),
                    contentDescription = null,
                    modifier=Modifier.clip(
                        CircleShape).size(100.dp),contentScale = ContentScale.Crop)}
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)
                .fillMaxWidth()){

                Text(text=list.title,style= MaterialTheme.typography.h6)
                Text(text=list.description,style= MaterialTheme.typography.caption)


            }

        }
    }


}


/*@Preview(showBackground = true)
@Composable
fun DefaultFun(){
    MyApp(profileActivity:(Data)->Unit)
}*/