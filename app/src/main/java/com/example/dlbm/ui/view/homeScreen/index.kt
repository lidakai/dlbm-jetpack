package com.example.dlbm.ui.view.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.dlbm.config.Screen

@Composable
fun HomeScreen(navController: NavHostController) {

     Column {
                                Text("Home Screen")
                                Button(onClick = {
                                    navController.navigate(Screen.Details.createRoute(42))
                                }) {
                                    Text("Go to Details")
                                }
                            }

}