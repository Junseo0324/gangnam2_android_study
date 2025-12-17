package com.survivalcoding.gangnam2kiandroidstudy.presentation.ingredient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.survivalcoding.gangnam2kiandroidstudy.AppApplication
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientScreenRoot(
    recipeId: Int,
    viewModel: IngridentViewModel = koinViewModel(),
) {
    viewModel.loadRecipeDetail(recipeId)

    val state = viewModel.state.collectAsState()

    IngredientScreen(
        state = state.value,
        onValueChange = { index ->
            viewModel.toggleTab(index)
        }
    )
}