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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("красный", "red"));
        words.add(new Word("зеленый", "green"));
        words.add(new Word("коричневый", "brown"));
        words.add(new Word("серый", "gray"));
        words.add(new Word("черный", "black"));
        words.add(new Word("белый", "white"));
        words.add(new Word("грязно желтый", "dusty yellow"));
        words.add(new Word("горчично желтый", "mustard yellow"));

        RAdapter itemsAdapter = new RAdapter(ColorsActivity.this,
                //   R.layout.list_item);
                words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}

