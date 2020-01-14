package com.hoangpro.addviewpractice.api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.hoangpro.addviewpractice.model.Lesson;
import com.hoangpro.addviewpractice.model.LessonObject;
import com.hoangpro.addviewpractice.myinterface.DataResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LessonAPI extends AsyncTask<String, Void, List<Lesson>> {
    private DataResult dataResult;

    public void setDataResult(DataResult dataResult) {
        this.dataResult = dataResult;
    }

    OkHttpClient client = new OkHttpClient.Builder()
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build();

    @Override
    protected List<Lesson> doInBackground(String... strings) {
        List<Lesson> list = new ArrayList<>();
        Request.Builder builder = new Request.Builder();
        builder.url(strings[0]);
        Request request = builder.build();
        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            LessonObject object = new Gson().fromJson(json, LessonObject.class);
            list.addAll(object.getLessons());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<Lesson> lessons) {
        dataResult.onDataResult(lessons);
        super.onPostExecute(lessons);
    }
}
