package com.example.dmm535r;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class GameScreen extends AppCompatActivity   {

    String ArrayName [] = {"Music","Play","Sound","Setting"};

    private ImageView game_sett, game_music,game_sound,game_play;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);


        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.plus_gamee, R.drawable.minus_gamee)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.music_gamee)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.play_gamee)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.soundon)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.game_set)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if (index==1) {
                            Thread timer = new Thread() {
                                public void run() {
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    finally {
                                        Intent intent = new Intent(GameScreen.this,PlayScreen.class);

                                        startActivity(intent);
                                        finish();

                                    }
                                }

                            };
                            timer.start();
                            }

                            else if (index==2 && player==null){player = MediaPlayer.create(GameScreen.this, R.raw.musicback);
                            player.start();}

                    }

                });

    }

}
