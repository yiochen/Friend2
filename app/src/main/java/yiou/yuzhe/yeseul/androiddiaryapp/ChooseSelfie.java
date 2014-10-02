package yiou.yuzhe.yeseul.androiddiaryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class ChooseSelfie extends Activity {
	public static final String PICK_SELFIE="pick_selfie";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_selfie);
		
		GridView g = (GridView) findViewById(R.id.selfies);
		GridAdapter gridAdapter=new GridAdapter(this);
		
		g.setAdapter(gridAdapter);
		
		g.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View v, int pos, long id)
			{
				//do stuff here
				Toast.makeText(ChooseSelfie.this, "" + pos,  Toast.LENGTH_SHORT).show();
				Intent intent=new Intent();
				intent.putExtra(PICK_SELFIE, GridAdapter.mThumbIds[pos]);
				setResult(RESULT_OK,intent);
				finish();
			}
		});
	}

}
