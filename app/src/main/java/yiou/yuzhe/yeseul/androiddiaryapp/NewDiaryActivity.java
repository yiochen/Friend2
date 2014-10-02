package yiou.yuzhe.yeseul.androiddiaryapp;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewDiaryActivity extends Activity {

	static final int PICK_SELFIE_REQUEST = 1;
	Date date = new Date();
	private Diary mDiary;
	private ImageView b;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_diary);
		mDiary=new Diary();
		
		
		EditText d = (EditText) findViewById(R.id.date);
		String today = "" + (date.getMonth() + 1) + "/" + date.getDate() + "/"
				+ (date.getYear() + 1900);
		d.setText(today);
		b = (ImageView) findViewById(R.id.choose_selfie);
		
		
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(NewDiaryActivity.this, ChooseSelfie.class);
				startActivityForResult(i, PICK_SELFIE_REQUEST);
			}
		});
		EditText title=(EditText)findViewById(R.id.new_diary_title);
		title.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mDiary.setTitle(s.toString());
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		EditText content=(EditText)findViewById(R.id.new_diary_text);
		content.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mDiary.setContent(s.toString());
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if (mDiary.getContent()!=null){
			if (!DiarySystem.get(this).contain(mDiary)){
			DiarySystem.get(this).addDiary(mDiary);
			}
			DiarySystem.get(this).saveDiaries();
			
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == PICK_SELFIE_REQUEST &&resultCode == RESULT_OK)
		{
			if (data.getIntExtra(ChooseSelfie.PICK_SELFIE, 0)==0) return;
			int selfie=data.getIntExtra(ChooseSelfie.PICK_SELFIE, 0);
			mDiary.setSelfie(selfie);
			b.setImageResource(mDiary.getSelfie());
			
			
		}
	}
}
