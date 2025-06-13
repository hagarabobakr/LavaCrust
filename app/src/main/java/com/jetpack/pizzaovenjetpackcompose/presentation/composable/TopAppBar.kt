package com.jetpack.pizzaovenjetpackcompose.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.jetpack.pizzaovenjetpackcompose.R
import com.jetpack.pizzaovenjetpackcompose.ui.theme.Black

@Composable
fun TopAppBar(){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
            contentDescription = "location",
            modifier = Modifier
        )
        Text(
            text = "Pizza" ,
            color = Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.heart_icon),
            contentDescription = "location",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    TopAppBar()
}