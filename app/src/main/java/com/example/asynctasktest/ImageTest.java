package com.example.asynctasktest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * Created by 李浩田 on 2016/3/21.
 */
public class ImageTest extends Activity {

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private  static String URL=
            "https://pic1.zhimg.com/37366e6b88aed415069e6a5f2b66b8b8_b.jpg";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        mImageView= (ImageView) findViewById(R.id.image);
        mProgressBar= (ProgressBar) findViewById(R.id.progressbar);


        new MyAsyncTask().execute(URL);

    }



    class MyAsyncTask extends AsyncTask<String , Void , Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mProgressBar.setVisibility(View.GONE);
            mImageView.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            Bitmap bitmap=null;
            URLConnection connection;
            InputStream is;
            try {

                connection=new URL(url).openConnection();
                is=connection.getInputStream();
                BufferedInputStream bis=new BufferedInputStream(is);
                Thread.sleep(3000);
                bitmap= BitmapFactory.decodeStream(bis);
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return bitmap;
        }

    }
}
