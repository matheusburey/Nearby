package com.matheus.nearby.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheus.nearby.ui.components.button.NearbyButton
import com.matheus.nearby.ui.components.welcome.WelcomeContent
import com.matheus.nearby.ui.components.welcome.WelcomeHeader

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, onNavigateTo: () -> Unit) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(horizontal = 40.dp, vertical = 48.dp)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        WelcomeHeader()
        WelcomeContent()
        NearbyButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Start",
            onClick = onNavigateTo
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(onNavigateTo = {})
}