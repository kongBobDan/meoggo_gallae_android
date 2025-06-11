package com.example.meoggogallae.meoggogallae.screens.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.ui.theme.Background100
import com.example.meoggogallae.ui.theme.Gray600
import com.example.meoggogallae.ui.theme.PointGray

@Composable
fun MeoggoGallaeInput(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    label: String = "Label",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                color = Background100,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(
                color = if (value.isEmpty()) Gray600 else PointGray,
                fontSize = 16.sp
            ),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = label,
                        color = Gray600,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreInput(){
    MeoggoGallaeInput(
//        value =
    )
}
