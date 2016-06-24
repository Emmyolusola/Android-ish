package com.emmyolusola.tableassessment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Emmyolusola on 4/25/2016.
 */
public class CustomAdapter extends ArrayAdapter{

    Context _context;
    int layout;
    List<TapeQuiz> tapeQuizList;

    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        _context = context;
        layout = resource;
        tapeQuizList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView titleTV = (TextView)convertView.findViewById(R.id.text1);

        TextView numberTV = (TextView)convertView.findViewById(R.id.text2);

        TapeQuiz tapeQuiz = tapeQuizList.get(position);
        titleTV.setText(tapeQuiz.getTapeTitle());
        numberTV.setText(tapeQuiz.getTapeNumber());

        return convertView;
    }
}
