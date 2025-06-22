package com.example.meoggogallae.meoggogallae.screens.food.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meoggogallae.R
import com.example.meoggogallae.ui.theme.Background800

@Composable
fun StarComponent(){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* TODO: 네비게이션 뒤로가기 이벤트 연결 */ },
            modifier = Modifier.size(36.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "뒤로가기",
                tint = Background800,
                modifier = Modifier.rotate(180f)
            )
        }
    }

    Row {
        Text(
            text = "별점 남기기"
        )

        Row {
//            IconButton() { }
        }
    }
}

@Preview
@Composable
fun PreStarComponent(){
    StarComponent()
}