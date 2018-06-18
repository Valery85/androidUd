/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.examlpe.android.vocabularyenru;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

/*        // Create array of words (numbers)
        String [] words = new String [10];
        words[0] = "one";
        words[1] = "two";
        words[2] = "three";
        words[3] = "four";
        words[4] = "five";
        words[5] = "six";
        words[6] = "seven";
        words[7] = "eight";
        words[8] = "nine";
        words[9] = "ten";

        for (int i=0; i<10; i++)
        {
            Log.v("NumberActivty", "Word at index " + i + ": " + words[i] );
        }*/

       final ArrayList <Word> words = new ArrayList<Word>();
        words.add(new Word("один", "one", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("два", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("три", "three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("четыре", "four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("пять", "five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("шесть", "six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("семь", "seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("восем", "eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("девять", "nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("десять", "ten", R.drawable.number_ten, R.raw.number_ten));


//    LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);

//    int sizeWords = words.size();
//    int count = 0;
//    while (count < sizeWords){
//        TextView wordView = new TextView(this);
//        wordView.setText(words.get(count));
//        rootView.addView(wordView);
//        count++;
//    }
//        for (int count=0; count<words.size(); count++){
//            TextView wordView = new TextView(NumbersActivity.this);
//            wordView.setText(words.get(count));
//            rootView.addView(wordView);
//        }

        RAdapter itemsAdapter = new RAdapter(NumbersActivity.this,
             //   R.layout.list_item);
                words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getmAudioResourceId());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
