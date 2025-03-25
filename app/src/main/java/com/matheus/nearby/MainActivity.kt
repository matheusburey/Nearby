package com.matheus.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.matheus.nearby.data.model.Market
import com.matheus.nearby.data.model.mock.mockMarkets
import com.matheus.nearby.ui.screen.Home
import com.matheus.nearby.ui.screen.HomeScreen
import com.matheus.nearby.ui.screen.MarketDetailsScreen
import com.matheus.nearby.ui.screen.Splash
import com.matheus.nearby.ui.screen.SplashScreen
import com.matheus.nearby.ui.screen.Welcome
import com.matheus.nearby.ui.screen.WelcomeScreen
import com.matheus.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(onNavigateTo = { navController.navigate(Welcome) })
                    }

                    composable<Welcome> { WelcomeScreen(onNavigateTo = { navController.navigate(Home) }) }

                    composable<Home> { HomeScreen(onNavigateTo = { navController.navigate(it) }) }

                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()
                        MarketDetailsScreen(market = selectedMarket)
                    }
                }
            }
        }
    }
}