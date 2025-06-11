package com.example.meoggogallae.meoggogallae.screens.util

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.ui.theme.Background300
import com.example.meoggogallae.ui.theme.Background500
import com.example.meoggogallae.ui.theme.Background700
import com.example.meoggogallae.ui.theme.PointBrown

@Composable
fun MeoggoGallaeDropdown(
    label: String = "Menu Label",
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier // modifier 파라미터 추가
) {
    var expanded by remember { mutableStateOf(false) }

    val backgroundColor = Background300 // 연한 베이지
    val selectedItemColor = Background500 // 선택 항목 배경
    val textColor = PointBrown
    val labelColor = Background700
    val cornerRadius = 8.dp

    Column(
        modifier = modifier // 외부 modifier 적용
            .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .border(1.dp, Color.Transparent, shape = RoundedCornerShape(cornerRadius))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        // 상단: 레이블 + 드롭다운 화살표
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = label,
                    color = labelColor,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = labelColor,
                modifier = Modifier.size(24.dp)
            )
        }

        // 드롭다운 메뉴
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedIndex == index
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(index)
                        expanded = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            if (isSelected) selectedItemColor else Color.Transparent,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = item,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = textColor,
                        fontSize = 15.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun PreMeoggoGallaeDropdown() {
    val items = listOf("김치볶음밥", "돈까스", "된장찌개", "불고기", "비빔밥")
    MeoggoGallaeDropdown(
        label = "메뉴를 선택하세요",
        items = items,
        selectedIndex = 2,
        onItemSelected = {}
    )
}
