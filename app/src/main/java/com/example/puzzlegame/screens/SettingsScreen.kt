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
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.puzzlegame.components.SettingsItem
//
//@Composable
//fun SettingsScreen(onBackPressed: () -> Unit) {
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
//                text = "Settings",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                modifier = Modifier.padding(start = 16.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Settings Options
//        SettingsItem(
//            title = "Sound Effects",
//            subtitle = "Enable game sounds",
//            isToggle = true
//        )
//
//        SettingsItem(
//            title = "Music",
//            subtitle = "Background music",
//            isToggle = true
//        )
//
//        SettingsItem(
//            title = "Vibration",
//            subtitle = "Haptic feedback",
//            isToggle = true
//        )
//
//        SettingsItem(
//            title = "Difficulty",
//            subtitle = "Easy • Normal • Hard"
//        )
//    }
//}