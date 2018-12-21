package com.lemon.lemonmovies;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

/**
 * A simple {@link ItemDecoration} to decorate linear items for recycler view
 *
 * @see ItemDecoration
 * @see LinearLayoutManager
 */
public final class LinearSpacingItemDecoration extends ItemDecoration {

    private static final int ZERO = 0;
    private static final int HALF_DIVIDER = 2;
    private static final int LAST_CELL_OFFSET = 1;

    private final int mSpacing;
    private final boolean mIncludeEdge;
    private final boolean mIsVertical;

    private LinearSpacingItemDecoration(final Builder builder) {
        mSpacing = builder.mSpacing;
        mIncludeEdge = builder.mIncludeEdge;
        mIsVertical = builder.mOrientation == LinearLayoutManager.VERTICAL;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public void getItemOffsets(final Rect outRect, final View view,
                               final RecyclerView parent, final RecyclerView.State state) {
        final int position = parent.getChildAdapterPosition(view);
        final boolean isFirstCell = position == ZERO;
        final boolean isLastCell = position == parent.getAdapter().getItemCount() - LAST_CELL_OFFSET;

        if (mIsVertical) {
            outRect.left = mSpacing;
            outRect.right = mSpacing;
        }

        if (isFirstCell) {
            if (mIsVertical) {
                outRect.top = mIncludeEdge ? mSpacing : ZERO;
                outRect.bottom = isLastCell ? (mIncludeEdge ? mSpacing : ZERO) : ZERO;
            } else {
                outRect.left = mIncludeEdge ? mSpacing : ZERO;
                outRect.right = mSpacing / HALF_DIVIDER;
            }
        } else if (isLastCell) {
            if (mIsVertical) {
                outRect.top = ZERO;
                outRect.bottom = mIncludeEdge ? mSpacing : ZERO;
            } else {
                outRect.left = mSpacing / HALF_DIVIDER;
                outRect.right = mIncludeEdge ? mSpacing : ZERO;
            }
        } else {
            if (mIsVertical) {
                outRect.top = ZERO;
                outRect.bottom = ZERO;
            } else {
                outRect.left = mSpacing / HALF_DIVIDER;
                outRect.right = mSpacing / HALF_DIVIDER;
            }
        }
    }

    public static final class Builder {
        private int mSpacing;
        private boolean mIncludeEdge;
        private int mOrientation;

        public Builder setSpacing(final int spacing) {
            this.mSpacing = spacing;
            return this;
        }

        public Builder includeEdge(final boolean includeEdge) {
            this.mIncludeEdge = includeEdge;
            return this;
        }

        public Builder setOrientation(final int orientation) {
            this.mOrientation = orientation;
            return this;
        }

        public LinearSpacingItemDecoration build() {
            return new LinearSpacingItemDecoration(this);
        }

        private Builder() {
        }
    }

}
