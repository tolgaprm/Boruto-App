package com.prmto.borutoapp.presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) { paddingValues ->
        Text(text = "asd", modifier = Modifier.padding(paddingValues))
    }
}
