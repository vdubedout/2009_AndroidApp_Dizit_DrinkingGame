package com.androidexperiment.dizit;

import android.os.Bundle;
import android.util.Log;

public class DiceGame extends DiceView {
	private static final String TAG = "ThreeManGame";
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
		this.generalRulesId = R.string.rule_dice_general;
		this.noRuleId = R.string.rule_dice_nothing;
        
        createDiceRules();
        setTwoDicesView(this.generalRulesId);
	}
	
	protected void createDiceRules(){
		for (int dice1 = 1; dice1 <=6; dice1++) {
			for(int dice2 = 1; dice2 <=6; dice2++){
				//sum of two dices
				if(((dice1+dice2) == 6)&&(dice1!=dice2))setRule(dice1, dice2, getResources().getString(R.string.rule_dice_6sum));
				
				
				//Double dices
				if(dice1==dice2){
					if(dice1==1||dice1==6)
					setRule(dice1, dice2, getResources().getString(R.string.rule_dice_killer));
					else if (dice1==3) setRule(dice1, dice2, getResources().getString(R.string.rule_dice_penalty));
					else setRule(dice1, dice2, getResources().getString(R.string.rule_dice_double));
				}
				
				// Combination of dices
				if((dice1==6&&dice2!=6)||(dice1!=6&&dice2==6)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_dice_6dice));
				}
			}
		}
	}
	
	
	
}
