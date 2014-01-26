package com.Master_Zangetsu.fireflygame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class JoinTheTeam extends Activity implements OnClickListener {
	
	TextView title;
	TextView content;
	
	String plea = "We need help writing the story for this game." + "\n" + "\n" + "If you have writing experience, and are interested in helping to speed up the release of the next chapters, please email us" + "\n" + "\n" + "To apply, please enter your name and age along with links to, or copies of any previous work done, along with any additional information you think would be useful and send to the following address" + "\n" + "\n" + "\n" + "\n" + "Master.Zangetsu@googlemail.com";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advert_activity);
		
		title = (TextView) findViewById(R.id.title);
		content = (TextView) findViewById(R.id.content);
		
		content.setText(plea);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
		

}
