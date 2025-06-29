package com.example.meoggogallae.meoggogallae.screens.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meoggogallae.R
import com.example.meoggogallae.meoggogallae.screens.util.DarkButton
import com.example.meoggogallae.meoggogallae.screens.util.WhiteButton
import com.nohjason.minari.navigation.Screen
import com.nohjason.minari.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    navController: NavController,
    text: String,
) {
    val isSpecialText = text == "난 DG고새라고해!\n앞으로 잘부탁해."

    // isSpecialText가 false일 때 3초 후에 화면 이동
    if (!isSpecialText) {
        LaunchedEffect(Unit) {
            delay(3000)  // 3초 대기
            navController.navigate(route = Screens.Welcom_2.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 중앙 상단 텍스트
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }

        // 이미지
        Image(
            painter = painterResource(
                id = if (isSpecialText) R.drawable.img_happy else R.drawable.img_happy
            ),
            contentDescription = "캐릭터 이미지",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
        )

        // 버튼 박스를 하단 중앙에 고정
        if (isSpecialText) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 40.dp)
                    .padding(bottom = 48.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    DarkButton(
                        text = "잘 부탁해!",
                        onClick = {

                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    WhiteButton(
                        text = "뭐야 이 징그러운건;",
                        onClick = { navController.navigate(route = Screens.Welcom2.route) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}





//@Preview
//@Composable
//fun PreWelcomeScreen(){
//    WelcomeScreen(
//        text = "난 DG고새라고해!\n앞으로 잘부탁해."
//    )
//}
