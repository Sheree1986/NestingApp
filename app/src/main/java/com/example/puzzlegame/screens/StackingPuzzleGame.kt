//package com.example.puzzlegame.screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.PlayArrow
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun StackingPuzzleGame(onBackPressed: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    colors = listOf(Color(0xFF2C3E50), Color(0xFF34495E))
//                )
//            )
//    ) {
//        // Game Placeholder Content
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Icon(
//                Icons.Default.PlayArrow,
//                contentDescription = null,
//                tint = Color.White.copy(alpha = 0.3f),
//                modifier = Modifier.size(120.dp)
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Text(
//                text = "Game Screen",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = "Stacking Puzzle Game\nComing Soon!",
//                fontSize = 18.sp,
//                color = Color.White.copy(alpha = 0.7f),
//                textAlign = TextAlign.Center,
//                lineHeight = 24.sp
//            )
//
//            Spacer(modifier = Modifier.height(48.dp))
//
//            // Placeholder game elements
//            Card(
//                modifier = Modifier
//                    .width(200.dp)
//                    .height(60.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = Color(0xFF4CAF50).copy(alpha = 0.8f)
//                )
//            ) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = "Game Block",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Card(
//                modifier = Modifier
//                    .width(180.dp)
//                    .height(60.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = Color(0xFF2196F3).copy(alpha = 0.8f)
//                )
//            ) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = "Score: 0",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//        }
//
//        // Back button overlay
//        IconButton(
//            onClick = onBackPressed,
//            modifier = Modifier
//                .padding(16.dp)
//                .background(
//                    Color.Black.copy(alpha = 0.3f),
//                    RoundedCornerShape(24.dp)
//                )
//        ) {
//            Icon(
//                Icons.Default.ArrowBack,
//                contentDescription = "Back",
//                tint = Color.White
//            )
//        }
//    }
//}