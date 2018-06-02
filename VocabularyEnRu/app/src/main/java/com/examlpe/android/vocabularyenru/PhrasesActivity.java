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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Куда собираешься?", "Where are you going?"));
        words.add(new Word("Как тебя зовут", "What is you name"));
        words.add(new Word("Меня зовут ...", "My name is ..."));
        words.add(new Word("Как ты себя чувствуешь?", "How are you feeling?"));
        words.add(new Word("Чувствую себя хорошо", "I'm feeling good"));
        words.add(new Word("Ты идешь?", "Are you coming?"));
        words.add(new Word("Да, я иду", "Yes, I’m coming."));
        words.add(new Word("Пошли", "Let’s go."));
        words.add(new Word("Иди сюда", "Come here"));


        RAdapter itemsAdapter = new RAdapter(this,
                //   R.layout.list_item);
                words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
