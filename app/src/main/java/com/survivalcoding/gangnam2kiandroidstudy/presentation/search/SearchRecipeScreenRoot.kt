package com.survivalcoding.gangnam2kiandroidstudy.presentation.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchRecipeScreenRoot(
    viewModel: SearchRecipesViewModel = koinViewModel(),
    onRecipeClick: (Int) -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SearchRecipeScreen(
        state = state,
        showBottomSheet = state.showBottomSheet,
        onAction = { action ->
            when (action) {
                is SearchRecipesAction.SelectRecipes -> {
                    onRecipeClick(action.id)
                }
                else -> viewModel.onAction(action)
            }
        }
    )
}