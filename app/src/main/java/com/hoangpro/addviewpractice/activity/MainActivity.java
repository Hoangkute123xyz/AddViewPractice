package com.hoangpro.addviewpractice.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.hoangpro.addviewpractice.R;
import com.hoangpro.addviewpractice.api.LessonAPI;
import com.hoangpro.addviewpractice.model.Lesson;
import com.hoangpro.addviewpractice.model.LessonObject;
import com.hoangpro.addviewpractice.morefunct.MyFunct;
import com.hoangpro.addviewpractice.myinterface.DataResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataResult, CompoundButton.OnCheckedChangeListener {

    private TableLayout tabParent;
    private ImageView[] imgAction;
    private LinearLayout[] linearChild;
    List<Lesson> list;
    private String URL = "http://heyj.eupgroup.net/resapi/lessons/listLessons?language=vn";
    private Switch swActive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list = new ArrayList<>();
        LessonAPI lessonAPI = new LessonAPI();
        lessonAPI.setDataResult(this);
        lessonAPI.execute(URL);
        swActive.setOnCheckedChangeListener(this);
    }

    private void initView() {
        tabParent = findViewById(R.id.tabParent);
        swActive = findViewById(R.id.swActive);
    }

    @Override
    public void onDataResult(Object object) {
        list = (List<Lesson>) object;
        if (list.size()>0){
            LessonObject lessonObject = new LessonObject();
            lessonObject.setLessons(list);
            MyFunct.saveListLessonIntoCache(this, new Gson().toJson(lessonObject));
        } else {
            LessonObject lessonObject = new Gson().fromJson(MyFunct.getListLessonFromCache(this), LessonObject.class);
            list=lessonObject.getLessons();
        }
        int currentIndexMap = 0;
        TableRow tableRow = new TableRow(this);
        setMaxCol(list);
        int colWidth = MyFunct.getScreenWidth() / MyFunct.maxColLesson - 48;
        imgAction = new ImageView[list.size()];
        linearChild = new LinearLayout[list.size()];
        Log.e("MaxCol", MyFunct.maxColLesson + "");
        for (int i = 0; i < list.size(); i++) {
            Lesson lesson = list.get(i);
            if (currentIndexMap != lesson.getIndexMap() || i == list.size() - 1) {
                tableRow.setGravity(Gravity.CENTER);
                tableRow.setLayoutParams(new TableLayout.LayoutParams());
                tabParent.addView(tableRow, new TableLayout.LayoutParams());
                tableRow = new TableRow(this);
                currentIndexMap = lesson.getIndexMap();
            }
            linearChild[i] = new LinearLayout(this);
            linearChild[i].setOrientation(LinearLayout.VERTICAL);
            linearChild[i].setGravity(Gravity.CENTER);
            linearChild[i].setBackgroundResource(R.drawable.bg_circler_hide);
            TableRow.LayoutParams params = new TableRow.LayoutParams(colWidth, colWidth);
            params.setMargins(8, 8, 8, 8);
            linearChild[i].setLayoutParams(params);

            imgAction[i] = new ImageView(this);
            Glide.with(this).load(lesson.getIconHidden()).into(imgAction[i]);
            imgAction[i].setLayoutParams(new LinearLayout.LayoutParams(colWidth - 128, colWidth - 128));

            linearChild[i].addView(imgAction[i]);
            tableRow.addView(linearChild[i]);
        }
    }
    private void activeHiden(){
        for(int i=0;i<list.size();i++){
            linearChild[i].setBackgroundResource(R.drawable.bg_circler_hide);
            Glide.with(this).load(list.get(i).getIconHidden()).into(imgAction[i]);
        }
    }
    private void activeShow(){
        for(int i=0;i<list.size();i++){
            linearChild[i].setBackgroundResource(R.drawable.bg_circler_show);
            Glide.with(this).load(list.get(i).getIconShow()).into(imgAction[i]);
        }
    }


    public void setMaxCol(List<Lesson> lessons) {
        int compare = 0, old = 0;
        for (Lesson lesson : lessons) {
            if (lesson.getIndexMap() == old) {
                compare++;
                if (compare > MyFunct.maxColLesson) {
                    MyFunct.maxColLesson = compare;
                }
            } else {
                compare = 1;
                old = lesson.getIndexMap();
                if (compare > MyFunct.maxColLesson) {
                    MyFunct.maxColLesson = compare;
                }
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            activeShow();
        }else{
            activeHiden();
        }
    }
}
