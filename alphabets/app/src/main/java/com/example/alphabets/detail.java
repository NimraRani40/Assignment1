package com.example.alphabets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity {
    MediaPlayer player;
    String music;
    ImageView myImg;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        myImg=findViewById(R.id.myimage);
        myText=findViewById(R.id.myTitle);
        Intent intent = getIntent();
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("images");
        String title = intent.getStringExtra("title");
        music = intent.getStringExtra("desc");
        myImg.setImageResource(pic);
        myText.setText(title);
    }
public void play(View v)
{
    int sound_id = this.getResources().getIdentifier(music, "raw",
            this.getPackageName());
        if (player == null){
            player=MediaPlayer.create( this,sound_id);
            player.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopplayer();
                }
            } );
        }
        player.start();
}
public void pause(View v)
{
    if (player != null)
    {
        player.pause();
    }
}
public void stop(View v)
{
       stopplayer();
}
    private void stopplayer()
    {
        if (player != null)
        {
            player.release();
            player=null;
            Toast.makeText(this,"Media Palyer Released",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopplayer();
    }

    protected void OnStop(){
        super.onStop();
        stopplayer();
    }

}
