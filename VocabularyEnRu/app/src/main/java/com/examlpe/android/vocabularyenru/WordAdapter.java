/*
package com.examlpe.android.vocabularyenru;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

*/
/**
 * Created by rik on 5/31/2018.
 *//*


public class WordAdapter extends ArrayAdapter<Word>{

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context,0, words);
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID wordTV
        TextView ruWordTV = (TextView) listItemView.findViewById(R.id.wordTV);
        // Get the russian word from the current Word object and
        // set this text on the name TextView
        ruWordTV.setText(currentWord.getmRuWord());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView enWordTV = (TextView) listItemView.findViewById(R.id.transtlationTV);
        // Get the russian word from the current Word object and
        // set this text on the name TextView
        enWordTV.setText(currentWord.getmEnWord());

    return listItemView;
    }
}
*/
