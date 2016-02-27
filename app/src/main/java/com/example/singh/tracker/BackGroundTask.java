package com.example.singh.tracker;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by singh on 2/26/2016.
 */
public class BackGroundTask extends AsyncTask<String, Void, String> {


    Context ctx;
    BackGroundTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
       String reg_url = "http://tracker.hol.es/upload.php";
 //    String reg_url = "http://localhost/tracker/upload.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String id= params[1];
            String lat =params[2];
      String lang = params[3];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data = URLEncoder.encode("id","UTF-8")+ "=" + URLEncoder.encode(id,"UTF-8")+"&"+
                        URLEncoder.encode("lat","UTF-8")+ "=" + URLEncoder.encode(lat,"UTF-8")+"&"+
                        URLEncoder.encode("lang","UTF-8")+ "=" + URLEncoder.encode(lang,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is=httpURLConnection.getInputStream();
                is.close();

                return "register...."+lat+"see"+lang;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else
        if(method.equals("map"))
        {

            try {
                URL url = new URL("http://tracker.hol.es/getdata.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("id","UTF-8")+ "=" + URLEncoder.encode(id,"UTF-8")+"&"+
                URLEncoder.encode("lat","UTF-8")+ "=" + URLEncoder.encode(lat,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                        (inputStream,"iso-8859-1"));
                String response = "";
                String line = "";

                while ((line=bufferedReader.readLine())!=null)
                {

                    response = response + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
