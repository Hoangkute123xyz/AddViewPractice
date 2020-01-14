package com.hoangpro.addviewpractice.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hoangpro.addviewpractice.R;

public class ShowActivity extends AppCompatActivity {
    public static String subject;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        if (subject != null) {
            textView.setText(subject);
        }
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
