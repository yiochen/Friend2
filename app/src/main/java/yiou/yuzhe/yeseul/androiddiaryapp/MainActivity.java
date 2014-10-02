package yiou.yuzhe.yeseul.androiddiaryapp;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private String pass;
	// Hello, this is the change made by yiou
	public final String TAG = MainActivity.class.getSimpleName();

	// yuzhe's change

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// default methods
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// wiring the default background layout
		RelativeLayout l = (RelativeLayout) findViewById(R.id.bg_layout);
		// set the background image
		//l.setBackgroundResource(R.drawable.bg);
		// wiring the image view
		ImageView image = (ImageView) findViewById(R.id.profilePic);
		// set image view
		//image.setImageResource(R.drawable.default_profile);
		EditText password = (EditText) findViewById(R.id.password);
		Button b = (Button) findViewById(R.id.enter);
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, MainMenuActivity.class);
				startActivity(i);
			}
		});
		
		if (pass == null) {
			password.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		ActionBar ab=getActionBar();
		ab.setTitle("Friend");
		ab.setSubtitle("An app to record your best memories");
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
