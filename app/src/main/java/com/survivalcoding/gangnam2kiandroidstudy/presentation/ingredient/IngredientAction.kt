package com.survivalcoding.gangnam2kiandroidstudy.presentation.ingredient


sealed interface IngredientAction {
    data class OnValueChange(val value: Int) : IngredientAction
    data object OnDropDownClick: IngredientAction
    data object OnDropDownDismiss: IngredientAction
    data object OnShareClick: IngredientAction
    data class OnCopyClick(val text: String): IngredientAction

}