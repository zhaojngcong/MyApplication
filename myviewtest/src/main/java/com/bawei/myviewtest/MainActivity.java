package com.bawei.myviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadialGradientView radialGradientView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radialGradientView = new RadialGradientView(this);
        setContentView(radialGradientView);
        radialGradientView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点击图片",Toast.LENGTH_SHORT).show();
            }
        });
        View myView = findViewById(R.id.rgview);

    }
}
