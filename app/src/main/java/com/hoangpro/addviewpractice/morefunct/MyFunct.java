package com.hoangpro.addviewpractice.morefunct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public class MyFunct {
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    public static int maxColLesson=0;

    private static final String SHARED_NAME="lesson_data";
    public static void saveListLessonIntoCache(Context context,String json){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("list_json",json);
        editor.apply();
    }

    public static String getListLessonFromCache(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("list_json", "");
    }
}
