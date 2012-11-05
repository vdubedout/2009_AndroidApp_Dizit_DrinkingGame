package com.androidexperiment.dizit;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Dizit extends Activity implements OnClickListener{
    private static final String TAG = "Dizit";
	
    public static final String GAME_NAME = "Name of the game";
	public static final int GAME_DICE = 0; 
	public static final int GAME_THREEMAN = 1;
	public static final int GAME_DIXIT = 2;
	public static final int GAME_MEXICALI = 3;
	public static final int GAME_MEXICAN = 4;
	public static final int GAME_MAYA = 5;
	
	// Components
	Button newButton;
    Button seeButton;
    Button aboutButton;
    Button exitButton;
    
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);

        
        // Declaration of the View of the buttons
        newButton = (Button) findViewById(R.id.main_btn_new);
        seeButton = (Button) findViewById(R.id.main_btn_see);
        aboutButton = (Button) findViewById(R.id.main_btn_about);
        exitButton = (Button) findViewById(R.id.main_btn_exit);
        
        newButton.setOnClickListener(this);
        seeButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }
    
    /**
     * 
     */
    @Override
    public void onClick(View v){
    	switch (v.getId()) {
		case R.id.main_btn_exit:
			finish();
			break;
		case R.id.main_btn_about:
			Intent i = new Intent(Dizit.this, About.class);
			startActivity(i);
			break;
		case R.id.main_btn_new:
			openNewGameDialog();
			break;
		case R.id.main_btn_see:
			openSeeRuleDialog();
			break;
		default:
			break;
		}
    }
    
    /**
     * Open a the new game Dialog that permits to choose which sort of game you want to play.
     * 
     * @see Dizit.onClick
     */
    private void openNewGameDialog(){
    	new AlertDialog.Builder(this)
    	.setTitle(R.string.newgame_title)
    	.setItems(R.array.games, 
    			new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				// TODO Auto-generated method stub
				startGame(i);
			}
		}).show();
    }
    
    /**
     * Open a the new game Dialog that permits to choose which sort of game you want to play.
     * 
     * @see Dizit.onClick
     */
    private void openSeeRuleDialog(){
    	new AlertDialog.Builder(this)
    	.setTitle(R.string.newgame_title)
    	.setItems(R.array.games, 
    			new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				// TODO Auto-generated method stub
				startRules(i);
			}
		}).show();
    }
    
    
    /**
     * Start the activity (with the good number of dices) of the game selected  that was clicked
     * 
     * @param	i	the number of the item clicked
     */
    private void startGame(int i){
    	Log.d(TAG, "Choose the game : "+i);
    	Intent intent;
    	switch (i) {
		case GAME_DICE:
			intent = new Intent(Dizit.this, DiceGame.class);
			startActivity(intent);
			break;
		case GAME_THREEMAN:
			intent = new Intent(Dizit.this, ThreeManGame.class);
			startActivity(intent);
			break;
		case GAME_DIXIT:
			intent = new Intent(Dizit.this, DixitGame.class);
			startActivity(intent);
			break;
		case GAME_MEXICALI:
			intent = new Intent(Dizit.this, MexicaliGame.class);
			startActivity(intent);
			break;
		case GAME_MEXICAN:
			intent = new Intent(Dizit.this, MexicanGame.class);
			startActivity(intent);
			break;

		default:
			break;
		}
    	
    }
    
    private void startRules(int i){
    	Log.d(TAG, "Choose the game : "+i);
    	Intent intent;
    	switch (i) {
		case GAME_DICE:
			intent = new Intent(Dizit.this, SeeRules.class);
			intent.putExtra(GAME_NAME, i);
			startActivity(intent);
			break;
		case GAME_THREEMAN:
			intent = new Intent(Dizit.this, SeeRules.class);
			intent.putExtra(GAME_NAME, i);
			startActivity(intent);
			break;
		case GAME_DIXIT:
			intent = new Intent(Dizit.this, SeeRules.class);
			intent.putExtra(GAME_NAME, i);
			startActivity(intent);
			break;
		case GAME_MEXICALI:
			intent = new Intent(Dizit.this, SeeRules.class);
			intent.putExtra(GAME_NAME, i);
			startActivity(intent);
			break;
		case GAME_MEXICAN:
			intent = new Intent(Dizit.this, SeeRules.class);
			intent.putExtra(GAME_NAME, i);
			startActivity(intent);
			break;

		default:
			break;
		}
    	
    }
}













