package com.example.meoggogallae.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.meoggogallae.R

val pretendard_medium = FontFamily(Font(R.font.pretendard_medium))
val pretendard_regular = FontFamily(Font(R.font.pretendard_regular))
val pretendard_bold = FontFamily(Font(R.font.pretendard_bold))
val pretendard_semibold = FontFamily(Font(R.font.pretendard_semibold))

val Typography = Typography(
    bodyLarge = TextStyle( // Body / Default
        fontFamily = pretendard_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp
    ),
    bodyMedium = TextStyle( // Body / Bold
        fontFamily = pretendard_semibold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp
    ),
    displayLarge = TextStyle( // Title 1 / Default
        fontFamily = pretendard_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    displayMedium = TextStyle( // Title 1 / Bold
        fontFamily = pretendard_bold,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    headlineLarge = TextStyle( // Large Body Copy / Default
        fontFamily = pretendard_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    headlineMedium = TextStyle( // Large Body Copy / Bold
        fontFamily = pretendard_semibold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    titleLarge = TextStyle( // Title 2 / Default
        fontFamily = pretendard_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle( // Title 2 / Bold
        fontFamily = pretendard_bold,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleSmall = TextStyle( // Title 3 / Default
        fontFamily = pretendard_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    labelLarge = TextStyle( // Title 3 / Bold
        fontFamily = pretendard_semibold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    labelMedium = TextStyle( // Button / Text
        fontFamily = pretendard_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle( // Button / Small Text or Overline 역할
        fontFamily = pretendard_medium,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle( // Callout / Default or Caption 역할
        fontFamily = pretendard_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
)

// Non-standard styles (Caption1, Caption2, Footnote)는 별도로 정의하면 됩니다:

val Caption1_Default = TextStyle(
    fontFamily = pretendard_regular,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)

val Caption1_Bold = TextStyle(
    fontFamily = pretendard_semibold,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp
)

val Caption2_Default = TextStyle(
    fontFamily = pretendard_regular,
    fontWeight = FontWeight.Normal,
    fontSize = 11.sp
)

val Caption2_Bold = TextStyle(
    fontFamily = pretendard_medium,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp
)

val Footnote_Default = TextStyle(
    fontFamily = pretendard_regular,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp
)

val Footnote_Bold = TextStyle(
    fontFamily = pretendard_semibold,
    fontWeight = FontWeight.SemiBold,
    fontSize = 13.sp
)

