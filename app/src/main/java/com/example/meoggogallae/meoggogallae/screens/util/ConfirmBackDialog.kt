package com.example.meoggogallae.meoggogallae.screens.util

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmBackDialog(
    onYesClick: () -> Unit,
    onNoClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(24.dp)
            .background(color = Color(0xFFFAFAF2), shape = RoundedCornerShape(16.dp)) // 연한 베이지
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 상단 질문 텍스트
            Text(
                text = "정말 돌아가시겠습니까?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 서브 설명 텍스트
            Text(
                text = "돌아가시면 되돌아가지 못합니다.",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF999999)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Divider(color = Color(0xFFE0E0CC), thickness = 1.dp)

            // 버튼 영역
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                // "네" 버튼
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onYesClick() }
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "네", fontSize = 16.sp, color = Color.Black)
                }

                // 버튼 구분선
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(Color(0xFFE0E0CC))
                )

                // "아니요" 버튼
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onNoClick() }
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "아니요", fontSize = 16.sp, color = Color.Black)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreConfirmBackDialog(){
    ConfirmBackDialog(
        onNoClick = {},
        onYesClick = {}
    )
}
