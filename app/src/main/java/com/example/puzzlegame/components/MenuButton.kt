//package com.example.puzzlegame.components
//
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun MenuButton(
//    text: String,
//    icon: ImageVector,
//    onClick: () -> Unit,
//    isPrimary: Boolean = false
//) {
//    var isPressed by remember { mutableStateOf(false) }
//    val scale by animateFloatAsState(
//        targetValue = if (isPressed) 0.95f else 1f,
//        animationSpec = tween(100),
//        label = "button_scale"
//    )
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//            .scale(scale)
//            .clickable {
//                isPressed = true
//                onClick()
//            }
//            .padding(horizontal = 32.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = if (isPrimary)
//                Color(0xFF4CAF50).copy(alpha = 0.9f)
//            else
//                Color.White.copy(alpha = 0.1f)
//        ),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = if (isPrimary) 8.dp else 4.dp
//        )
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 24.dp),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = icon,
//                contentDescription = null,
//                tint = Color.White,
//                modifier = Modifier.size(24.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = text,
//                color = Color.White,
//                fontSize = 18.sp,
//                fontWeight = if (isPrimary) FontWeight.Bold else FontWeight.Medium
//            )
//        }
//    }
//
//    LaunchedEffect(isPressed) {
//        if (isPressed) {
//            kotlinx.coroutines.delay(100)
//            isPressed = false
//        }
//    }
//}