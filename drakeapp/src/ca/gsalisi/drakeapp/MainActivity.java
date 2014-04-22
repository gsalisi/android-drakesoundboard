package ca.gsalisi.drakeapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {
	
	private MediaPlayer mPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageButton btn = (ImageButton) findViewById(R.id.btnworst);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnownit);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnitsyours);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnmofugga);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnthemotion);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btncomethru);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnigetit);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnneva);
		btn.setOnClickListener(this);
		btn = (ImageButton) findViewById(R.id.btnstarted);
		btn.setOnClickListener(this);
		btn= (ImageButton) findViewById(R.id.btnwhat);
		btn.setOnClickListener(this);

	}
	public void onClick(View v) {
		
		int id = v.getId();
		
		if(mPlayer != null){
			if(mPlayer.isPlaying()){
				mPlayer.stop();
				mPlayer.release();
			}
		}
		
		switch( id ){
			case R.id.btnworst:
				mPlayer = MediaPlayer.create(this, R.raw.worst);
				break;
			case R.id.btnownit:
				mPlayer = MediaPlayer.create(this, R.raw.ownit);
				break;
			case R.id.btnitsyours:
				mPlayer = MediaPlayer.create(this, R.raw.itsyours);
				break;
			case R.id.btnmofugga:
				mPlayer = MediaPlayer.create(this, R.raw.mofugga);
				break;
			case R.id.btnthemotion:
				mPlayer = MediaPlayer.create(this, R.raw.motion);
				break;
			case R.id.btncomethru:
				mPlayer = MediaPlayer.create(this, R.raw.comethru);
				break;
			case R.id.btnigetit:
				mPlayer = MediaPlayer.create(this, R.raw.igetit);
				break;
			case R.id.btnneva:
				mPlayer= MediaPlayer.create(this, R.raw.neva);
				break;
			case R.id.btnstarted:
				mPlayer = MediaPlayer.create(this, R.raw.started);
				break;
			case R.id.btnwhat:
				mPlayer = MediaPlayer.create(this, R.raw.whatsup);
				break;
		}
		mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mPlayer.setOnPreparedListener(new OnPreparedListener(){

			@Override
			public void onPrepared(MediaPlayer arg0) {
				// TODO Auto-generated method stub
				mPlayer.start();
				
			}
		});
		mPlayer.setOnCompletionListener(new OnCompletionListener(){

			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
				
			}});


		
		
	}
	
	@Override
	public void onPause(){
		super.onPause();
		mPlayer.stop();
		mPlayer.release();
	}
	@Override
	public void onResume(){
		super.onResume();
		try{
			mPlayer.reset();
		}catch(Exception e){
			
		}
	}

}
