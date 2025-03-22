package com.matheus.nearby.ui.components.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheus.nearby.R
import com.matheus.nearby.ui.theme.Gray500
import com.matheus.nearby.ui.theme.RedBase
import com.matheus.nearby.ui.theme.Typography

@Composable
fun WelcomeHowItWorksTip(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    @DrawableRes iconRes: Int
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = iconRes),
            tint = RedBase,
            contentDescription = "icon"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = title, style = Typography.headlineSmall)
            Text(text = description, style = Typography.bodyLarge, color = Gray500)
        }
    }
}

@Preview
@Composable
private fun WelcomeHowItWorksTipPreview() {
    WelcomeHowItWorksTip(title = "hello", description = "description", iconRes = R.drawable.ic_map_pin)
}