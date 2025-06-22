package com.nohjason.minari.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meoggogallae.meoggogallae.screens.auth.view.EndScreen
import com.example.meoggogallae.meoggogallae.screens.auth.view.LoginScreen
import com.example.meoggogallae.meoggogallae.screens.auth.view.WelcomScreen_2
import com.example.meoggogallae.meoggogallae.screens.auth.view.WelcomeScreen
import com.example.meoggogallae.meoggogallae.screens.food_select.view.MenuCompareScreen
import com.example.meoggogallae.meoggogallae.screens.food_select.view.SelectMainScreen
import com.example.meoggogallae.meoggogallae.screens.food_select.view.SelectResultScreen
import com.example.meoggogallae.meoggogallae.screens.home.view.HomeScreen

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun NavGraph(
    navController: NavHostController,
) {
    val text = "난 DG고새라고해!\n앞으로 잘부탁해."
    val text2 = "너무하네.. 정말...\n" +
            "그래도 먹고갈래는 해줄꺼지?"
    val text3 = "반가워!\n" +
            "먹고갈래에 잘 왔어."
    val text4 = "그래!\n" +
            "우리 같이 먹고갈래로 놀자!"

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ) {
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.Welcom.route){
            WelcomeScreen(navController = navController, text=text)
        }
        composable(route = Screens.Welcom2.route){
            WelcomScreen_2(navController = navController, text2)
        }
        composable(route = Screens.Welcom_2.route){
            WelcomeScreen(navController = navController, text=text3)
        }
        composable(route = Screens.Welcom2_2.route){
            WelcomScreen_2(navController = navController, text4)
        }

        composable(route = Screens.End.route){
            EndScreen(navController = navController)
        }

        composable(route = Screens.Menu.route){
           MenuCompareScreen(navController = navController)
        }

        composable(route = Screens.Result.route){
            SelectResultScreen(navController = navController)
        }
        composable(route = Screens.Select.route){
            SelectMainScreen(navController = navController)
        }
    }
}
