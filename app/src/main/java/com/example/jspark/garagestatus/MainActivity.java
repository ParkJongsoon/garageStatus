package com.example.jspark.garagestatus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private AsyncClass asyncClass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asyncClass = new AsyncClass("http://118.91.118.27:52273/testPy");
    }
}
