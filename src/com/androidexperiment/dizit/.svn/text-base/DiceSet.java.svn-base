package com.androidexperiment.dizit;

import java.util.Random;
import android.util.Log;

/*
 * Class for a set of dices
 * 
 */
public class DiceSet {
	public static final  String TAG = "DiceSet";			//String for help in the debug
	public Integer tabDiceValue[];								//Number of dices, can be helpy later if you want to make an app with more dices
	public Integer tabRandom[][]=new Integer[2][36];			//First random tab (1,1,1,1,1,1,2,2,2,2,...)
	private int possibilities;
	private int numberOfDices;
	
	/**
	 * 
	 * @param numberOfDices	number of dices necessaries for the game
	 */
	public DiceSet(int numberOfDices){
		this.numberOfDices = numberOfDices;
		this.possibilities = (int) Math.pow(6, this.numberOfDices);
		this.tabDiceValue = new Integer[this.numberOfDices];	// construction of the number of dices
		this.tabRandom = createRandomTable(this.tabRandom);	// Contruction of the random table
		
		//Set up the first dice number
		this.tabDiceValue[0]=1;
		this.tabDiceValue[1]=1;

				
	}
	
	/**
	 * Creates a tab filled with all the possible combination of two dices
	 *  that permits to have a good random number of dices.
	 * @param tab	an empty tab with 2 dimensions
	 * @return tab	the tab completed with all the possible combination
	 */
	private Integer[][] createRandomTable(Integer tab[][]){
		int j=0;
		for (int i = 0; i < 36; i++) {
			if(i%6==0)j++;
			tab[0][i]=j;
			tab[1][i]=(i%6)+1;
		}
		return tab;
	}
	/**
	 * Method that launch the X dices and put the random number in the tab of dices
	 * @param numberOfDices Number of dices to launch
	 */
	public void launch(int numberOfDices)
	{
		int chiffre;
		Random rand = new Random();
		chiffre = rand.nextInt(this.possibilities);
		Log.d(TAG, "Appliquer dice 1 = " + tabRandom[0][chiffre]+" | dice 2 = "+tabRandom[1][chiffre]);
		tabDiceValue[0]=tabRandom[0][chiffre];
		tabDiceValue[1]=tabRandom[1][chiffre];
	}
	
	
	/**
	 * Method that launch the dice X and write it in the tabDiceValue
	 * @param numberOfDices number of dices to launch
	 * @param diceToLaunch	the dice to roll
	 */
	public void launch(int numberOfDices, int diceToLaunch){
		int chiffre;
		Random rand = new Random();
		chiffre = rand.nextInt(this.possibilities);
		Log.d(TAG, "Appliquer dice "+ (diceToLaunch-1) + " = " + tabRandom[diceToLaunch-1][chiffre]);
		tabDiceValue[diceToLaunch-1]=tabRandom[diceToLaunch-1][chiffre];
		
	}
	
	
	
	/**
	 * Method that permit to have the resource id for the dice we put in it
	 * @return int drawable id of the image of the dice
	 */
	public int getImage(int diceNumber){
		int imageId=0;
		switch (diceNumber) {
			case 1:
				imageId = R.drawable.number1;	
				break;
			case 2:
				imageId = R.drawable.number2;
				break;
			case 3:
				imageId = R.drawable.number3;
				break;
			case 4:
				imageId = R.drawable.number4;
				break;
			case 5:
				imageId = R.drawable.number5;
				break;
			case 6:
				imageId = R.drawable.number6;
				break;

		default:
			break;
		}
		
		return  imageId;
	}
	
	
}
