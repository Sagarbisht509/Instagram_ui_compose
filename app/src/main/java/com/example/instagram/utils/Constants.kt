package com.example.instagram.utils

import com.example.instagram.R
import com.example.instagram.models.Post
import com.example.instagram.models.Story

fun getStories(): List<Story> = listOf(
    Story(username = "Tobi", profileImage = R.drawable.tobi),
    Story(username = "izUku", profileImage = R.drawable.izuku),
    Story(username = "tanjiro", profileImage = R.drawable.tanjiro),
    Story(username = "asta", profileImage = R.drawable.asta),
    Story(username = "Uchiha", profileImage = R.drawable.uchiha),
    Story(username = "denji", profileImage = R.drawable.chainsaw1),
    Story(username = "asta", profileImage = R.drawable.asta)
)

fun getPosts(): List<Post> = listOf(

    Post(
        username = "Kakashi_007",
        profileImage = R.drawable.kakashi1,
        postImageList = listOf(R.drawable.kakashi2, R.drawable.kakashi1, R.drawable.kakashi3),
        description = "Kakashi The Copy Ninja.",
        comments = 21,
        likes = 22,
        postDate = "12 July"
    ),
    Post(
        username = "Denji",
        profileImage = R.drawable.chainsaw2,
        postImageList = listOf(R.drawable.chainsaw1, R.drawable.chainsaw2),
        description = "A soul with a devil's heart.",
        comments = 14,
        likes = 34,
        postDate = "21 July"
    )
)