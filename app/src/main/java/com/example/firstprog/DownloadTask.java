package com.example.firstprog;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();

    ProgressBar mProgressBar;

    public DownloadTask(ProgressBar progressBar){
        mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... url) {

        for (int i=1;i<100;i++) {
            try {
                Thread.sleep(150);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.i(TAG,"downloading from "+ url[0]);

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... percentDownloaded) {
        super.onProgressUpdate(percentDownloaded);
        mProgressBar.setProgress(percentDownloaded[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mProgressBar.setVisibility(View.INVISIBLE);
        Log.i(TAG, "onPostExecute: Downloaded");
    }
}
