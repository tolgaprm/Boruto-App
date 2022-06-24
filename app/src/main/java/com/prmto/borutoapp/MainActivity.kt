package com.prmto.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prmto.borutoapp.ui.theme.BorutoAppTheme
import com.prmto.borutoapp.navigation.setupNavhGraph

class MainActivity : ComponentActivity() {
    
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                navController = rememberNavController()
                setupNavhGraph(navController = navController)
            }
        }
    }
}
