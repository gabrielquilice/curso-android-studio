package com.cursoandroid.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_FULLSCREEN );

        getSupportActionBar().hide();

        videoView = findViewById(R.id.videoView);

        //Define quais serão os botões que aparecerão na execução
        videoView.setMediaController(new MediaController(this));

        //Define em qual local está o vídeo que será executado
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoView.start();

    }
}