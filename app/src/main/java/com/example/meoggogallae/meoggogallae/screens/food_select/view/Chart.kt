package com.example.meoggogallae.meoggogallae.screens.food_select.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.ui.theme.Primary400

@Composable
fun ChartBar(
    value: Int,
    label: String,
    maxHeight: Dp,
    barColor: Color = Color(0xFFE9E8D6), // 연한 베이지
    textColor: Color = Color(0xFF222222), // 진한 회색
    labelColor: Color = Color(0xFF888888) // 연한 회색
) {
    val heightFraction = (value / 100f).coerceIn(0f, 1f)
    val barHeight = maxHeight * heightFraction

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .width(44.dp)
                .height(barHeight)
                .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                .background(barColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${value}%",
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = labelColor,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun WinRateChartWithDivider(
    winRate: Int,
    championshipRate: Int
) {
    val maxHeight = 110.dp

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .height(maxHeight + 36.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        ChartBar(
            value = winRate,
            label = "승률",
            maxHeight = maxHeight,
            barColor = Primary400,
        )
        ChartBar(
            value = championshipRate,
            label = "우승비율",
            maxHeight = maxHeight,
            barColor = Primary400,
        )
    }
}


