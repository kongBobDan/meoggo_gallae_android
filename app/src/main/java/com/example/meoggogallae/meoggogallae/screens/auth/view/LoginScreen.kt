package com.example.meoggogallae.meoggogallae.screens.auth.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.meoggogallae.screens.util.DarkButton
import com.example.meoggogallae.ui.theme.Typography
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.time.format.TextStyle

@Composable
fun LoginScreen(
    onComplete: (grade: String, classNum: String, studentNum: String) -> Unit = { _, _, _ -> }
) {
    val grades = (1..3).map { it.toString() }
    val classes = (1..4).map { it.toString() }
    val numbers = (1..20).map { it.toString() }

    val gradeState = rememberPickerState()
    val classState = rememberPickerState()
    val numberState = rememberPickerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCF7))
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "안녕!\n네가 누군지를 알려 줘!",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF232323),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PickerWithLabel(
                items = grades,
                label = "학년",
                state = gradeState,
                visibleItemsCount = 3,
                selectedColor = Color(0xFF6C6046),
                unselectedColor = Color(0xFFD6D2C7),
                modifier = Modifier.width(70.dp)
            )
            PickerWithLabel(
                items = classes,
                label = "반",
                state = classState,
                visibleItemsCount = 3,
                selectedColor = Color(0xFF6C6046),
                unselectedColor = Color(0xFFD6D2C7),
                modifier = Modifier.width(70.dp)
            )
            PickerWithLabel(
                items = numbers,
                label = "번",
                state = numberState,
                visibleItemsCount = 3,
                selectedColor = Color(0xFF6C6046),
                unselectedColor = Color(0xFFD6D2C7),
                modifier = Modifier.width(70.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // ★ 반드시 Column 블록 안에 위치!

        DarkButton(
            text = "입력완료",
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }

}


@Composable
fun PickerWithLabel(
    items: List<String>,
    label: String,
    state: PickerState = rememberPickerState(),
    visibleItemsCount: Int = 3,
    selectedColor: Color = Color.Black,
    unselectedColor: Color = Color(0xFFD6D2C7),
    modifier: Modifier = Modifier
) {
    val visibleItemsMiddle = visibleItemsCount / 2
    val listScrollCount = Integer.MAX_VALUE
    val listScrollMiddle = listScrollCount / 2
    val listStartIndex =
        listScrollMiddle - listScrollMiddle % items.size - visibleItemsMiddle

    fun getItem(index: Int) = items[index % items.size]

    val listState = rememberLazyListState(initialFirstVisibleItemIndex = listStartIndex)
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

    val itemHeightPixels = remember { mutableIntStateOf(0) }
    val itemHeightDp = pixelsToDp(itemHeightPixels.value)

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .map { index -> getItem(index + visibleItemsMiddle) }
            .distinctUntilChanged()
            .collect { item -> state.selectedItem = item }
    }

    val lineColor = Color(0xFFCFCFCF).copy(alpha = 0.8f) // 살짝 투명도 주기

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .width(56.dp)
                .height(itemHeightDp * visibleItemsCount)
        ) {
            LazyColumn(
                state = listState,
                flingBehavior = flingBehavior,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                items(listScrollCount) { index ->
                    val isSelected = (index == listState.firstVisibleItemIndex + visibleItemsMiddle)
                    Text(
                        text = getItem(index),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = if (isSelected) selectedColor else unselectedColor,
                        modifier = Modifier
                            .onSizeChanged { size -> itemHeightPixels.value = size.height }
                            .alpha(if (isSelected) 1f else 0.5f)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp), // 간격 늘림
                        textAlign = TextAlign.Center
                    )
                }
            }

            // 중앙 기준 Divider 2줄 그리기 (짧게)
            if (itemHeightDp > 0.dp) {
                Divider(
                    color = lineColor,
                    thickness = 1.dp,
                    modifier = Modifier
                        .offset(y = itemHeightDp * visibleItemsMiddle)
                        .padding(horizontal = 12.dp) // 양옆 padding 추가 (짧은 선 효과)
                        .fillMaxWidth()
                        .align(Alignment.TopStart)
                )
                Divider(
                    color = lineColor,
                    thickness = 1.dp,
                    modifier = Modifier
                        .offset(y = itemHeightDp * (visibleItemsMiddle + 1))
                        .padding(horizontal = 12.dp) // 동일하게 적용
                        .fillMaxWidth()
                        .align(Alignment.TopStart)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // 오른쪽 단위 텍스트 (세로 중앙 정렬)
        Text(
            text = label,
            color = Color(0xFF6C6046),
            style = Typography.headlineLarge
        )
    }
}







@Composable
private fun pixelsToDp(pixels: Int) = with(LocalDensity.current) { pixels.toDp() }

@Composable
private fun rememberPickerState() = remember { PickerState() }

class PickerState {
    var selectedItem by mutableStateOf("")
}




@Preview
@Composable
fun PreLogin(){
    LoginScreen()
}