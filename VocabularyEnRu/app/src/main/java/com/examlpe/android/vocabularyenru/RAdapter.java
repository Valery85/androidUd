package com.examlpe.android.vocabularyenru;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link RAdapter} is a {@link ArrayAdapter} that can make the layout for each list
 * based on list of {@link Word} object
 */

public class RAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = RAdapter.class.getSimpleName();

    /**
     * Custom constructor
     * contex is used to inflate the layout file for each item, list is the
     * data we want to populate into ListView layout.
     *
     * @param context   The current context. Used to inflate the layout file
     *
     * resource id argument is 0 because don't need to evoke creation of layout by
     * super class. It will be created in getView().
     *
     * @param wordsList List of Word objects to display in the list
     */

    public RAdapter(@NonNull Activity context, ArrayList<Word> wordsList) {
        super(context, 0, wordsList);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView ...)
     *
     * @param position    position in the list of data ( in wordList) that should be displayed in
     *                    the list item view.
     * @param convertView The recycled view to populate
     * @param parent      The parent view that is used for inflation. List items will be
     *                    added in this ViewGroup as children. Here will be ListView.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //    Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID ruWord
        TextView ruWordTV = (TextView) listItemView.findViewById(R.id.ruWordTV);

        // Get the russian word (mRuWord) from the current Word object and
        //set this text on the ruWord TextView

        ruWordTV.setText(currentWord.getmRuWord());

        TextView enWordTV = (TextView) listItemView.findViewById(R.id.enWordTV);
        enWordTV.setText(currentWord.getmEnWord());

        ImageView wordImageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        wordImageView.setImageResource(currentWord.getmImageResourceId());

        return listItemView;
    }
}
