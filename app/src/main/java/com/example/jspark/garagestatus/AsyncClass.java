package com.example.jspark.garagestatus;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jspark on 17. 6. 15.
 */

public class AsyncClass
{
    private String _url;

    public AsyncClass(String url)
    {
        _url = url;
    }
}
