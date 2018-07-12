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

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        mediaPlayer.pause();
                        // go to start of the word
                        mediaPlayer.seekTo(0);
                    }
                    else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        mediaPlayer.start();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        releaseMediaPlayer();
                    }

                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create AudioManager for next managing audio focus
        mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Куда собираешься?", "Where are you going?", R.raw.phrase_where_are_you_going));
        words.add(new Word("Как тебя зовут", "What is you name", R.raw.phrase_what_is_your_name));
        words.add(new Word("Меня зовут ...", "My name is ...", R.raw.phrase_my_name_is));
        words.add(new Word("Как ты себя чувствуешь?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Чувствую себя хорошо", "I'm feeling good", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Ты идешь?", "Are you coming?", R.raw.phrase_are_you_coming));
        words.add(new Word("Да, я иду", "Yes, I’m coming.", R.raw.phrase_im_coming));
        words.add(new Word("Пошли", "Let’s go.", R.raw.phrase_lets_go));
        words.add(new Word("Иди сюда", "Come here", R.raw.phrase_come_here));


        RAdapter itemsAdapter = new RAdapter(this,
                //   R.layout.list_item);
                words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request  focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getmAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }}
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //When the activity is stopped release the media player resources
        releaseMediaPlayer();
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

            //Abandon audio focus, AudioFocusChangeListener will be unregistered
            // no more callback from it will be sent.
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
