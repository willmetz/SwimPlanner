package com.slapshotapps.swimplanner.widgets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.TextView
import java.util.jar.Attributes
import android.graphics.Shader
import android.graphics.LinearGradient




class FadingTextView: TextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (changed) {
            paint.shader = LinearGradient(
                0f, 0f, 0f, height.toFloat(),
                Color.BLACK, Color.TRANSPARENT,
                Shader.TileMode.CLAMP)
        }
    }
}