package com.survivalcoding.gangnam2kiandroidstudy.data.datasource

import com.survivalcoding.gangnam2kiandroidstudy.data.model.Recipe


class MockRecipeDataSourceImpl : RecipeDataSource {
    val recipes = listOf(
        Recipe(
            title = "Traditional spare ribs baked",
            chef = "Chef John",
            time = "20 min",
            rating = 4.0,
            imageUrls = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg"
        ),
        Recipe(
            title = "Spice roasted chicken with flavored rice",
            chef = "Mark Kelvin",
            time = "20 min",
            rating = 4.0,
            imageUrls = "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg"
        ),
        Recipe(
            title = "Spicy fried rice mix chicken bali",
            chef = "Spicy Nelly",
            time = "20 min",
            rating = 4.0,
            imageUrls = "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg"
        ),
        Recipe(
            title = "Ttekbokki",
            chef = "Kim Dahee",
            time = "30 min",
            rating = 5.0,
            imageUrls = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg"
        ),
        Recipe(
            title = "Grilled salmon with avocado salsa",
            chef = "Alice Johnson",
            time = "25 min",
            rating = 4.5,
            imageUrls = "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg"
        ),
        Recipe(
            title = "Beef Wellington",
            chef = "Gordon Ramsay",
            time = "45 min",
            rating = 5.0,
            imageUrls = "https://cdn.pixabay.com/photo/2019/10/22/10/11/beef-wellington-4568239_1280.jpg"
        ),
        Recipe(
            title = "Classic Margherita Pizza",
            chef = "Mario Batali",
            time = "15 min",
            rating = 4.3,
            imageUrls = "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg"
        ),
        Recipe(
            title = "Sushi Platter",
            chef = "Jiro Ono",
            time = "60 min",
            rating = 4.8,
            imageUrls = "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg"
        ),
        Recipe(
            title = "French Onion Soup",
            chef = "Julia Child",
            time = "40 min",
            rating = 4.6,
            imageUrls = "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg"
        ),
        Recipe(
            title = "Chocolate Lava Cake",
            chef = "Paul Hollywood",
            time = "30 min",
            rating = 4.9,
            imageUrls = "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg"
        )
    )

    override suspend fun getRecipes(): List<Recipe> {
        return recipes
    }
}