package com.mercari.mercaritest;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.net.URL;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by ssavdekar on 4/29/18.
 */

public class ImageDownloader {
    private ImageView view;

    public void setImage(String url, ImageView view) {
        this.view = view;
        new DownloadImage().execute(url);
    }

    // Download Image AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {
            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                URL url = new URL(imageURL.replace("http://", "https://"));
                InputStream in = url.openConnection().getInputStream();
                BufferedInputStream bis = new BufferedInputStream(in,1024*8);
                ByteArrayOutputStream out = new ByteArrayOutputStream();

                int len=0;
                byte[] buffer = new byte[1024];
                while((len = bis.read(buffer)) != -1){
                    out.write(buffer, 0, len);
                }
                out.close();
                bis.close();

                byte[] data = out.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            view.setImageBitmap(result);
        }
    }
}
