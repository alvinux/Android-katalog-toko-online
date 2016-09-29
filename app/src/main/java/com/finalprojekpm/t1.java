package com.finalprojekpm;

import com.finalprojekpm.R;

import android.app.Activity;
import android.app.AlertDialog;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.media.MediaPlayer;
import android.os.Bundle;

public class t1 extends Activity implements MediaPlayer.OnCompletionListener{

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		
	}
	   /** Called when the activity is first created. */
	
//	private ImageButton play;
//	private ImageButton pause;
//	private ImageButton stop;
//	private MediaPlayer mp;
//	private ImageView gambar;
//
	@Override 
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
        setContentView(R.layout.t1);
        
//        
//        play=(ImageButton)findViewById(R.id.play);
//		pause=(ImageButton)findViewById(R.id.pause);
//		stop=(ImageButton)findViewById(R.id.stop);
//		gambar=(ImageView)findViewById(R.id.gambar);
//		
//		gambar.setImageResource(R.drawable.bg);
//		
//        
//		
//		play.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				play();
//			}
//		});
//		
//		pause.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				pause();
//			}
//		});
//		
//		stop.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				stop();
//			}
//		});
//		
//		setup();
//		   
//		
//        
//	}
//	
//	@Override
//	public void onDestroy() {
//		super.onDestroy();
//		
//		if (stop.isEnabled()) {
//			stop();
//		}
//	}
//	
//	public void onCompletion(MediaPlayer mp) {
//		stop();
//	}
//	
//	
//	
//	private void play() {
//		mp.start();
//		
//		play.setEnabled(false);
//		pause.setEnabled(true);
//		stop.setEnabled(true);
//	}
//	
//	private void stop() {
//		mp.stop();
//		pause.setEnabled(false);
//		stop.setEnabled(false);
//		
//		try {
//			mp.prepare();
//			mp.seekTo(0);
//			play.setEnabled(true);
//		}
//		catch (Throwable t) {
//			goBlooey(t);
//		}
//	}
//	
//	private void pause() {
//		mp.pause();
//		
//		play.setEnabled(true);
//		pause.setEnabled(false);
//		stop.setEnabled(true);
//	}
//	
//	private void loadClip() {
//		try {
//			mp=MediaPlayer.create(this, R.raw.doajodoh);
//			mp.setOnCompletionListener(this);
//			
//		}
//		catch (Throwable t) {
//			goBlooey(t);
//		}
//	}
//	
//	
//	private void setup() {
//		loadClip();
//		play.setEnabled(true);
//		pause.setEnabled(false);
//		stop.setEnabled(false);
//	}
//	
//	private void goBlooey(Throwable t) {
//		AlertDialog.Builder builder=new AlertDialog.Builder(this);
//		
//		builder
//			.setTitle("Exception!")
//			.setMessage(t.toString())
//			.setPositiveButton("OK", null)
//			.show();
	}

    
    }
	

	
