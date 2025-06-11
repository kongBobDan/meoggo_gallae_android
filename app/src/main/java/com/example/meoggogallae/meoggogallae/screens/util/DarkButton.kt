package com.example.meoggogallae.meoggogallae.screens.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meoggogallae.ui.theme.PointBrown
import com.example.meoggogallae.ui.theme.Typography

@Composable
fun DarkButton(
    text: String = "Button",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PointBrown,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 15.dp),
        modifier = modifier
            .defaultMinSize(minHeight = 40.dp)
    ) {
        Text(
            text = text,
            style = Typography.labelMedium
        )
    }
}


@Preview
@Composable
fun PreDarkButton(){
    DarkButton(
        text = "Label",
        onClick = {}
    )
}
