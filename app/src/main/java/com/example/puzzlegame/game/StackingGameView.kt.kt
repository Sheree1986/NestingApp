//package com.example.puzzlegame.game
//
//import android.content.Context
//import android.graphics.*
//import android.util.AttributeSet
//import android.view.MotionEvent
//import android.view.View
//import com.example.puzzlegame.models.Block
//import kotlin.math.*
//import kotlin.random.Random
//
//// Original StackingGameView class
//class StackingGameView @JvmOverloads constructor(
//    context: Context,
//    attrs: AttributeSet? = null,
//    defStyleAttr: Int = 0
//) : View(context, attrs, defStyleAttr) {
//
//    private val paint = Paint().apply {
//        isAntiAlias = true
//        style = Paint.Style.FILL
//    }
//
//    private val textPaint = Paint().apply {
//        isAntiAlias = true
//        textSize = 60f
//        typeface = Typeface.DEFAULT_BOLD
//        textAlign = Paint.Align.CENTER
//    }
//
//    private val blocks = mutableListOf<Block>()
//    private var gameWidth = 0f
//    private var gameHeight = 0f
//    private var score = 0
//    private var gameOver = false
//    private var gameStarted = false
//    private val blockHeight = 80f
//    private val baseBlockWidth = 400f
//
//    private val colors = arrayOf(
//        android.graphics.Color.parseColor("#FF6B6B"),
//        android.graphics.Color.parseColor("#4ECDC4"),
//        android.graphics.Color.parseColor("#45B7D1"),
//        android.graphics.Color.parseColor("#96CEB4"),
//        android.graphics.Color.parseColor("#FFEAA7"),
//        android.graphics.Color.parseColor("#DDA0DD"),
//        android.graphics.Color.parseColor("#98D8C8"),
//        android.graphics.Color.parseColor("#FD79A8")
//    )
//
//    init {
//        initGame()
//    }
//
//    private fun initGame() {
//        blocks.clear()
//        score = 0
//        gameOver = false
//        gameStarted = false
//
//        // Add base block
//        val baseBlock = Block(
//            x = gameWidth / 2 - baseBlockWidth / 2,
//            y = gameHeight - blockHeight - 100f,
//            width = baseBlockWidth,
//            height = blockHeight,
//            color = colors[0]
//        )
//        blocks.add(baseBlock)
//
////        spawnNewBlock()
//    }
//}
////    private fun spawnNewBlock() {
////        if (blocks.isEmpty()) return
////
////        val lastBlock = blocks.last()
////        val newWidth = max(lastBlock.width * 0.95f, 100f)
////
////        val newBlock = Block(
////            x = 0f,y = 0f,
////
////    }