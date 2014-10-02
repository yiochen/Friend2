package yiou.yuzhe.yeseul.androiddiaryapp;

import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDiaryActivity extends Activity {

	
	public static final String VIEW_DIARY_ACTIVITY_ID = "VIEW_DIARY_ACTIVITY_ID";
	private UUID diaryID;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_diary);
		Intent i = getIntent();
		diaryID = (UUID) getIntent().getSerializableExtra(ViewDiaryActivity.VIEW_DIARY_ACTIVITY_ID);
		
		// used this instead of getActivity(), might cause trouble
		Diary d = DiarySystem.get(this).getDiary(diaryID);
		ImageView selfie = (ImageView) findViewById(R.id.view_diary_selfie);
		selfie.setImageBitmap(d.getSelfie(this));
		TextView date = (TextView) findViewById(R.id.view_date);
		date.setText(d.getDateString());
		TextView title = (TextView) findViewById(R.id.view_diary_title);
		title.setText(d.getTitle());
		TextView content = (TextView) findViewById(R.id.view_diary_text);
		content.setText(d.getContent());
		
		
	}
}
