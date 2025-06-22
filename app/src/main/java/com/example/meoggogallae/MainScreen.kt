package com.example.meoggogallae

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.nohjason.minari.navigation.NavGraph

@Composable
fun MainScreen(
    navController: NavHostController,
) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
    ){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavGraph(navController = navController)
        }
    }
}