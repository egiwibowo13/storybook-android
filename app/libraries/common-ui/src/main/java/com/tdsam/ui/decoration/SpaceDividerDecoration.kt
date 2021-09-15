package com.tdsam.ui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import androidx.recyclerview.widget.RecyclerView.State

class SpaceDividerDecoration(
    private val space: Int
) : ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, child: View, parent: RecyclerView, state: State) {
        super.getItemOffsets(outRect, child, parent, state)

        (parent.layoutManager as? LinearLayoutManager)
            ?.let { layout ->
                val index = parent.getChildAdapterPosition(child)
                val count = state.itemCount

                if (index == NO_POSITION) return

                if (count == 1) return

                val (beg, end) = when (layout.orientation) {
                    HORIZONTAL -> Pair<(Int) -> Unit, (Int) -> Unit>(
                        { value -> outRect.left = value },
                        { value -> outRect.right = value }
                    )
                    VERTICAL -> Pair<(Int) -> Unit, (Int) -> Unit>(
                        { value -> outRect.top = value },
                        { value -> outRect.bottom = value }
                    )
                    else -> throw Error("Invalid LinearLayoutManager Orientation")
                }

                val size = space / 2
                when (index) {
                    0 -> end(size)
                    (count - 1) -> beg(size)
                    else -> {
                        beg(size)
                        end(size)
                    }
                }
            }
            ?: throw Error("SpacingDividerDecoration only support LinearLayoutManager")
    }
}
