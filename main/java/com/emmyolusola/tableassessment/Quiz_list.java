package com.emmyolusola.tableassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quiz_list extends AppCompatActivity {

    static List<TapeQuiz> tapeList = new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        ListView lv = (ListView)findViewById(R.id.listView);
        customAdapter = new CustomAdapter(Quiz_list.this, R.layout.list_item, tapeList);
        lv.setAdapter(customAdapter);

        String[] title = getResources().getStringArray(R.array.quiz_topic);
        String[] number = getResources().getStringArray(R.array.number);

//        for (int i = 0; i < title.length; i++){
//            titl = title[i];
//            numb = number[i];
//        }

//        DBAdadpter dbAdadpter = new DBAdadpter(this);
//        dbAdadpter.open();
//        String title1 = dbAdadpter.getTitle();
//        String number1  = dbAdadpter.getNumber();
//        dbAdadpter.close();

        for (int i = 0; i < title.length; i++){
            tapeList.add(new TapeQuiz(title[i], number[i]));
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TapeQuiz quiz = tapeList.get(position);
//                String hello = (String) parent.getItemAtPosition(quizListPosition);
//                Toast.makeText(Quiz_list.this, String.valueOf(quizListPosition), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Quiz_list.this, Questions.class);
                intent.putExtra("quizListPosition", position);
                startActivity(intent);
            }
        });
    }
}
