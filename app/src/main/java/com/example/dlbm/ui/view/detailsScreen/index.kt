package com.example.dlbm.ui.view.detailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(navController: NavHostController, id: Int) {
    Column {
        Text(" Details Screen")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Details Screen$id")
        }
    }
}