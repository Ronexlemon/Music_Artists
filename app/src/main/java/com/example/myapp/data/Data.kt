package com.example.myapp.data

import java.io.Serializable

data class Data(
    val id: Int,
    val title: String,
    val sex: String,
    val song:String,
    val age: Int,
    val description: String,
    val puppyImageId: Int = 0
):Serializable