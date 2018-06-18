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

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("красный", "red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("зеленый", "green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("коричневый", "brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("серый", "gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("черный", "black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("белый", "white", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("грязно желтый", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("горчично желтый", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("желтый", "yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        RAdapter itemsAdapter = new RAdapter(ColorsActivity.this,
                //   R.layout.list_item);
                words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        // set up listener for every item of the listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                mediaPlayer = MediaPlayer.create(ColorsActivity.this, words.get(position).getmAudioResourceId());
                mediaPlayer.start();
            }
        });




    }
}

