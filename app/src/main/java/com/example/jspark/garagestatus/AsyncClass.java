package com.example.jspark.garagestatus;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jspark on 17. 6. 15.
 */

public class AsyncClass
{
    public void getValue()
    {
        class GetValueSync extends AsyncTask<Void, Void, String>
        {
            @Override
            protected String doInBackground(Void... params)
            {
                //StringBuilder 란 string과 마찬가지로 문자열을 담는 역할을 하지만, 차이점이 있습니다. 그것은 문자열을 수정할 수 있다.
                StringBuilder output = new StringBuilder();
                try
                {
                    URL url = new URL("http://118.91.118.27:52273/testPy");
                    //URL 객체를 이용하여 HttpURLConnection 객체 생성
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    if (conn != null)
                    {
                        //여기서!!1 GET 메소드를!!! (사용은 여기 아님 메소드의 정의?만 여기서 해줌)
                        conn.setRequestMethod("GET");
                        //DoInput과 DoOutput은 좀 더 찾아볼것...(00:44)
                        conn.setDoInput(true);
                        conn.setDoOutput(true);

                        //응답 코드를 얻어 resCode에 넣는다.
                        int resCode = conn.getResponseCode();

                        //BufferedReader 이건 무슨 클래스일까..? (00:46)
                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                        String line = null;
                        //반복문을 통하여 라인별('\n')로 읽으며 마지막 줄이 Null값일때까지 읽는 작업을 반복한다.
                        while (true)
                        {
                            line = reader.readLine();
                            if (line == null)
                            {
                                break;
                            }
                            //출력하는 변수인 output에다가 append하여 집어 넣는다. 아 물론 한 줄씩 읽었으므로 개행문자를 넣어준다,
                            output.append(line + "\n");
                        }
                        //reader의 작업이 끝났으므로 종료시킨다.
                        reader.close();
                        //물론 서버와의 연결도 종료한다.
                        conn.disconnect();
                        Log.d("OUTPUT_IS", output.toString());
                    }
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return output.toString();
            }
        }
        GetValueSync getValueSync = new GetValueSync();
        getValueSync.execute();
    }
}
