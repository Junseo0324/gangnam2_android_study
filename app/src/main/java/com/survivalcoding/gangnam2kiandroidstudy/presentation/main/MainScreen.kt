package com.survivalcoding.gangnam2kiandroidstudy.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.survivalcoding.gangnam2kiandroidstudy.core.routing.Route

@Composable
fun MainScreen(
    body: @Composable (modifier: Modifier) -> Unit,
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier,
) {
    val currentRoute = backStack.lastOrNull()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentRoute is Route.Home,
                    onClick = {
                        backStack.clear()
                        backStack.add(Route.Home)
                    },
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = currentRoute is Route.SavedRecipes,
                    onClick = {
                        backStack.clear()
                        backStack.add(Route.SavedRecipes)
                    },
                    icon = {
                        Icon(Icons.Default.Favorite, contentDescription = "Saved Recipes")
                    },
                    label = { Text("Saved") }
                )
                NavigationBarItem(
                    selected = currentRoute is Route.Notifications,
                    onClick = {
                        backStack.clear()
                        backStack.add(Route.Notifications)
                    },
                    icon = {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    },
                    label = { Text("Notifications") }
                )
                NavigationBarItem(
                    selected = currentRoute is Route.Profile,
                    onClick = {
                        backStack.clear()
                        backStack.add(Route.Profile)
                    },
                    icon = {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    },
                    label = { Text("Profile") }
                )
            }
        }
    ) {
        body(modifier)
    }

}