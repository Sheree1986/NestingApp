//package com.example.puzzlegame
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import com.example.puzzlegame.models.GameScreen
//import com.example.puzzlegame.screens.AboutScreen
//import com.example.puzzlegame.screens.HomeScreen
//import com.example.puzzlegame.screens.SettingsScreen
//import com.example.puzzlegame.screens.StackingPuzzleGame
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GameApp() {
//    var currentScreen by remember { mutableStateOf<GameScreen>(GameScreen.Home) }
//    var isFullscreen by remember { mutableStateOf(false) }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        when (currentScreen) {
//            GameScreen.Home -> {
//                HomeScreen(
//                    onPlayClicked = {
//                        currentScreen = GameScreen.StackingGame
//                        isFullscreen = true
//                    },
//                    onSettingsClicked = { currentScreen = GameScreen.Settings },
//                    onAboutClicked = { currentScreen = GameScreen.About }
//                )
//            }
//            GameScreen.StackingGame -> {
//                StackingPuzzleGame(
//                    onBackPressed = {
//                        currentScreen = GameScreen.Home
//                        isFullscreen = false
//                    }
//                )
//            }
//            GameScreen.Settings -> {
//                SettingsScreen(
//                    onBackPressed = { currentScreen = GameScreen.Home }
//                )
//            }
//            GameScreen.About -> {
//                AboutScreen(
//                    onBackPressed = { currentScreen = GameScreen.Home }
//                )
//            }
//        }
//    }
//
//    // Handle fullscreen mode
//    LaunchedEffect(isFullscreen) {
//        // This would be handled in the Activity if needed
//    }
//}