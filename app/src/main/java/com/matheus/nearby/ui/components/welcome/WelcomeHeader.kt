package com.matheus.nearby.ui.components.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheus.nearby.R
import com.matheus.nearby.ui.theme.Typography

@Composable
fun WelcomeHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo_logo_icon),
            contentDescription = "icon"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Welcome Nearby", style = Typography.headlineLarge)
        Text(
            text = "Get coupons to use at your favorite establishments",
            style = Typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun WelcomeHeaderPreview() {
    WelcomeHeader()
}