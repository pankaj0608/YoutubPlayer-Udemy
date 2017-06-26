package com.example.pankaj.youtubplayer_udemy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends AppCompatActivity
implements YouTubePlayer.OnInitializedListener {

    private String GOOGLE_API_KEY = "AIzaSyA3ZGzoLNy_1qTDsQTNNDLYKlWmAFI78vc";
    private String YOUTUBE_VIDEO_ID = "oeRTyfAbA7c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        YouTubePlayerView youTubePlayerView
                = (YouTubePlayerView) findViewById(R.id.youtube_player);

        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean wasRstored) {

        Toast.makeText(this,
                "Initailised Youtube Player Success",
                Toast.LENGTH_LONG).show();

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRstored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener =
            new YouTubePlayer.PlayerStateChangeListener() {
                @Override
                public void onLoading() {

                }

                @Override
                public void onLoaded(String s) {

                }

                @Override
                public void onAdStarted() {

                }

                @Override
                public void onVideoStarted() {

                }

                @Override
                public void onVideoEnded() {

                }

                @Override
                public void onError(YouTubePlayer.ErrorReason errorReason) {

                }
            };

    private YouTubePlayer.PlaybackEventListener playbackEventListener =
                new YouTubePlayer.PlaybackEventListener() {
                    @Override
                    public void onPlaying() {

                    }

                    @Override
                    public void onPaused() {

                    }

                    @Override
                    public void onStopped() {

                    }

                    @Override
                    public void onBuffering(boolean b) {

                    }

                    @Override
                    public void onSeekTo(int i) {

                    }
                };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(this,
                "Initailised Youtube Player Failure",
                Toast.LENGTH_LONG).show();

    }
}
