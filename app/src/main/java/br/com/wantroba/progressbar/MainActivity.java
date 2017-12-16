package br.com.wantroba.progressbar;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends Activity {
    private CustomProgressBar customProgressBar;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customProgressBar = findViewById(R.id.customProgressBar);
        textView = findViewById(R.id.textView);
        final int progressRatio = customProgressBar.getMax() / 100;
        customProgressBar.setOnProgressChangedListener(new CustomProgressBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress) {
                textView.setText(String.valueOf(progress/progressRatio)+"%");
            }
        });

        Integer percent = 100;
        ObjectAnimator animationProgress = ObjectAnimator.ofInt(customProgressBar, "progress", percent * progressRatio);
        animationProgress.setDuration(5000);
        animationProgress.setInterpolator(new DecelerateInterpolator());
        animationProgress.start();


    }
}
