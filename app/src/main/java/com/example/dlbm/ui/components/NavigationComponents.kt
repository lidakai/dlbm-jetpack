package com.example.dlbm.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dlbm.config.Screen


data class NavigationBarItem(
    val route: String,
    val icon: ImageVector,
    val title: String
)


@Composable
fun SootheBottomNavigation(
    navController: NavHostController,
    selectedItem: String?,
    items: List<NavigationBarItem>
) {
    NavigationBar(
        modifier = Modifier.height(56.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEach { item ->
                val selected =
                    if (selectedItem == null) item.route == Screen.Home.route else item.route == selectedItem
                NavigationItem(
                    icon = item.icon,
                    selected = selected,
                    route = item.route,
                    label = item.title,
                    navController = navController,
                )
            }
        }

    }
}


@Composable
fun NavigationItem(
    icon: ImageVector,
    label: String,
    route: String,
    selected: Boolean,
    navController: NavController,
) {

    val onClick = {
        if (!selected) {
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    }

    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .height(56.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!selected) {
            UnselectedContent(icon = icon, label = label)
        } else {
            SelectedContent(icon = icon, label = label)
        }
    }
}

@Composable
fun UnselectedContent(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null)
        Text(text = label)
    }
}

@Composable
fun SelectedContent(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = Color.Blue)
        Text(text = label, color = Color.Blue)
    }
}

