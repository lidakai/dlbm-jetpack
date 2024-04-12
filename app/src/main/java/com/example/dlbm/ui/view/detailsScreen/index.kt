package com.example.dlbm.ui.view.detailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(id: Int) {
    Column {
        Text(" Details Screen")
        Button(onClick = { }) {
            Text("Details Screen$id")
        }
    }
}