package com.tdsam.ui.decoration

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style.STROKE
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.graphics.*
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State
import kotlin.math.max
import kotlin.math.min

class LineDividerDecoration(
    @ColorInt
    private val lineColor: Int,
    private val thickness: Int,
    private val paddingSz: Int = 0,
    private val showAtEnd: Boolean = false
) : ItemDecoration() {

    private val paint = Paint().apply {
        strokeWidth = thickness.toFloat()
        style = STROKE
        color = lineColor
    }

    @Suppress("UsePropertyAccessSyntax")
    override fun getItemOffsets(outRect: Rect, child: View, parent: RecyclerView, state: State) {
        (parent.getLayoutManager() as? LinearLayoutManager)
            ?.let { layout ->
                val itemIndex = parent.getChildAdapterPosition(child)
                val itemCount = state.itemCount

                outRect.setEmpty()

                if (!showAtEnd && itemIndex == (itemCount - 1))
                    return

                when (layout.orientation) {
                    HORIZONTAL -> outRect.right = thickness
                    VERTICAL -> outRect.bottom = thickness
                    else -> Unit
                }
            }
            ?: throw Exception("LineDividerDecoration only support LinearLayoutManager")
    }

    @Suppress("UsePropertyAccessSyntax")
    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: State) {
        (parent.getLayoutManager() as? LinearLayoutManager)
            ?.let { layout ->
                canvas.withSave {
                    val outBounds = Rect()
                    val itemCount = state.itemCount
                    val penOffset = (thickness / 2)

                    for (child in parent.children) {
                        val itemIndex = parent.getChildAdapterPosition(child)

                        if (!showAtEnd && itemIndex == (itemCount - 1))
                            break

                        parent.getDecoratedBoundsWithMargins(child, outBounds)

                        val (x0, y0, x1, y1) = outBounds.toRectF()
                        when (layout.orientation) {
                            HORIZONTAL -> drawLine(
                                x1 + penOffset,
                                min(y0 + paddingSz, y1),
                                x1 + penOffset,
                                max(y1 - paddingSz, y0),
                                paint
                            )
                            VERTICAL -> drawLine(
                                min(x0 + paddingSz, x1),
                                y1 + penOffset,
                                max(x1 - paddingSz, x0),
                                y1 + penOffset,
                                paint
                            )
                            else -> Unit
                        }
                    }
                }
            }
            ?: throw Exception("LineDividerDecoration only support LinearLayoutManager")
    }
}
