package com.androidexperiment.dizit;

import android.os.Bundle;
import android.util.Log;

public class ThreeManGame extends DiceView {
	private static final String TAG = "ThreeManGame";
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
		this.generalRulesId = R.string.rule_three_man_general;
		this.noRuleId = R.string.rule_three_man_nothing;
        
        createThreeManRules();
        setTwoDicesView(this.generalRulesId);

      
     }
	
	
	/**
	 * Create the Three Man rules in the tabRules	
	 */
	private void createThreeManRules(){
		for (int dice1 = 1; dice1 <=6; dice1++) {
			for(int dice2 = 1; dice2 <=6; dice2++){
				//sum of two dices
				if((dice1+dice2) == 3)setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_pigeon_simple));
				if((dice1+dice2) == 7)setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_7));
				if((dice1+dice2) == 9)setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_9));
				if((dice1+dice2) == 11)setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_11));
				
				//Double dices
				if(dice1==dice2){
					setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_doubles));
				}
				
				// Combination of dices
				if((dice1==1&&dice2==5)||(dice1==5&&dice2==1)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_51));
				}
				if((dice1==1&&dice2==4)||(dice1==4&&dice2==1)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_41));
				}
				
				//Pigeon Rule
				if(((dice1==3)&&(dice2!=3))||((dice1!=3)&&(dice2==3)))
				setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_pigeon_simple));
				if(dice1==3 && dice2==3)setRule(dice1, dice2, getResources().getString(R.string.rule_three_man_pigeon_double));
			}
		}
	}
}
