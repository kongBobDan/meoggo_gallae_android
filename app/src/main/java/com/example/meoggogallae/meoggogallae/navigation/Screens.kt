package com.nohjason.minari.navigation

object Screens {
    val Login = Screen("Login")
    val Welcom = Screen("Welcom")
    val Welcom_2 = Screen("Welcom2")
    val Welcom2_2 = Screen("Welcom")
    val Welcom2 = Screen("Welcom2")
    val End = Screen("End")
    val Menu = Screen("Menu")
    val Result = Screen("Result")
    val Home = Screen("Home")
    val Select = Screen("Select")
}

data class Screen(val route: String)
