package com.example.instagram.models

data class Post(
    val username: String,
    val profileImage: Int,
    val postImageList: List<Int>,
    val description: String,
    val likes: Int,
    val comments: Int,
    val postDate: String
)
