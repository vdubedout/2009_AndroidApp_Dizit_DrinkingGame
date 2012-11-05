package com.androidexperiment.dizit;

import android.os.Bundle;
import android.util.Log;

public class DixitGame extends DiceView{
	private static final String TAG = "Dixit";

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
		this.generalRulesId = R.string.rule_dixit_general;
		this.noRuleId = R.string.rule_dixit_nothing;
        
        createDixitRules();
        setTwoDicesView(this.generalRulesId);
	}
	
	/**
	 * Create the Dixit rules in the tabRules
	 *\/!\ Modify the strings, traduct it on the R.string and change the code below
	 */
	protected void createDixitRules(){
		for (int dice1 = 1; dice1 <=6; dice1++) {
			for(int dice2 = 1; dice2 <=6; dice2++){
				//Dixit
				if((dice1+dice2) == 7)setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_7));
				//Player rule
				if((dice1+dice2) == 9)setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_9));
				if((dice1+dice2) == 10)setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_10));
				if((dice1+dice2) == 11)setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_11));
				
				//Double
				if(dice1==dice2){
					if(dice1==6)setRule(dice1, dice1, getResources().getString(R.string.rule_dixit_double6));
					else setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_double));
					
				}
				
				//Pigeon Rule
				if(dice1==3 && dice2==3)
					setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_pigeon_double));
				else if (dice1==3 || dice2==3) {
					setRule(dice1, dice2,getResources().getString(R.string.rule_dixit_pigeon_simple));
				}				
				
				
				//New pigeon
				if((dice1==1&&dice2==2)||(dice1==2&&dice2==1))
					setRule(dice1,dice2,getResources().getString(R.string.rule_dixit_pigeon_new));
				
				//51
				if((dice1==1&&dice2==5)||(dice1==5&&dice2==1))
					setRule(dice1, dice2, getResources().getString(R.string.rule_dixit_51));
				
				
			}
		}
	}
}
