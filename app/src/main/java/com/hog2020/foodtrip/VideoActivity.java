package com.hog2020.foodtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends AppCompatActivity {

    YouTubePlayerFragment youTubePlayerFragment1;
    YouTubePlayerFragment youTubePlayerFragment2;
    YouTubePlayerFragment youTubePlayerFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        FragmentManager fragmentManager = getFragmentManager();
        youTubePlayerFragment1= (YouTubePlayerFragment) fragmentManager.findFragmentById(R.id.youTubeFragment1);

        youTubePlayerFragment1.initialize("First", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("KwC3x6epfX4");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        youTubePlayerFragment2=(YouTubePlayerFragment) fragmentManager.findFragmentById(R.id.youTubeFragment2);
        youTubePlayerFragment2.initialize("Second", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("QITFVOeVf4Q");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        youTubePlayerFragment3= (YouTubePlayerFragment) fragmentManager.findFragmentById(R.id.youTubeFragment3);
        youTubePlayerFragment3.initialize("Third", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("DjFD-7tHGxY");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}