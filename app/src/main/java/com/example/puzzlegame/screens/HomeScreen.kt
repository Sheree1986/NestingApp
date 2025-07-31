//package com.example.puzzlegame.screens
//
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.puzzlegame.components.AnimatedBackground
//import com.example.puzzlegame.components.MenuButton
//
//@Composable
//fun HomeScreen(
//    onPlayClicked: () -> Unit,
//    onSettingsClicked: () -> Unit,
//    onAboutClicked: () -> Unit
//) {
//    val infiniteTransition = rememberInfiniteTransition(label = "background")
//    val animatedFloat by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(10000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        ),
//        label = "rotation"
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.radialGradient(
//                    colors = listOf(
//                        Color(0xFF667eea),
//                        Color(0xFF764ba2),
//                        Color(0xFF2C3E50)
//                    ),
//                    radius = 1000f
//                )
//            )
//    ) {
//        // Animated background elements
//        AnimatedBackground(animatedFloat)
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(32.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // Game Title
//            Text(
//                text = "MATRYOSHKA",
//                fontSize = 34.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                letterSpacing = 8.sp
//            )
//            Text(
//                text = "PUZZLE",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Light,
//                color = Color.White.copy(alpha = 0.8f),
//                letterSpacing = 4.sp
//            )
//
//            Spacer(modifier = Modifier.height(64.dp))
//
//            // Menu Buttons
//            MenuButton(
//                text = "PLAY",
//                icon = Icons.Default.PlayArrow,
//                onClick = onPlayClicked,
//                isPrimary = true
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            MenuButton(
//                text = "SETTINGS",
//                icon = Icons.Default.Settings,
//                onClick = onSettingsClicked
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            MenuButton(
//                text = "ABOUT",
//                icon = Icons.Default.Info,
//                onClick = onAboutClicked
//            )
//
//            Spacer(modifier = Modifier.height(64.dp))
//
//            // High Score Display
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 32.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = Color.White.copy(alpha = 0.1f)
//                )
//            ) {
//                Column(
//                    modifier = Modifier.padding(16.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = "Best Score",
//                        color = Color.White.copy(alpha = 0.7f),
//                        fontSize = 14.sp
//                    )
//                    Text(
//                        text = "1,247",
//                        color = Color.White,
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//        }
//    }
//}