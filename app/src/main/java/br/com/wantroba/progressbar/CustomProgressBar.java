package br.com.wantroba.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;


/**
 * Created by ewerton.wantroba on 31/10/17.
 */
public class CustomProgressBar extends View {
    protected int progress;
    private int max;
    private OnProgressChangedListener onProgressChangedListener;
    public CustomProgressBar(Context context) {
        super(context);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBarAttrs);
        progress = attributes.getInteger(R.styleable.CustomProgressBarAttrs_progress, 0);
        max = attributes.getInt(R.styleable.CustomProgressBarAttrs_max,0);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Drawable drawable = getResources().getDrawable(R.drawable.custom_progress_bar);
        ClipDrawable clipDrawable1 = new ClipDrawable(drawable, Gravity.LEFT, ClipDrawable.HORIZONTAL);
        clipDrawable1.setLevel(progress);
        clipDrawable1.setBounds(0, 0, getWidth(), getHeight());
        clipDrawable1.draw(canvas);
    }

    public int getProgress() {
        return progress;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setProgress(int progress){
        this.progress = progress;
        if(onProgressChangedListener!=null)
            onProgressChangedListener.onProgressChanged(progress);
        invalidate();

    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener){
        this.onProgressChangedListener = onProgressChangedListener;
    }

    public interface OnProgressChangedListener {
        void onProgressChanged(int progress);
    }


}
