package com.survivalcoding.gangnam2kiandroidstudy.data.datasource

import com.survivalcoding.gangnam2kiandroidstudy.data.model.Recipe

interface RecipeDataSource {
    suspend fun getRecipes(): List<Recipe>
}