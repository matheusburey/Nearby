package com.matheus.nearby.data.model.mock

import com.matheus.nearby.data.model.Market
import com.matheus.nearby.data.model.Rule


val mockMarkets = listOf(
    Market(
        id = "012576ea-4441-4b8a-89e5-d5f32104c7c4",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Flame & Feast",
        description = "Steakhouse with premium cuts and a diverse buffet. A complete experience for meat lovers..",
        coupons = 10,
        rules = listOf(
            Rule(
                id = "1",
                description = "Available until 12/31",
                marketId = "012576ea-4441-4b8a-89e5-d5f32104c7c4"
            ),
            Rule(
                id = "2",
                description = "Valid for dine-in only",
                marketId = "012576ea-4441-4b8a-89e5-d5f32104c7c4"
            )
        ),
        latitude = -23.55974230991911,
        longitude = -46.65814845249887,
        address = "Av. Paulista - Bela Vista",
        phone = "(11) 94567-1212",
        cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    ),
    Market(
        id = "2bc11e34-5f30-4ba0-90fa-c1c98f649281",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Central Brew",
        description = "Cozy café with a variety of snacks and handcrafted drinks. Perfect for a break.",
        coupons = 10,
        rules = emptyList(),
        latitude = -23.559457108504436,
        longitude = -46.66252581753144,
        address = "Alameda Jaú - Jardim Paulista",
        phone = "(12) 3456-7890",
        cover = "https://images.unsplash.com/photo-1551218808-94e220e084d2?w=400&h=300"
    )
)