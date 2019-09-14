package com.example.massager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txv;

    private class MainActivityListener implements View.OnTouchListener {

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            if (vb != null) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    vb.vibrate(5000);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    vb.cancel();
                }
            }

            return false;
        }
    }

    MainActivityListener listener = new MainActivityListener();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv = findViewById(R.id.txv);
        txv.setOnTouchListener(listener);
    }
}
