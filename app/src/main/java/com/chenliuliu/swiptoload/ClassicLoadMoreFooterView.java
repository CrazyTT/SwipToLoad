package com.chenliuliu.swiptoload;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreFooterLayout;

/**
 * Created by Aspsine on 2015/9/2.
 */
public class ClassicLoadMoreFooterView extends SwipeLoadMoreFooterLayout {
    private TextView tvLoadMore;
    private ImageView ivSuccess;
    private ImageView progressBar;

    private int mFooterHeight;

    public ClassicLoadMoreFooterView(Context context) {
        this(context, null);
    }

    public ClassicLoadMoreFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClassicLoadMoreFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mFooterHeight = getResources().getDimensionPixelOffset(R.dimen.load_more_footer_height_classic);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvLoadMore = (TextView) findViewById(R.id.tvLoadMore);
        ivSuccess = (ImageView) findViewById(R.id.ivSuccess);
        progressBar = (ImageView) findViewById(R.id.btn_anim);
    }

    @Override
    public void onPrepare() {
        ivSuccess.setVisibility(GONE);
    }

    @Override
    public void onSwipe(int y, boolean isComplete) {
        if (!isComplete) {
            ivSuccess.setVisibility(GONE);
            progressBar.setVisibility(GONE);
            if (-y >= mFooterHeight) {
                tvLoadMore.setText(R.string.string_release_to_load_more);
            } else {
                tvLoadMore.setText(R.string.string_swip_to_load_more);
            }
        }
    }

    @Override
    public void onLoadMore() {
        tvLoadMore.setText(R.string.string_loading);
        progressBar.setVisibility(VISIBLE);
        AnimationDrawable  animationDrawable4 = (AnimationDrawable) progressBar.getDrawable();
        animationDrawable4.start();
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void complete() {
        progressBar.setVisibility(GONE);
        ivSuccess.setVisibility(VISIBLE);
    }

    @Override
    public void onReset() {
        ivSuccess.setVisibility(GONE);
    }
}
