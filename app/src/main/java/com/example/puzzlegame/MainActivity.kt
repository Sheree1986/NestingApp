package com.example.puzzlegame

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puzzlegame.ui.theme.PuzzleGameTheme


import kotlin.math.*
import kotlin.random.Random

// Game States
sealed class GameScreen {
    object Home : GameScreen()
    object StackingGame : GameScreen()
    object Settings : GameScreen()
    object About : GameScreen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PuzzleGameTheme {
                GameApp()
            }
        }
    }
}

//@Composable
//fun PuzzleGameTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable () -> Unit
//) {
//    val DarkColors = Color.Black;
//    val LightColors
//    val colors = if (darkTheme) DarkColors else LightColors
//
//    MaterialTheme(
//        colorScheme = colors,
//        content = content
//    )
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameApp() {
    var currentScreen by remember { mutableStateOf<GameScreen>(GameScreen.Home) }
    var isFullscreen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        when (currentScreen) {
            GameScreen.Home -> {
                HomeScreen(
                    onPlayClicked = {
                        currentScreen = GameScreen.StackingGame
                        isFullscreen = true
                    },
                    onSettingsClicked = { currentScreen = GameScreen.Settings },
                    onAboutClicked = { currentScreen = GameScreen.About }
                )
            }
            GameScreen.StackingGame -> {
                StackingPuzzleGame(
                    onBackPressed = {
                        currentScreen = GameScreen.Home
                        isFullscreen = false
                    }
                )
            }
            GameScreen.Settings -> {
                SettingsScreen(
                    onBackPressed = { currentScreen = GameScreen.Home }
                )
            }
            GameScreen.About -> {
                AboutScreen(
                    onBackPressed = { currentScreen = GameScreen.Home }
                )
            }
        }
    }

    // Handle fullscreen mode
    LaunchedEffect(isFullscreen) {
        // This would be handled in the Activity if needed
    }
}

@Composable
fun HomeScreen(
    onPlayClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onAboutClicked: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "background")
    val animatedFloat by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF667eea),
                        Color(0xFF764ba2),
                        Color(0xFF2C3E50)
                    ),
                    radius = 1000f
                )
            )
    ) {
        // Animated background elements
        AnimatedBackground(animatedFloat)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Game Title
            Text(
                text = "MATRYOSHKA",
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                letterSpacing = 8.sp
            )
            Text(
                text = "PUZZLE",
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
                color = Color.White.copy(alpha = 0.8f),
                letterSpacing = 4.sp
            )

            Spacer(modifier = Modifier.height(64.dp))

            // Menu Buttons
            MenuButton(
                text = "PLAY",
                icon = Icons.Default.PlayArrow,
                onClick = onPlayClicked,
                isPrimary = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            MenuButton(
                text = "SETTINGS",
                icon = Icons.Default.Settings,
                onClick = onSettingsClicked
            )

            Spacer(modifier = Modifier.height(16.dp))

            MenuButton(
                text = "ABOUT",
                icon = Icons.Default.Info,
                onClick = onAboutClicked
            )

            Spacer(modifier = Modifier.height(64.dp))

            // High Score Display
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.1f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Best Score",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "1,247",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedBackground(rotation: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val centerX = size.width / 2f
        val centerY = size.height / 2f

        for (i in 0..5) {
            val angle = rotation + i * 60f
            val radius = 200f + i * 50f
            val x = centerX + cos(Math.toRadians(angle.toDouble())).toFloat() * radius
            val y = centerY + sin(Math.toRadians(angle.toDouble())).toFloat() * radius

            drawCircle(
                color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.05f),
                radius = 30f + i * 10f,
                center = androidx.compose.ui.geometry.Offset(x, y)
            )
        }
    }
}

@Composable
fun MenuButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    isPrimary: Boolean = false
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(100),
        label = "button_scale"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .scale(scale)
            .clickable {
                isPressed = true
                onClick()
            }
            .padding(horizontal = 32.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isPrimary)
                Color(0xFF4CAF50).copy(alpha = 0.9f)
            else
                Color.White.copy(alpha = 0.1f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isPrimary) 8.dp else 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = if (isPrimary) FontWeight.Bold else FontWeight.Medium
            )
        }
    }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            kotlinx.coroutines.delay(100)
            isPressed = false
        }
    }
}

@Composable
fun SettingsScreen(onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF2C3E50), Color(0xFF34495E))
                )
            )
            .padding(24.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackPressed) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = "Settings",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Settings Options
        SettingsItem(
            title = "Sound Effects",
            subtitle = "Enable game sounds",
            isToggle = true
        )

        SettingsItem(
            title = "Music",
            subtitle = "Background music",
            isToggle = true
        )

        SettingsItem(
            title = "Vibration",
            subtitle = "Haptic feedback",
            isToggle = true
        )

        SettingsItem(
            title = "Difficulty",
            subtitle = "Easy • Normal • Hard"
        )
    }
}

@Composable
fun SettingsItem(
    title: String,
    subtitle: String,
    isToggle: Boolean = false
) {
    val isEnabled = true // Static state - not functional

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.1f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = subtitle,
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
            }

            if (isToggle) {
                Switch(
                    checked = isEnabled,
                    onCheckedChange = { /* Not functional */ },
                    enabled = false, // Disabled to prevent interaction
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF4CAF50),
                        checkedTrackColor = Color(0xFF4CAF50).copy(alpha = 0.5f),
                        disabledCheckedThumbColor = Color(0xFF4CAF50).copy(alpha = 0.6f),
                        disabledCheckedTrackColor = Color(0xFF4CAF50).copy(alpha = 0.3f)
                    )
                )
            } else {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.3f) // More faded to show non-functional
                )
            }
        }
    }
}

@Composable
fun AboutScreen(onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF2C3E50), Color(0xFF34495E))
                )
            )
            .padding(24.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackPressed) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = "About",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Game Info
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.1f)
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Matryoshka Stack",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Version 1.0.0",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Inspired by Russian Matryoshka (nesting dolls), this game challenges you to stack blocks perfectly inside each other. Just like the traditional wooden dolls that fit one inside another, each block must align precisely with the one below!",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Matryoshka Rules:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "• Each block must fit inside the previous one\n• Blocks get smaller as you stack higher\n• Perfect nesting gives bonus points\n• Miss the alignment and your tower falls\n• Build the tallest Matryoshka tower possible!",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.8f),
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "🪆 Traditional Matryoshka Wisdom:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "\"Like the nested dolls of old Russia, patience and precision create perfect harmony.\"",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    lineHeight = 20.sp
                )
            }
        }
    }
}



@Composable
fun StackingPuzzleGame(onBackPressed: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF2C3E50), Color(0xFF34495E))
                )
            )
    ) {
        // Game Placeholder Content
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.3f),
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Game Screen",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Stacking Puzzle Game\nComing Soon!",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Placeholder game elements
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF4CAF50).copy(alpha = 0.8f)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Game Block",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .width(180.dp)
                    .height(60.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF2196F3).copy(alpha = 0.8f)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Score: 0",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Back button overlay
        IconButton(
            onClick = onBackPressed,
            modifier = Modifier
                .padding(16.dp)
                .background(
                    Color.Black.copy(alpha = 0.3f),
                    RoundedCornerShape(24.dp)
                )
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
}

// Original StackingGameView class remains the same
class StackingGameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    data class Block(
        var x: Float,
        var y: Float,
        var width: Float,
        var height: Float,
        var color: Int,
        var isMoving: Boolean = false,
        var direction: Int = 1,
        var speed: Float = 8f
    )

    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    private val textPaint = Paint().apply {
        isAntiAlias = true

        textSize = 60f
        typeface = Typeface.DEFAULT_BOLD
        textAlign = Paint.Align.CENTER
    }

    private val blocks = mutableListOf<Block>()
    private var gameWidth = 0f
    private var gameHeight = 0f
    private var score = 0
    private var gameOver = false
    private var gameStarted = false
    private val blockHeight = 80f
    private val baseBlockWidth = 400f

    private val colors = arrayOf(
        android.graphics.Color.parseColor("#FF6B6B"),
        android.graphics.Color.parseColor("#4ECDC4"),
        android.graphics.Color.parseColor("#45B7D1"),
        android.graphics.Color.parseColor("#96CEB4"),
        android.graphics.Color.parseColor("#FFEAA7"),
        android.graphics.Color.parseColor("#DDA0DD"),
        android.graphics.Color.parseColor("#98D8C8"),
        android.graphics.Color.parseColor("#FD79A8")
    )

    init {
        initGame()
    }

    private fun initGame() {
        blocks.clear()
        score = 0
        gameOver = false
        gameStarted = false

        // Add base block
        val baseBlock = Block(
            x = gameWidth / 2 - baseBlockWidth / 2,
            y = gameHeight - blockHeight - 100f,
            width = baseBlockWidth,
            height = blockHeight,
            color = colors[0]
        )
        blocks.add(baseBlock)

        spawnNewBlock()
    }

    private fun spawnNewBlock() {
        if (blocks.isEmpty()) return

        val lastBlock = blocks.last()
        val newWidth = max(lastBlock.width * 0.95f, 100f)

        val newBlock = Block(
            x = 0f,
            y = lastBlock.y - blockHeight - 10f,
            width = newWidth,
            height = blockHeight,
            color = colors[blocks.size % colors.size],
            isMoving = true,
            direction = if (Random.nextBoolean()) 1 else -1,
            speed = min(12f, 6f + blocks.size * 0.5f)
        )

        blocks.add(newBlock)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        gameWidth = w.toFloat()
        gameHeight = h.toFloat()
        initGame()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(android.graphics.Color.parseColor("#2C3E50"))

        for (block in blocks) {
            paint.color = block.color
            canvas.drawRoundRect(
                block.x,
                block.y,
                block.x + block.width,
                block.y + block.height,
                16f, 16f,
                paint
            )

            paint.color = android.graphics.Color.parseColor("#34495E")
            canvas.drawRoundRect(
                block.x + 4f,
                block.y + 4f,
                block.x + block.width + 4f,
                block.y + block.height + 4f,
                16f, 16f,
                paint
            )

            paint.color = block.color
            canvas.drawRoundRect(
                block.x,
                block.y,
                block.x + block.width,
                block.y + block.height,
                16f, 16f,
                paint
            )
        }

        canvas.drawText(
            "Score: $score",
            gameWidth / 2,
            100f,
            textPaint
        )

        if (gameOver) {
            textPaint.textSize = 80f
            canvas.drawText(
                "Game Over!",
                gameWidth / 2,
                gameHeight / 2 - 100f,
                textPaint
            )
            textPaint.textSize = 50f
            canvas.drawText(
                "Tap to restart",
                gameWidth / 2,
                gameHeight / 2,
                textPaint
            )
            textPaint.textSize = 60f
        } else if (!gameStarted) {
            textPaint.textSize = 60f
            canvas.drawText(
                "Tap to drop blocks!",
                gameWidth / 2,
                gameHeight / 2,
                textPaint
            )
        }
    }

    private fun updateGame() {
        if (gameOver || !gameStarted) return

        for (block in blocks) {
            if (block.isMoving) {
                block.x += block.direction * block.speed

                if (block.x <= 0 || block.x + block.width >= gameWidth) {
                    block.direction *= -1
                    block.x = max(0f, min(block.x, gameWidth - block.width))
                }
            }
        }

        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            if (gameOver) {
                initGame()
                return true
            }

            if (!gameStarted) {
                gameStarted = true
                return true
            }

            dropBlock()
        }
        return true
    }

    private fun dropBlock() {
        val movingBlock = blocks.lastOrNull { it.isMoving } ?: return
        movingBlock.isMoving = false

        if (blocks.size > 1) {
            val previousBlock = blocks[blocks.size - 2]

            val overlapLeft = max(movingBlock.x, previousBlock.x)
            val overlapRight = min(movingBlock.x + movingBlock.width, previousBlock.x + previousBlock.width)
            val overlapWidth = overlapRight - overlapLeft

            if (overlapWidth <= 0) {
                gameOver = true
                return
            }

            val centerDiff = abs((movingBlock.x + movingBlock.width / 2) - (previousBlock.x + previousBlock.width / 2))
            val perfectThreshold = 20f

            if (centerDiff <= perfectThreshold) {
                score += 10
            } else {
                score += 1
            }

            movingBlock.x = overlapLeft
            movingBlock.width = overlapWidth

            if (movingBlock.width < 50f) {
                gameOver = true
                return
            }
        } else {
            score += 1
        }

        spawnNewBlock()
    }

    private val gameLoop = object : Runnable {
        override fun run() {
            updateGame()
            postDelayed(this, 16)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        post(gameLoop)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeCallbacks(gameLoop)
    }
}