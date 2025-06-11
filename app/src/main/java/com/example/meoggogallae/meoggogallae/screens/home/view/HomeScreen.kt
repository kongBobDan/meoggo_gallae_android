package com.example.meoggogallae.meoggogallae.screens.home.view

import android.widget.ImageButton
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.R
import com.example.meoggogallae.ui.theme.Background100
import com.example.meoggogallae.ui.theme.Background200
import com.example.meoggogallae.ui.theme.Background400
import com.example.meoggogallae.ui.theme.Background600
import com.example.meoggogallae.ui.theme.Background800
import com.example.meoggogallae.ui.theme.Caption1_Bold
import com.example.meoggogallae.ui.theme.Caption1_Default
import com.example.meoggogallae.ui.theme.Footnote_Bold
import com.example.meoggogallae.ui.theme.PointGray
import com.example.meoggogallae.ui.theme.Primary400
import com.example.meoggogallae.ui.theme.Primary800
import com.example.meoggogallae.ui.theme.Typography

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background200)
            .verticalScroll(rememberScrollState())
    ) {
        Statistics(
            month = 5,
            many = 40,
            middle = 50,
            less = 10
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column (
            modifier = Modifier
                .padding(horizontal = 40.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.img_confrontation),
                contentDescription = "이미지 버튼",
                tint = Color.Unspecified,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.6f)
                    .clickable {  },
            )

            Spacer(modifier = Modifier.height(16.dp))

            CameraButton()

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "아이콘 캘린더",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "오늘 급식",
                    style = Typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Menu(
                    text = "아침",
                    menu = "발아현미밥, 잡채, 배추김치, 해물순두부찌개, 연탄대패불고기, 청포도",
                    icon = R.drawable.ic_sun
                )
                Menu(
                    text = "점심",
                    menu = "발아현미밥, 잡채, 배추김치, 해물순두부찌개, 연탄대패불고기, 청포도",
                    icon = R.drawable.ic_sun_fog
                )
                Menu(
                    text = "저녁",
                    menu = "발아현미밥, 잡채, 배추김치, 해물순두부찌개, 연탄대패불고기, 청포도",
                    icon = R.drawable.ic_moon
                )
            }
        }
    }
}

@Composable
fun Statistics(
    month: Int,
    many: Int,
    middle: Int,
    less: Int
) {
    val backgroundColor = Color(0xFFF7F5ED) // 연한 베이지
    val textColor = Color(0xFF757575)      // 부드러운 회색
    val titleColor = Color(0xFF3E3E3E)     // 제목용 진한 회색
    val chartGreen = Color(0xFF4CAF50)     // 강조 초록
    val chartBg = Color(0xFFECE7D9)        // 차트 배경 베이지

    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomEnd = 24.dp,
            bottomStart = 24.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
//             .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 30.dp, start = 24.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 왼쪽 텍스트 영역
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "${month}월달 잔반량 통계",
                    style = Caption1_Bold,
                    color = PointGray
                )
                StatisticRow(label = "적게 남긴 날", value = "$many%", textColor = textColor)
                StatisticRow(label = "적당히 먹은 날", value = "$middle%", textColor = textColor)
                StatisticRow(label = "많이 남긴 날", value = "$less%", textColor = textColor)
            }

            Spacer(modifier = Modifier.width(50.dp))

            // 오른쪽 도넛 차트
            DonutChart(
                many = many,
                middle = middle,
                less = less,
                modifier = Modifier.size(110.dp)
            )
        }
    }
}

@Composable
fun StatisticRow(label: String, value: String, textColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = Caption1_Default,
            color = Background800
        )
        Text(
            text = value,
            style = Footnote_Bold,
            color = PointGray
        )
    }
}

@Composable
fun DonutChart(
    many: Int,      // 적게 남긴 날
    middle: Int,    // 적당히 먹은 날
    less: Int,      // 많이 남긴 날
    modifier: Modifier = Modifier
) {
    val backgroundColor = Color(0xFFE0E0E0)
    // 각 구간별 색상
    val colorMany = Primary400      // 적게 남긴 날
    val colorMiddle = Background600 // 적당히 먹은 날
    val colorLess = Background400   // 많이 남긴 날

    // 중앙 텍스트: 가장 큰 값 표시
    val maxValue = maxOf(many, middle, less)
    val centerText = when (maxValue) {
        many -> "$many%"
        middle -> "$middle%"
        else -> "$less%"
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val strokeWidth = size.width * 0.18f
            val radius = size.minDimension / 2 - strokeWidth / 2

            // 배경 원
            drawArc(
                color = backgroundColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            )

            // 누적 각도 계산
            var startAngle = -90f

            // 적게 남긴 날
            val sweepMany = 360f * (many / 100f)
            drawArc(
                color = colorMany,
                startAngle = startAngle,
                sweepAngle = sweepMany,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            )
            startAngle += sweepMany

            // 적당히 먹은 날
            val sweepMiddle = 360f * (middle / 100f)
            drawArc(
                color = colorMiddle,
                startAngle = startAngle,
                sweepAngle = sweepMiddle,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            )
            startAngle += sweepMiddle

            // 많이 남긴 날
            val sweepLess = 360f * (less / 100f)
            drawArc(
                color = colorLess,
                startAngle = startAngle,
                sweepAngle = sweepLess,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            )
        }
        // 중앙 텍스트 (Primary400, headlineMedium)
        Text(
            text = centerText,
            color = Primary400,
            style = Typography.headlineMedium // 또는 Typo.headlineMedium
        )
    }
}






@Preview
@Composable
fun PreHomewScreen(){
    HomeScreen()
}