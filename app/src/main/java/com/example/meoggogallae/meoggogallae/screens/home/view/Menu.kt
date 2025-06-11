package com.example.meoggogallae.meoggogallae.screens.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meoggogallae.R
import com.example.meoggogallae.ui.theme.Background300
import com.example.meoggogallae.ui.theme.Background400
import com.example.meoggogallae.ui.theme.Caption1_Bold
import com.example.meoggogallae.ui.theme.Caption1_Default

@Composable
fun Menu(
    text: String,
    menu: String,
    icon: Int
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Background300)
            .padding(horizontal = 10.dp, vertical = 30.dp), // 내부 여백
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 아이콘
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "아이콘 설명",
            tint = Background400,
            modifier = Modifier.size(20.dp)
        )

        // 세로 구분선
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(1.dp)
                .height(32.dp)
                .background(color = Background400, shape = RoundedCornerShape(1.dp))
        )

        // 텍스트 영역
        Column(
            modifier = Modifier.weight(1f) // 남은 영역 모두 사용
        ) {
            // 상단 pill 라벨
            Box(
                modifier = Modifier
                    .background(color = Background400, shape = RoundedCornerShape(50))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    text = text,
                    style = Caption1_Bold,
                    color = Color(0xFFBDBDBD)
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            // 메뉴 텍스트
            Text(
                text = menu,
                style = Caption1_Default,
                color = Color(0xFFBDBDBD),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



@Preview
@Composable
fun PreMenu(){
    Menu(
        text = "아침",
        menu = "발아현미밥, 잡채, 배추김치, 해물순두부찌개, 연탄대패불고기, 청포도",
        icon = R.drawable.ic_sun
    )
}