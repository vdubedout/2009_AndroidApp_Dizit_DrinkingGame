package com.androidexperiment.dizit;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class DiceView extends Activity implements OnClickListener{
	private static final String TAG = "DiceGame";
	
	protected DiceSet diceSet;
	protected TextView gameTitle;
	protected TextView gameText;
	protected ImageView dice[];
	protected int numberOfDices;
	protected int gameNumber;
	
	protected String tabRules[][] = new String[6][6]; 
	protected int generalRulesId;
	protected int noRuleId;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
  }
	/**
	 * Set the view for a Two Dice game
	 * @param generalRulesId R.string. id of the general Rules Id
	 */
	public void setTwoDicesView(int generalRulesId){
		setContentView(R.layout.view_twodice);
		
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);
        
		this.numberOfDices = 2; 
    	this.dice	= new ImageView[this.numberOfDices];
    	this.diceSet = new DiceSet(this.numberOfDices);
		
    	// set Views 
		View launchButton = this.findViewById(R.id.game_btn_launch);
		View exitButton = this.findViewById(R.id.game_btn_exit);
		
		gameText = (TextView) this.findViewById(R.id.game_text);
		gameText.setText(generalRulesId);
		
		dice[0] = (ImageView) this.findViewById(R.id.game_dice1);
		dice[1]	= (ImageView) this.findViewById(R.id.game_dice2);
		dice[0].setImageResource(R.drawable.number1);
		dice[1].setImageResource(R.drawable.number1);
		// Set onClick
		launchButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
		
		dice[0].setOnClickListener(this);
		dice[1].setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.game_btn_launch:
		case R.id.game_dice1:
		case R.id.game_dice2:
			roll();
			break;
		case R.id.game_btn_exit:
			finish();
			break;
		default:
			break;
		}
		
	}
	
	
	protected void roll(){
		
		diceSet.launch(2);
		Log.d(TAG, "diceSet.launch :"+ diceSet.tabDiceValue[0]+"|" + diceSet.tabDiceValue[1]);
		gameText.setText("");
		
		for (int i = 0; i < 2; i++) {
			dice[i].setImageResource(diceSet.getImage(diceSet.tabDiceValue[i]));
			dice[i].startAnimation(getAnimDice());
		}
		
		
		gameText.setText(getRule(diceSet.tabDiceValue));
		gameText.startAnimation(getAnimText());
	}
	
	/**
	 * Set and return the animation set for the dice animation (scale + rotate)
	 * @return AnimationSet Return the animationSet with a scale + rotate
	 */
	protected AnimationSet getAnimDice(){
		AnimationSet animSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.rolldice);
		
		
		return animSet;
	}
	
	/**
	 * Set and return the animation set for the text animation (scale)
	 * @return scaleAnimation Return the scale animation for the text
	 */
	protected ScaleAnimation getAnimText(){
		ScaleAnimation animText = new ScaleAnimation(0, 1, 0, 1,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animText.setStartOffset(10);
		animText.setDuration(1000);
		animText.setFillAfter(true);
		
		return animText;
	}
			
	
	/**
	 *  Set the rule given in "text" param for the two dices combination.
	 *  Write the rule in the tabRules of the class.
	 * 
	 * @param dice1	number of the dice 1
	 * @param dice2 number of the dice 2
	 * @param text	text of the rule
	 */
	protected void setRule(int dice1, int dice2, String text)
	{
		if (this.tabRules[dice1-1][dice2-1]==null)this.tabRules[dice1-1][dice2-1]=text;
		else this.tabRules[dice1-1][dice2-1] = this.tabRules[dice1-1][dice2-1] + " \n" +text;
		Log.d("tabRule", "dice1 : "+dice1+" | dice2 : "+dice2+" | texte : "+this.tabRules[dice1-1][dice2-1]);
		
	}
	
	/**
	 * Return the rule of two dices combination.
	 * @param dice[] array of the dice's numbers 
	 * @return String text of the rule to apply
	 */
	public String getRule(Integer dice[]){
		return (this.tabRules[dice[0]-1][dice[1]-1]==null)?getResources().getString(this.noRuleId):this.tabRules[dice[0]-1][dice[1]-1];
	}
	
	
	
	
}
