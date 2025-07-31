//package com.example.puzzlegame.screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
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
//fun AboutScreen(onBackPressed: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    colors = listOf(Color(0xFF2C3E50), Color(0xFF34495E))
//                )
//            )
//            .padding(24.dp)
//    ) {
//        // Header
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = onBackPressed) {
//                Icon(
//                    Icons.Default.ArrowBack,
//                    contentDescription = "Back",
//                    tint = Color.White
//                )
//            }
//            Text(
//                text = "About",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                modifier = Modifier.padding(start = 16.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Game Info
//        Card(
//            modifier = Modifier.fillMaxWidth(),
//            colors = CardDefaults.cardColors(
//                containerColor = Color.White.copy(alpha = 0.1f)
//            )
//        ) {
//            Column(
//                modifier = Modifier.padding(24.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Matryoshka Stacking Puzzle",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    text = "Version 1.0.0",
//                    fontSize = 16.sp,
//                    color = Color.White.copy(alpha = 0.7f)
//                )
//
//                Spacer(modifier = Modifier.height(24.dp))
//
//                Text(
//                    text = "A challenging puzzle game where you stack blocks by timing your taps perfectly. Try to build the highest tower possible!",
//                    fontSize = 16.sp,
//                    color = Color.White.copy(alpha = 0.8f),
//                    textAlign = TextAlign.Center,
//                    lineHeight = 24.sp
//                )
//
//                Spacer(modifier = Modifier.height(24.dp))
//
//                Text(
//                    text = "How to Play:",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                Text(
//                    text = "• Tap to drop the moving block\n• Stack blocks on top of each other\n• Perfect alignment gives bonus points\n• Game ends when blocks don't overlap",
//                    fontSize = 14.sp,
//                    color = Color.White.copy(alpha = 0.8f),
//                    lineHeight = 20.sp
//                )
//            }
//        }
//    }
//}