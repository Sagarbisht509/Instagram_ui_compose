package com.example.instagram.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.instagram.R
import com.example.instagram.models.Post
import com.example.instagram.models.Story
import com.example.instagram.utils.getPosts
import com.example.instagram.utils.getStories
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

        ToolBar()
        Story(storyList = getStories())
        Divider(
            Modifier
                .fillMaxWidth()
                .height(2.dp)
                .padding(vertical = 6.dp)
        )
        PostSection(postList = getPosts())
    }
}

@Composable
fun ToolBar() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = "Instagram title",
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .align(Alignment.TopStart)
        )

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "Add post",
                modifier = Modifier.size(26.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Add post",
                modifier = Modifier.size(26.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Icon(
                painter = painterResource(id = R.drawable.messenger),
                contentDescription = "Add post",
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
fun Story(storyList: List<Story>) {

    LazyRow {
        items(storyList) { story ->
            StoryItem(story = story, modifier = Modifier)
        }
    }
}

@Composable
fun StoryItem(story: Story, modifier: Modifier) {

    Column(modifier = modifier.padding(5.dp)) {
        Image(
            painter = painterResource(id = story.profileImage),
            contentDescription = "Story profile",
            modifier = Modifier
                .size(60.dp)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        listOf(
                            Color("#C13584".toColorInt()),
                            Color("#FD1D1D".toColorInt())
                        )
                    ),
                    shape = CircleShape
                )
                .padding(4.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = story.username,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.width(60.dp)
        )
    }
}

@Composable
fun PostSection(postList: List<Post>) {
    LazyColumn {
        items(postList) { post ->
            PostItem(post = post)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostItem(post: Post, modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState()

    Column(modifier = modifier.fillMaxWidth()) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = post.profileImage),
                    contentDescription = "user profile image",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(7.dp))

                Text(
                    text = post.username,
                    fontSize = 12.sp,
                    modifier = Modifier.width(100.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.option),
                contentDescription = "more",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd)
            )
        }

        PostCarousel(post.postImageList, pagerState)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Like post",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment in post",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Icon(
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = "Share post",
                    modifier = Modifier.size(24.dp)
                )
            }

            if (pagerState.pageCount != 1) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier.align(Alignment.Center),
                    activeColor = Color("#3205FF".toColorInt()),
                    inactiveColor = Color("#C4C4C4".toColorInt())
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.save),
                contentDescription = "Save post",
                modifier = Modifier
                    .size(24.dp)
                    .align(
                        Alignment.CenterEnd
                    )
            )
        }

        Text(
            text = "${post.likes} likes",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 10.dp)
        )

        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            ) {
                append("${post.username} ")
            }
            append(post.description)
        }

        Text(
            text = annotatedString,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.padding(start = 10.dp, top = 7.dp)
        )

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostCarousel(postImageList: List<Int>, pagerState: PagerState) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            count = postImageList.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { index ->
            Image(
                painter = painterResource(id = postImageList[index]),
                contentDescription = "post image",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(375.dp),
                contentScale = ContentScale.Crop
            )
        }

        if (pagerState.pageCount != 1) {
            NudgeView(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 10.dp, end = 10.dp)
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NudgeView(pagerState: PagerState, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.Black.copy(0.4f))
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Row {
            Text(text = "${pagerState.currentPage + 1}", color = Color.White)
            Text(text = "/", color = Color.White)
            Text(text = "${pagerState.pageCount}", color = Color.White)
        }
    }

}
