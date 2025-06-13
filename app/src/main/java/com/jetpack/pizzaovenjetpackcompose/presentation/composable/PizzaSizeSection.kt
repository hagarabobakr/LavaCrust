package com.jetpack.pizzaovenjetpackcompose.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
private fun PizzaSizeItem(
    onBoxSizeClick: () -> Unit,
    itemText: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Box {
        Box(
            modifier = Modifier
                .size(55.dp)
                .then(
                    if (isSelected) Modifier.shadow(14.dp, CircleShape) else Modifier
                )
                .clip(CircleShape)
                .background(Color.White)


        )
        Box(
            modifier = modifier
                .clip(CircleShape)
                .size(55.dp)
                // .background(color = Color.Yellow)
                .clickable { onBoxSizeClick() }
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = itemText,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black

            )
        }
    }

}

@Composable
fun PizzaSizesRow(
    onSizeSelected: (String) -> Unit,
    selectedSize: String,
    modifier: Modifier = Modifier
) {
    Box {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            listOf("S", "M", "L").forEach { size ->
                PizzaSizeItem(
                    onBoxSizeClick = { onSizeSelected(size) },
                    itemText = size,
                    isSelected = selectedSize == size
                )
                if (size != "L") Spacer(modifier = Modifier.width(12.dp))
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PizzaSizeItemPreview() {

    PizzaSizesRow(
        selectedSize = "M",
        onSizeSelected = {}
    )
}