package com.p.exportlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MavenTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void onMaven();
}
