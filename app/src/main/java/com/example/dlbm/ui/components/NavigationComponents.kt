package com.example.dlbm.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController


data class NavigationBarItem(
    val route: String,
    val icon: ImageVector,
    val title: String
)


@Composable
fun SootheBottomNavigation(
    navController: NavHostController,
    selectedItem: String,
    items: List<NavigationBarItem>
) {
    NavigationBar(
        modifier = Modifier,
    ) {
        items.forEach { item ->
            val selected = selectedItem == item.route
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}



