package com.tdsam.ui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import kotlin.math.ceil

class GridSpaceDividerDecoration(inner: Int) : ItemDecoration() {

    private val split = inner / 2

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
        super.getItemOffsets(outRect, view, parent, state)

        (parent.layoutManager as? GridLayoutManager)
            ?.let { gridLayout ->
                val childPos: Int = parent.getChildAdapterPosition(view)
                if (childPos == NO_POSITION) return

                val colCount: Int = gridLayout.spanCount
                val rowCount: Int = ceil(state.itemCount.toDouble() / colCount).toInt()
                val childRow: Int = childPos / colCount
                val childCol: Int = childPos % colCount

                outRect.set(split, split, split, split)

                if (childRow == 0) outRect.top = 0
                if (childRow == (rowCount - 1)) outRect.bottom = 0

                if (childCol == 0) outRect.left = 0
                if (childCol == (colCount - 1)) outRect.right = 0
            }
            ?: throw Exception("GridAlbumSpacingDecoration only support GridLayoutManager")
    }
}
