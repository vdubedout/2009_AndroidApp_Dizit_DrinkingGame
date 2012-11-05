package com.androidexperiment.dizit;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

public class About extends Activity implements OnClickListener{
	TextView title;
	TextView text;
	Button btnExit;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showtext);
		getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);
		
		title = (TextView) findViewById(R.id.showtext_title);
		title.setText(R.string.alert_title);
		
		text = (TextView) findViewById(R.id.showtext_text);
		text.setText(R.string.alert_text);
		Linkify.addLinks(text, Linkify.ALL);
		
		btnExit = (Button) findViewById(R.id.showtext_btn_exit);
        btnExit.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.showtext_btn_exit:
			this.finish();
			break;

		default:
			break;
		}
		
	}
}
