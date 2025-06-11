package com.example.meoggogallae.meoggogallae.screens.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.R
import com.example.meoggogallae.ui.theme.Background400
import com.example.meoggogallae.ui.theme.Caption1_Default
import com.example.meoggogallae.ui.theme.PointGray

@Composable
fun ChatBubble(
    text: String,
    modifier: Modifier = Modifier,
    bubbleColor: Color = Background400,
    textColor: Color = PointGray
) {
    Box(
        modifier = modifier
            .padding(bottom = 24.dp) // 꼬리가 잘리지 않도록 아래쪽 여백 추가
    ) {
        // 말풍선 본체
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(bubbleColor)
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = text,
                color = textColor,
                style = Caption1_Default
            )
        }

        // 꼬리 이미지: 왼쪽 하단, 아래로 0~20dp만큼 offset
        Image(
            painter = painterResource(id = R.drawable.ic_chat_tail),
            contentDescription = "말풍선 꼬리",
            modifier = Modifier
                .width(12.dp)
                .height(24.dp)
                .align(Alignment.BottomStart)
                .offset(x = 5.dp, y = 10.dp) // y를 0~20dp로 조정하며 위치 튜닝
        )
    }
}



@Preview
@Composable
fun PreChatBubble(){
    ChatBubble(text = "넌 어떤게 좋아? dkkkdkdkdk")
}