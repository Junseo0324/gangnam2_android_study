package com.survivalcoding.gangnam2kiandroidstudy.presentation.search

import androidx.lifecycle.viewmodel.compose.viewModel
import com.survivalcoding.gangnam2kiandroidstudy.data.model.Recipe
import com.survivalcoding.gangnam2kiandroidstudy.data.repository.RecipeRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class SearchRecipesViewModelTest {

    private val recipeList = listOf(
        Recipe(
            title = "Traditional spare ribs baked",
            chef = "Chef John",
            time = "20 min",
            category = "Chinese",
            rating = 4.0,
            imageUrls = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg"
        ),
        Recipe(
            title = "Spice roasted chicken with flavored rice",
            chef = "Mark Kelvin",
            time = "20 min",
            category = "Chinese",
            rating = 4.0,
            imageUrls = "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg"
        ),
        Recipe(
            title = "Spicy fried rice mix chicken bali",
            chef = "Spicy Nelly",
            time = "20 min",
            category = "Chinese",
            rating = 4.0,
            imageUrls = "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg"
        ),
        Recipe(
            title = "Ttekbokki",
            chef = "Kim Dahee",
            time = "30 min",
            category = "Chinese",
            rating = 5.0,
            imageUrls = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg"
        )
    )
    private val mockRepository = object : RecipeRepository {
        override suspend fun getRecipes(): List<Recipe> {
            return recipeList
        }
    }
    private val viewModel = SearchRecipesViewModel(mockRepository)

    @Test
    fun `viewModel이 데이터를 잘 가져오는지 테스트`() = runTest {
        // When
        viewModel.getAllRecipes()

        // Then
        val recipes = viewModel.state.value.recipes
        assertEquals(4, recipes.size)
        assertEquals(recipeList[0].title, recipes[0].title)
        assertEquals(recipeList[1].title, recipes[1].title)
        assertEquals(recipeList[2].title, recipes[2].title)
        assertEquals(recipeList[3].title, recipes[3].title)
    }

    @Test
    fun `viewModel 이 필터링을 잘 하는지 테스트()`() = runTest {
        viewModel.filterRecipes("Ttekbokki")

        val filteredRecipes = viewModel.state.value.filteredRecipes
        assertEquals(1, filteredRecipes.size)
        assertEquals("Ttekbokki", filteredRecipes[0].title)
        assertEquals("Kim Dahee", filteredRecipes[0].chef)
        assertEquals("30 min", filteredRecipes[0].time)
        assertEquals("Chinese", filteredRecipes[0].category)
        assertEquals(5.0, filteredRecipes[0].rating, 0.0)
        assertEquals("https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg", filteredRecipes[0].imageUrls)
    }


}