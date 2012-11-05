package com.androidexperiment.dizit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

public class SeeRules extends Activity implements OnClickListener{
	private final static String TAG = "SeeRules";
	private int gameNumber;
	
	Button btnExit;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.showtext);
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);
        
        this.gameNumber = getIntent().getIntExtra(Dizit.GAME_NAME, Dizit.GAME_DIXIT);
          
        TextView titleRule = (TextView) this.findViewById(R.id.showtext_title);
        TextView textRule = (TextView) this.findViewById(R.id.showtext_text);
        btnExit = (Button) findViewById(R.id.showtext_btn_exit);
        btnExit.setOnClickListener(this);
        
        switch (this.gameNumber) {
		case Dizit.GAME_DICE:
			titleRule.setText(R.string.rule_dice_title);
			textRule.setText(R.string.rule_dice_general);			
			break;
		case Dizit.GAME_THREEMAN:
			titleRule.setText(R.string.rule_three_man_title);
			textRule.setText(R.string.rule_three_man_general);
			break;
		case Dizit.GAME_DIXIT:
			titleRule.setText(R.string.rule_dixit_title);
			textRule.setText(R.string.rule_dixit_general);
			break;
		case Dizit.GAME_MEXICALI:
			titleRule.setText(R.string.rule_mexicali_title);
			textRule.setText(R.string.rule_mexicali_general);
			break;
		case Dizit.GAME_MEXICAN:
			titleRule.setText(R.string.rule_mexican_title);
			textRule.setText(R.string.rule_mexican_general);
			break;
		default:
			break;
		}
        
        
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
