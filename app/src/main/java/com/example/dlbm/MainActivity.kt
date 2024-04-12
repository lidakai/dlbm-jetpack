package com.example.dlbm

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dlbm.config.NavigationGraph

class MainActivity : ComponentActivity() {

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
                    NavigationGraph(navController)
//                    MessageCard(Message("Android", "Jetpack Compose"))
//                    Scaffold(
//                        bottomBar = {
//                            SootheBottomNavigation(
//                                selectedItem = "home",
//                                navController = NavHostController,
//                                items = listOf(
//                                    NavigationBarItem(
//                                        route = "home",
//                                        icon = Icons.Default.Home,
//                                        title = stringResource(R.string.bottom_navigation_home)
//                                    ),
//                                    NavigationBarItem(
//                                        route = "toolbox",
//                                        icon = Icons.Default.Face,
//                                        title = stringResource(R.string.bottom_navigation_toolbox)
//                                    ),
//                                    NavigationBarItem(
//                                        route = "price",
//                                        icon = Icons.Default.ShoppingCart,
//                                        title = stringResource(R.string.bottom_navigation_price)
//                                    ), NavigationBarItem(
//                                        route = "user",
//                                        icon = Icons.Default.Person,
//                                        title = stringResource(R.string.bottom_navigation_user)
//                                    )
//                                )
//                            )
//                        },
//                    )(

//                    )
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
        // Add a horizontal space between the image and the column
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

