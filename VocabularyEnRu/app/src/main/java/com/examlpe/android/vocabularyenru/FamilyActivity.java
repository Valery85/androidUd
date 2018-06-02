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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("отец", "father"));
        words.add(new Word("мать", "mother"));
        words.add(new Word("сын", "son"));
        words.add(new Word("дочь", "daughter"));
        words.add(new Word("старший брат", "older brother"));
        words.add(new Word("младший брат", "younger brother"));
        words.add(new Word("старшая сестра", "older sister"));
        words.add(new Word("младшая сестра", "younger sister"));
        words.add(new Word("бабушка", "grandmother"));
        words.add(new Word("дедушка", "grandfather"));


        RAdapter itemsAdapter = new RAdapter(this,
                //   R.layout.list_item);
                words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
