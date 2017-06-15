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
    class BackgroundTask extends AsyncTask<String,Void,Integer>
    {
        @Override
        protected String doInBackground(String... params)
        {
            String uri = params[0];
            StringBuilder sb = new StringBuilder();

            BufferedReader bufferedReader = null;
            try
            {
                URL url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();


                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String json;
                while ((json = bufferedReader.readLine()) != null)
                {
                    sb.append(json + "\n");
                    Log.d("test",sb.toString());
                }

            } catch (Exception e)
            {
                Log.d("Exception_error",e.toString());
            }
            return sb.toString().trim();
        }

        @Override
        protected void onPostExecute(String result)
        {
            Log.d("onPostExecute", result);
            _getData = result;
        }
    }
    //endregion
    GetMarkerAsyncTask _getMarker = new GetMarkerAsyncTask();
        _getMarker.execute(url);
}
}
