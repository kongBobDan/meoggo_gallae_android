package com.example.meoggogallae.meoggogallae.screens.food_select.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.R
import com.example.meoggogallae.meoggogallae.screens.util.DarkButton
import com.example.meoggogallae.meoggogallae.screens.util.MeoggoGallaeDropdown
import com.example.meoggogallae.ui.theme.Background200
import com.example.meoggogallae.ui.theme.Background800
import com.example.meoggogallae.ui.theme.Typography

@Composable
fun SelectMainScreen() {
    // 더미 메뉴 리스트
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background200)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp) // 좌우 여백
        ) {
            // (1) 상단 뒤로가기 아이콘
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

            // (2) 제목 텍스트
            Text(
                text = "최고의 급식 메뉴를\n뽑아주세요!",
                style = Typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 32.dp),
                textAlign = TextAlign.Center
            )

            // (3) 이미지
            Image(
                painter = painterResource(id = R.drawable.img_noodle),
                contentDescription = "음식 이미지",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f)
                    .align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(32.dp))

            // (4) 드롭다운
            MeoggoGallaeDropdown(
                label = "메뉴를 선택하세요",
                items = listOf("김치볶음밥", "돈까스", "된장찌개"),
                selectedIndex = 0,
                onItemSelected = { /* ... */ },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f)) // 남은 공간을 밀어내서 버튼을 하단에 배치
        }

        // (5) 하단 버튼 - 화면 하단에 고정
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 32.dp, start = 32.dp, end = 32.dp)
        ) {
            DarkButton(
                text = "시작하기",
                onClick = { /* TODO: 다음 화면 이동 등 액션 */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreSelectMainScreen(){
    SelectMainScreen()
}