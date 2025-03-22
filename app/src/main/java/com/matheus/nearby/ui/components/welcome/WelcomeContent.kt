package com.matheus.nearby.ui.components.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheus.nearby.R
import com.matheus.nearby.ui.theme.Typography

@Composable
fun WelcomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = "see how it works:", style = Typography.bodyLarge)
        WelcomeHowItWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Find establishments",
            description = "See places near you that are Nearby partners",
            iconRes = R.drawable.ic_map_pin
        )
        WelcomeHowItWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Activate the coupon with QR Code",
            description = "Scan the code at the establishment to use the benefit",
            iconRes = R.drawable.ic_qrcode
        )
        WelcomeHowItWorksTip(
            modifier = Modifier.fillMaxWidth(),
            title = "Get benefits near you",
            description = "Activate coupons wherever you are, in different types of establishments",
            iconRes = R.drawable.ic_ticket
        )
    }
}

@Preview
@Composable
private fun WelcomeContentPreview() {
    WelcomeContent()
}