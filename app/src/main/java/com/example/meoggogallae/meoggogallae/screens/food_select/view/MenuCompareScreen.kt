package com.example.meoggogallae.meoggogallae.screens.food_select.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.R
import com.example.meoggogallae.meoggogallae.screens.util.ChatBubble
import com.example.meoggogallae.ui.theme.Background200

@Composable
fun MenuCompareScreen(
    leftMenu: String = "분식세트",
    rightMenu: String = "짜장면",
    lectureNumber: String = "27강",
    dateInfo: String = "27/6",
    mainImageRes: Int = R.drawable.img_happy, // 실제 음식 이미지 리소스
    characterRes: Int = R.drawable.img_hunger // 캐릭터 이미지 리소스
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background200) // 연한 베이지 톤
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            // 상단 내비게이션 바
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* TODO: 뒤로가기 */ },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "뒤로가기",
                        tint = Color.Black,
                        modifier = Modifier
                                .rotate(180f)
                    )
                }
                Text(
                    text = lectureNumber,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = dateInfo,
                    fontSize = 14.sp,
                    color = Color(0xFFBDBDBD)
                )
            }

            // 메인 이미지
            Image(
                painter = painterResource(id = mainImageRes),
                contentDescription = "급식 메뉴 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.3f)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 메뉴 비교 텍스트
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = leftMenu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_confrontation),
                    contentDescription = "대결 이미지",
                    modifier = Modifier
                        .size(40.dp)
                )
                Text(
                    text = rightMenu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = mainImageRes),
                contentDescription = "급식 메뉴 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.3f)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(vertical = 8.dp)

            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // 하단 캐릭터 & 대화풍선
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = characterRes),
                contentDescription = "캐릭터",
                modifier = Modifier
                    .width(180.dp)
                    .height(160.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                ChatBubble(
                    text = "난 $leftMenu 이 좋은데..",
                    modifier = Modifier.align(Alignment.Start)
                )
                ChatBubble(
                    text = "넌 어떤게 좋아?",
                    modifier = Modifier.align(Alignment.End)
                )
            }

        }
    }
}


@Preview
@Composable
fun PreMwnuCompareScreen(){
    MenuCompareScreen()
}
