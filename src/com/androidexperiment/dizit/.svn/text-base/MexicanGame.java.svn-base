package com.androidexperiment.dizit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

public class MexicanGame  extends DiceView{
	private static final String TAG = "MexicanGame";
	private boolean flag[]= {false,false};

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
		this.generalRulesId = R.string.rule_mexican_general;
		this.noRuleId = R.string.rule_mexican_nothing;
        
        createDiceRules();
        setTwoDicesView(this.generalRulesId);
        dice[0].setClickable(false);
        dice[1].setClickable(false);
	}
	
	/**
	 * This method overrides the DiceView one to use methods that can block dices.
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.game_btn_launch:
			roll();
			dice[0].setClickable(true);
	        dice[1].setClickable(true);
			break;
		case R.id.game_dice1:
			setDiceFlag(1);
			break;
		case R.id.game_dice2:
			setDiceFlag(2);
			break;
		case R.id.game_btn_exit:
			finish();
			break;
			

		default:
			break;
		}
		
	}
	
	/**
	 * Method that permits to set the flag of the dice clicked.
	 * @param diceNumber number of the dice to lock or unlock
	 */
	protected void setDiceFlag(int diceNumber){
		if(flag[diceNumber-1]==false){
			ScaleAnimation lockAnim = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.lockdice);
			dice[diceNumber-1].setBackgroundColor(R.color.grey);
			dice[diceNumber-1].startAnimation(lockAnim);
			flag[diceNumber-1]=true;
		}
		else{
			ScaleAnimation unlockAnim = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.unlockdice);
			dice[diceNumber-1].setBackgroundColor(R.color.main_background);
			dice[diceNumber-1].startAnimation(unlockAnim);
			flag[diceNumber-1]=false;
		}
	}
	
	
	
	/**
	 * Method that returns if the dice is lock or unlock
	 * @param diceNumber Number of the dice to prompt if it can be launched
	 * @return true for a locked dice, false for an unlocked
	 */
	protected boolean getDiceFlag(int diceNumber){
		
		return flag[diceNumber-1];
	}
	
	@Override
	protected void roll(){
		
		
		
		gameText.setText("");
		
		for (int i = 0; i < 2; i++) {
			if(getDiceFlag(i+1)==false){
			diceSet.launch(2,i+1);
			dice[i].setImageResource(diceSet.getImage(diceSet.tabDiceValue[i]));
			dice[i].startAnimation(getAnimDice());}
		}
		
		
		gameText.setText(getRule(diceSet.tabDiceValue));
		gameText.startAnimation(getAnimText());
	}
	
	
	
	
	protected void createDiceRules(){
		for (int dice1 = 1; dice1 <=6; dice1++) {
			for(int dice2 = 1; dice2 <=6; dice2++){
				
				// Combination of dices
				if((dice1==2&&dice2==1)||(dice1==1&&dice2==2)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_mexican_21));
				}
				if((dice1==3&&dice2==1)||(dice1==1&&dice2==3)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_mexican_31));
				}
				
				//Doubles
				if(dice1==dice2) setRule(dice1, dice2, getResources().getString(R.string.rule_mexican_double));
				
			}
		}
	}
}
