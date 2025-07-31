//package com.example.puzzlegame.components
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.KeyboardArrowRight
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun SettingsItem(
//    title: String,
//    subtitle: String,
//    isToggle: Boolean = false
//) {
//    val isEnabled = true // Static state - not functional
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White.copy(alpha = 0.1f)
//        )
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column {
//                Text(
//                    text = title,
//                    color = Color.White,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Medium
//                )
//                Text(
//                    text = subtitle,
//                    color = Color.White.copy(alpha = 0.7f),
//                    fontSize = 14.sp
//                )
//            }
//
//            if (isToggle) {
//                Switch(
//                    checked = isEnabled,
//                    onCheckedChange = { /* Not functional */ },
//                    enabled = false, // Disabled to prevent interaction
//                    colors = SwitchDefaults.colors(
//                        checkedThumbColor = Color(0xFF4CAF50),
//                        checkedTrackColor = Color(0xFF4CAF50).copy(alpha = 0.5f),
//                        disabledCheckedThumbColor = Color(0xFF4CAF50).copy(alpha = 0.6f),
//                        disabledCheckedTrackColor = Color(0xFF4CAF50).copy(alpha = 0.3f)
//                    )
//                )
//            } else {
//                Icon(
//                    Icons.Default.KeyboardArrowRight,
//                    contentDescription = null,
//                    tint = Color.White.copy(alpha = 0.3f) // More faded to show non-functional
//                )
//            }
//        }
//    }
//}