package com.example.classbitmapkotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.scale
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // get bitmap from drawable resource
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.leg)

        button.setOnClickListener {
            imageView2.setImageBitmap(bitmap.scaleByWidth(500))
        }

        button2.setOnClickListener {
            imageView2.setImageBitmap(bitmap.scaleByHeight(300))
        }
    }

    private fun Bitmap.scaleByWidth(newWidth:Int):Bitmap{
        val ratio:Float = this.width.toFloat() / this.height.toFloat()
        val newHeight = (newWidth / ratio).roundToInt()
        return this.scale(newWidth,newHeight,false)
    }

    private fun Bitmap.scaleByHeight(newHeight:Int):Bitmap{
        val ratio:Float = this.height.toFloat() / this.width.toFloat()
        val newWidth = (newHeight/ratio).roundToInt()
        return this.scale(newWidth, newHeight, false)
    }
}