package com.jetpack.pizzaovenjetpackcompose.presentation.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jetpack.pizzaovenjetpackcompose.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaSection(
    breadRadius: Dp,
    modifier: Modifier = Modifier
) {
    val imagesList = listOf(
        R.drawable.bread_1,
        R.drawable.bread_2,
        R.drawable.bread_3,
        R.drawable.bread_4,
        R.drawable.bread_5,
    )
    val pagerState = rememberPagerState(pageCount = { imagesList.size })

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                //   .size(220.dp, 200.dp)
                .size(320.dp),
            painter = painterResource(id = R.drawable.plate),
            contentDescription = "Weather Icon",
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .size(breadRadius)


        ) { page ->
            Image(
                painter = painterResource(id = imagesList[page]),
                contentDescription = "Pizza Item",
                modifier = Modifier
                    //.fillMaxWidth()
                    .clip(CircleShape)
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PizzaSectionPreview() {
    PizzaSection(breadRadius = 200.dp)
}