package com.matheus.nearby.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.matheus.nearby.R
import com.matheus.nearby.data.model.Market
import com.matheus.nearby.data.model.mock.mockCategories
import com.matheus.nearby.data.model.mock.mockMarkets
import com.matheus.nearby.data.model.mock.mockUserLocation
import com.matheus.nearby.ui.components.category.NearbyCategoryFilterChipList
import com.matheus.nearby.ui.components.market.NearbyMarketCardList
import com.matheus.nearby.ui.theme.Gray100
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    markets: List<Market>,
    onNavigateTo: (Market) -> Unit
) {
    val bottomSheetState = rememberBottomSheetScaffoldState()
    var isBottomSheetOpened by remember { mutableStateOf(true) }

    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val density = LocalDensity.current

    if (isBottomSheetOpened) {
        BottomSheetScaffold(
            modifier = modifier,
            scaffoldState = bottomSheetState,
            sheetContentColor = Gray100,
            sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                NearbyMarketCardList(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    markets = markets,
                    onMarketClick = { selectedMarket -> onNavigateTo(selectedMarket) }
                )
            },
            content = {
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(mockUserLocation, 13f)
                }
                val uiSetting by remember {
                    mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            bottom = it
                                .calculateBottomPadding()
                                .minus(8.dp)
                        )
                ) {
                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState,
                        uiSettings = uiSetting
                    ) {
                        context.getDrawable(R.drawable.ic_user_location)?.let {
                            Marker(
                                state = MarkerState(position = mockUserLocation),
                                icon = BitmapDescriptorFactory.fromBitmap(
                                    it.toBitmap(
                                        width = density.run { 72.dp.toPx() }.roundToInt(),
                                        height = density.run { 72.dp.toPx() }.roundToInt()
                                    )
                                )
                            )
                        }

                        if (markets.isNotEmpty()) {
                            context.getDrawable(R.drawable.img_pin)?.let {
                                markets.forEach { market ->
                                    Marker(
                                        state = MarkerState(
                                            position = LatLng(
                                                market.latitude,
                                                market.longitude
                                            )
                                        ),
                                        icon = BitmapDescriptorFactory.fromBitmap(
                                            it.toBitmap(
                                                width = density.run { 36.dp.toPx() }.roundToInt(),
                                                height = density.run { 36.dp.toPx() }.roundToInt()
                                            )
                                        ),
                                        title = market.name
                                    )
                                }
                            }
                        }
                    }
                    NearbyCategoryFilterChipList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .align(Alignment.TopStart),
                        categories = mockCategories,
                        onSelectedCategoryChange = {}
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(markets = mockMarkets, onNavigateTo = {})
}