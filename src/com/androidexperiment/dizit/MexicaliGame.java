package com.androidexperiment.dizit;

import android.os.Bundle;
import android.util.Log;

public class MexicaliGame extends DiceView{
	private static final String TAG = "MexicaliGame";
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
		this.generalRulesId = R.string.rule_mexicali_general;
		this.noRuleId = R.string.rule_mexicali_nothing;
        
        createDiceRules();
        setTwoDicesView(this.generalRulesId);
	}
	
	protected void createDiceRules(){
		for (int dice1 = 1; dice1 <=6; dice1++) {
			for(int dice2 = 1; dice2 <=6; dice2++){
				
				// Combination of dices
				if((dice1==2&&dice2==1)||(dice1==1&&dice2==2)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_mexicali_21));
				}
				if((dice1==3&&dice2==1)||(dice1==1&&dice2==3)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_mexicali_31));
				}
				if((dice1==2&&dice2==3)||(dice1==3&&dice2==2)){
					setRule(dice1, dice2, getResources().getString(R.string.rule_mexicali_32));
				}
				
			}
		}
	}
}
