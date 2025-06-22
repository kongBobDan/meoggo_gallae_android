package com.example.meoggogallae.meoggogallae.screens.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.meoggogallae.R
import com.example.meoggogallae.meoggogallae.screens.util.DarkButton
import com.example.meoggogallae.meoggogallae.screens.util.WhiteButton
import com.example.meoggogallae.ui.theme.Background100
import com.example.meoggogallae.ui.theme.Typography
import com.nohjason.minari.navigation.Screen
import com.nohjason.minari.navigation.Screens

@Composable
fun EndScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background100)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Column(
            modifier = Modifier.padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "로고",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.img_textlogo),
                contentDescription = "텍스트 로고",
                modifier = Modifier
                    .fillMaxWidth(0.4f)   // 너비를 크게
                    .aspectRatio(3.5f)    // 원본 비율에 맞게 (필요시 조정)
            )
        }

        Text(
            text = "에 오신 것을 환영합니다!",
            style = Typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
        ) {
            DarkButton(
                text = "바로 시작하기",
                onClick = {
                    navController.navigate(route = Screens.Home.route)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


//@Preview
//@Composable
//fun PreEndScreen(){
//    EndScreen()
//}