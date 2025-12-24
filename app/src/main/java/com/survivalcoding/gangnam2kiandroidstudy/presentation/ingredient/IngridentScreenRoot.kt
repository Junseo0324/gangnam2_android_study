package com.survivalcoding.gangnam2kiandroidstudy.presentation.ingredient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.survivalcoding.gangnam2kiandroidstudy.presentation.component.ShareDialog
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientScreenRoot(
    recipeId: Int,
    viewModel: IngridentViewModel = koinViewModel(),
    onBackClick: () -> Unit = {}
) {
    viewModel.loadRecipeDetail(recipeId)

    val state = viewModel.state.collectAsState()

    var isDropDownExpanded by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    IngredientScreen(
        state = state.value,
        isDropDownExpanded = isDropDownExpanded,
        onAction = { action ->
            when(action) {
                is IngredientAction.OnValueChange -> {
                    viewModel.onAction(action)
                }
                IngredientAction.OnDropDownClick -> {
                    isDropDownExpanded = true
                }

                IngredientAction.OnDropDownDismiss -> {
                    isDropDownExpanded = false
                }

                IngredientAction.OnShareClick -> {
                    isDropDownExpanded = false
                    showDialog = true
                }

            }
        },
        onBackClick = onBackClick
    )

    if (showDialog) {
        ShareDialog(
            onDismiss = {
                showDialog = false
            },
            onCopy = { link ->
                viewModel.onCopyClick(link)
                showDialog = false
            }
        )
    }
}