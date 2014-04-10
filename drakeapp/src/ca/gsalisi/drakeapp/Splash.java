package ca.gsalisi.drakeapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drake_splash);
		
		Thread newthread = new Thread(){

			@Override
			public void run() {
				try{
					sleep(1000);
					startActivity(new Intent(Splash.this, MainActivity.class));
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					finish();
				}
			}
				
				
		};
		newthread.start();
	}


}
