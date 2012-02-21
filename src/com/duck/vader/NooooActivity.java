package com.duck.vader;

import com.duck.vader.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class NooooActivity extends Activity implements OnCheckedChangeListener {
	
	ToggleButton no;
	MediaPlayer play;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        no = (ToggleButton)findViewById(R.id.buttonNo);
        no.setChecked(false);
        no.setOnCheckedChangeListener(this);
        play = MediaPlayer.create(NooooActivity.this,R.raw.noo);
        play.setOnCompletionListener(new OnCompletionListener() {
			
			public void onCompletion(MediaPlayer mp) {
				no.setChecked(false);
			}
		});
           
        }

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if(play!=null)
		play.release();
		this.finish();
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_MENU) 
	        Toast.makeText(this, "Created by Douglas (inspired by http://nooooooooooooooo.com/)", Toast.LENGTH_LONG).show();
	    if(keyCode == KeyEvent.KEYCODE_BACK)
	    	onBackPressed();
	    
	    return true;
	    }

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(!play.isPlaying() && isChecked){
			play.start();
		}
		else{
			play.stop();
			play.release();
			play = MediaPlayer.create(NooooActivity.this,R.raw.noo);
		}
	}
	
}