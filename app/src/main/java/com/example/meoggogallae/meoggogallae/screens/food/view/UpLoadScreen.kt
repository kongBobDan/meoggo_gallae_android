package com.example.meoggogallae.meoggogallae.screens.food.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meoggogallae.R
import com.example.meoggogallae.meoggogallae.screens.auth.view.PickerState
import com.example.meoggogallae.meoggogallae.screens.auth.view.PickerWithLabel
import com.example.meoggogallae.meoggogallae.screens.util.DarkButton
import com.example.meoggogallae.ui.theme.Background800

@Composable
fun UpLoadScreen(){
    val years = (2000..2026).map { it.toString() }
    val months = (1..12).map { it.toString() }
    val days = (1..31).map { it.toString() }

    val yearsState = rememberPickerState()
    val monthState = rememberPickerState()
    val dayState = rememberPickerState()


    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
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

        Image(
            painter = painterResource(id = R.drawable.img_test_food),
            contentDescription = "급식 이미지",
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PickerWithLabel(
                items = years,
                label = "년",
                state = yearsState,
                visibleItemsCount = 3,
                selectedColor = Color(0xFF6C6046),
                unselectedColor = Color(0xFFD6D2C7),
                modifier = Modifier.width(70.dp)
            )

            PickerWithLabel(
                items = months,
                label = "월",
                state = monthState,
                visibleItemsCount = 3,
                selectedColor = Color(0xFF6C6046),
                unselectedColor = Color(0xFFD6D2C7),
                modifier = Modifier.width(70.dp)
            )

            PickerWithLabel(
                items = days,
                label = "일",
                state = dayState,
                visibleItemsCount = 3,
                selectedColor = Color(0xFF6C6046),
                unselectedColor = Color(0xFFD6D2C7),
                modifier = Modifier.width(70.dp)
            )
        }

        DarkButton(
            text = "작성 완료"
        )
    }
}

@Composable
private fun rememberPickerState() = remember { PickerState() }

@Preview
@Composable
fun PreUpLoadScreen(){
    UpLoadScreen()
}