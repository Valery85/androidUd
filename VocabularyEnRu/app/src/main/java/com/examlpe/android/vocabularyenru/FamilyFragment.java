package com.examlpe.android.vocabularyenru;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {
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

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // create AudioManager for next managing audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("отец", "father", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("мать", "mother", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("сын", "son", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("дочь", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("старший брат", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("младший брат", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("старшая сестра", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("младшая сестра", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("бабушка", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("дедушка", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));


        RAdapter itemsAdapter = new RAdapter(getActivity(),
                //   R.layout.list_item);
                words, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

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
                    MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getmAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }}
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        //When the activity is stopped release the media player resources
        releaseMediaPlayer();
    }

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
