package com.example.meoggogallae.meoggogallae.screens.food_select.view

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meoggogallae.R
import com.example.meoggogallae.ui.theme.Background800

@Composable
fun SelectResultScreen(
    navController: NavController,
    onBack: () -> Unit = {},
    mainMenu: String = "짜장면",
    winRate: Int = 99,
    championshipRate: Int = 23,
    resultList: List<Pair<String, Pair<Int, Int>>> = listOf(
        "짜장면" to (99 to 23),
        "볶음면" to (99 to 23),
        "볶음면" to (99 to 23)
    )
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F3))
            .verticalScroll(rememberScrollState())
    ) {
        // 상단 뒤로가기
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "뒤로가기",
                    tint = Color(0xFF222222),
                    modifier = Modifier.rotate(180f)
                )
            }
        }

        // 타이틀
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "나의 원픽 급식메뉴",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF222222)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "\"$mainMenu\"",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                color = Color(0xFF222222)
            )
        }

        // 대표 이미지
        Image(
            painter = painterResource(id = R.drawable.img_test_food),
            contentDescription = "$mainMenu 이미지",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally)
        )

        // 설명 텍스트
        Text(
            text = "급식 메뉴들 중에서 " +
                    "${buildAnnotatedString { withStyle(SpanStyle(color = Color(0xFF1BA464), fontWeight = FontWeight.Bold)) { append("$winRate%") } }}" +
                    " 정도의 승률과 " +
                    "${buildAnnotatedString { withStyle(SpanStyle(color = Color(0xFF1BA464), fontWeight = FontWeight.Bold)) { append("$championshipRate%") } }}" +
                    "의 우승비율을 가지고 있어요.",
            fontSize = 16.sp,
            color = Color(0xFF444444),
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        // 승률/우승비율 그래프
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            WinRateChartWithDivider(
                winRate = 99,
                championshipRate = 23
            )
        }

        // 리스트 헤더
        Text(
            text = "2위 - 짜장면",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF222222),
            modifier = Modifier
                .padding(start = 24.dp, top = 24.dp, bottom = 8.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            resultList.forEachIndexed { idx, (menu, rates) ->
                ResultCard(
                    rank = idx + 2,
                    menu = menu,
                    imageRes = R.drawable.img_test_food, // 각 메뉴별 이미지 리소스가 있다면 교체
                    winRate = rates.first,
                    championshipRate = rates.second
                )
            }
        }
    }
}



//@Preview
//@Composable
//fun PreSelectResultScreen(){
//    SelectResultScreen()
//}