package com.example.asynctasktest;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by 李浩田 on 2016/3/21.
 */
public class MyAsyncTask extends AsyncTask<Void , Void , Void> {
    @Override
    protected Void doInBackground(Void... params) {
        Log.d("TAG", "doInBackground");
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("TAG", "onPreExecute");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("TAG", "onPostExecute");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.d("TAG", "onProgressUpdate");
    }
}
