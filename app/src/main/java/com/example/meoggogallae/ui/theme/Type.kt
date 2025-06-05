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
//val inter_bold = FontFamily(Font(R.font.inter_bold))
//val inter_semibold = FontFamily(Font(R.font.inter_semibold))

// Set of Material typography styles to start with
val Typography = Typography(


    // Title
    titleLarge = TextStyle( // Title 1 Bold
        fontFamily = pretendard_bold,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    titleMedium = TextStyle( // Title 2 Bold
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleSmall = TextStyle( // Title 3 Bold
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),

    // Body
    bodyLarge = TextStyle( // Large Body Copy Bold
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    bodyMedium = TextStyle( // Body Bold
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp
    ),
    bodySmall = TextStyle( // Callout Bold
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    // Caption
    labelLarge = TextStyle( // Caption 1 Bold
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle( // Caption 2 Bold
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp
    ),
    labelSmall = TextStyle( // Footnote Bold
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp
    ),

    // Buttons
    headlineSmall = TextStyle( // Button / Small Text
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    headlineMedium = TextStyle( // Button / Text
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    headlineLarge = TextStyle( // Button / Icon
        fontWeight = FontWeight.Medium,
        fontSize = 23.sp
    )
)