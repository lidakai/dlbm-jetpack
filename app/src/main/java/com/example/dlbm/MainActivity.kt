package com.example.dlbm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dlbm.ui.theme.DlbmTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dlbm.config.NavigationGraph
import com.example.dlbm.config.Screen
import com.example.dlbm.ui.components.NavigationBarItem
import com.example.dlbm.ui.components.SootheBottomNavigation

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           val navController: NavHostController = rememberNavController()
            DlbmTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationVisibility(navController) { showBottomBar,router ->
                                if (showBottomBar) {
                                    SootheBottomNavigation(
                                        selectedItem = router,
                                        navController = navController,
                                        items = listOf(
                                            NavigationBarItem(
                                                route = Screen.Home.route,
                                                icon = Icons.Default.Home,
                                                title = stringResource(R.string.bottom_navigation_home)
                                            ),
                                            NavigationBarItem(
                                                route = Screen.Toolbox.route,
                                                icon = Icons.Default.Face,
                                                title = stringResource(R.string.bottom_navigation_toolbox)
                                            ),
                                            NavigationBarItem(
                                                route = Screen.Shopping.route,
                                                icon = Icons.Default.ShoppingCart,
                                                title = stringResource(R.string.bottom_navigation_price)
                                            ), NavigationBarItem(
                                                route = Screen.User.route,
                                                icon = Icons.Default.Person,
                                                title = stringResource(R.string.bottom_navigation_user)
                                            )
                                        )
                                    )
                                }
                            }
                        }
                    ) {
                        NavigationGraph(navController)
                    }

                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun AnimatedGif() {
    Image(
        painter = painterResource(R.drawable.profile_picture),
        contentDescription = "Contact profile picture",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
    )
}

@Composable
fun MessageCard(msg: Message) {
    Row {
        AnimatedGif()
        Spacer(modifier = Modifier.width(18.dp))
        Column {
            Text(
                text = msg.author,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = msg.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }

}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
    )
}


// 检查是否应显示底部导航栏
@Composable
private fun BottomNavigationVisibility(
    navController: NavHostController,
    content: @Composable (Boolean,String?) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
     val router =  navBackStackEntry?.destination?.route
    val showBottomBar = router == Screen.Home.route || router == Screen.Toolbox.route || router == Screen.User.route || router == Screen.Shopping.route

    content(showBottomBar,router)
}