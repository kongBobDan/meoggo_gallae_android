package com.example.meoggogallae.meoggogallae.screens.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.meoggogallae.ui.theme.PointGray
import com.example.meoggogallae.ui.theme.Typography

@Composable
fun CameraButton(
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = PointGray)
            .padding(horizontal = 16.dp, vertical = 25.dp)
            .clickable { onClick },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = "아이콘 체크박스",
            tint = Color.Unspecified // 이렇게만 써야 원본 색상 유지
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "오늘의 잔반량 체크하러 가기",
            style = Typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = "아이콘 화살표",
            tint = Color.Unspecified // 이렇게만 써야 원본 색상 유지
        )
    }
}

@Preview
@Composable
fun PreCamareButton(){
    CameraButton()
}
