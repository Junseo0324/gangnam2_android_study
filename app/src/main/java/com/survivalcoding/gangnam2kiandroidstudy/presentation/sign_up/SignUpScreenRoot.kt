package com.survivalcoding.gangnam2kiandroidstudy.presentation.sign_up

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreenRoot(
    onNavigateToSignIn: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    viewModel: SignUpViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when(event) {
                SignUpEvent.NavigateToHome -> onNavigateToHome()
                is SignUpEvent.ShowError -> {
                    TODO()
                }
            }
        }

    }
    SignUpScreen(
        state = state,
        onAction = {
            when (it) {
                SignUpAction.OnSignInClick -> onNavigateToSignIn()
                else -> viewModel.onAction(it)
            }
        }
    )
}