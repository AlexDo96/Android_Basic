package com.example.administrator.demo3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int UPDATE_FREQUENCY = 500;
    int STEP_VALUE = 4000;
    TextView tv_fileduocchon;
    SeekBar seekbar;
    MediaPlayer player;
    ImageButton bt_play,bt_prev,bt_next;
    ListView lv;
    boolean da_play = true;
    String filehientai = "";
    boolean dichuyenseekbar = false;
    private final Handler handler = new Handler();
    Runnable updatePositionRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_fileduocchon = (TextView) findViewById(R.id.selectedfile);
        bt_play = (ImageButton) findViewById(R.id.play);
        bt_next = (ImageButton) findViewById(R.id.next);
        bt_prev = (ImageButton) findViewById(R.id.prev);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        lv = (ListView) findViewById(R.id.list);


        ContentResolver ctr = this.getContentResolver();
        Cursor c = ctr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);


        MyAdapter adapter = new MyAdapter(MainActivity.this, R.layout.one_item, c);
        lv.setAdapter(adapter);

        player = new MediaPlayer();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                filehientai = (String) view.getTag();
                Toast.makeText(MainActivity.this, filehientai, Toast.LENGTH_SHORT).show();
                batdauphatnhac(filehientai);
            }


        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (dichuyenseekbar == true)
                    player.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                dichuyenseekbar = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                dichuyenseekbar = false;
            }
        });

        updatePositionRunnable=new Runnable() {
            @Override
            public void run() {
                updatePosition();
            }
        };

        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying())//dang phat
                {
                    handler.removeCallbacks(updatePositionRunnable);
                    player.pause();
                    bt_play.setImageResource(android.R.drawable.ic_media_play);
                } else//dang pause
                {
                    if (da_play == true)//dang chay thi chay tiep
                    {
                        player.start();
                        bt_play.setImageResource(android.R.drawable.ic_media_pause);
                        updatePosition();
                    } else //chua chay ma
                    {
                        batdauphatnhac(filehientai);
                    }
                }
            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seekto = player.getCurrentPosition() + STEP_VALUE;

                if(seekto >player.getDuration())
                    seekto = player.getDuration();
                player.pause();
                player.seekTo(seekto);
                player.start();
                updatePosition();
            }
        });

        bt_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seekto = player.getCurrentPosition() - STEP_VALUE;
                if(seekto <0)
                    seekto = 0;
                player.pause();
                player.seekTo(seekto);
                player.start();
                updatePosition();
            }
        });

        //tang giam am luong
        /*AudioManager audioManager =
                (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);*/
    }

    private void updatePosition(){
        handler.removeCallbacks(updatePositionRunnable);
        seekbar.setProgress(player.getCurrentPosition());
        handler.postDelayed(updatePositionRunnable, UPDATE_FREQUENCY);
    }


    private void batdauphatnhac(String filehientai) {
        tv_fileduocchon.setText(filehientai);
        seekbar.setProgress(0);
        player.stop();
        player.reset();
        try{
            player.setDataSource(filehientai);
            player.prepare();
            player.start();
        }catch (Exception e)
        {

        }
        updatePosition();
        seekbar.setMax(player.getDuration());
        bt_play.setImageResource(android.R.drawable.ic_media_pause);
        da_play=true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
        player.reset();
        player.release();
        player = null;
        handler.removeCallbacks(updatePositionRunnable);
    }


}
