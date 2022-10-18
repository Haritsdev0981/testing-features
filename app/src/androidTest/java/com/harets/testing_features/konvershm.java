package com.harets.testing_features;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.harets.testing_features.R;

public class konvershm extends AppCompatActivity {

    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout dataLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer);
        shimmerFrameLayout.findViewById(R.id.shimmer_view);
        dataLayout.findViewById(R.id.data_view);

        dataLayout.setVisibility(View.INVISIBLE);
        shimmerFrameLayout.startShimmerAnimation();

        Handler handler = new Handler();
        handler.postDelayed(()->{
            dataLayout.setVisibility(View.VISIBLE);
            shimmerFrameLayout.stopShimmerAnimation();
            shimmerFrameLayout.setVisibility(View.INVISIBLE);
        },5000);
    }
}
