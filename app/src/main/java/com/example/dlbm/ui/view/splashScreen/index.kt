package com.example.dlbm.ui.view.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.dlbm.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier , navController: NavHostController? = null) {


    val context = LocalContext.current

    LaunchedEffect(true) {
        delay(2000) // 延迟 2 秒
        navController?.popBackStack()
        navController?.navigate("home") // 导航到主页面
    }


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White), // 设置背景颜色
        contentAlignment = Alignment.Center // 内容居中对齐
    ) {
        // 在这里添加你的启动页 UI 元素,比如 Logo、加载动画等
        Image(
            painter = painterResource(id = R.drawable.launch_background),
            contentDescription = "launch_background"
        )
    }
}