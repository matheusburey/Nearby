package com.matheus.nearby.ui.screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.matheus.nearby.R
import com.matheus.nearby.ui.theme.GreenLight

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(GreenLight)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id= R.drawable.img_logo_logo_logo_text),
            contentDescription = "logo"
        )

        Image(
            modifier = Modifier.align(Alignment.BottomCenter),
            painter = painterResource(id= R.drawable.bg_splash_screen),
            contentDescription = "background image"
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}