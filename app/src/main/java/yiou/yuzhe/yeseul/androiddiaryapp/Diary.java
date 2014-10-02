package yiou.yuzhe.yeseul.androiddiaryapp;
import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Diary {
	private UUID mId;
	private String mTitle="";
	private Date mDate;
	private String mContent;
	private int mSelfie;
	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_DATE = "date";
	private static final String JSON_CONTENT = "content";
	private static final String JSON_SELFIE = "photo";

	public Diary() {
		mId=UUID.randomUUID();
		mDate=new Date();
		
		
	}
	public String getTitle() {
		return mTitle;
	}

	public String getContent() {
		return mContent;
	}

	/**
	 * return the Bitmap selfie when you provide a context
	 * @param context
	 * @return
	 */
	public Bitmap getSelfie(Context context) {
		Bitmap bm = BitmapFactory.decodeResource(context.getResources(),
				mSelfie);
		return bm;
		
	}

	public Date getDate() {
		return mDate;
	}

	public String getDateString()
	{
		return "" + (mDate.getMonth() + 1) + "/" + mDate.getDate() + "/"
				+ (mDate.getYear() + 1900);
	}
	public void setDate(Date date) {
		mDate = date;
	}

	public UUID getId() {
		return mId;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public void setContent(String content) {
		mContent = content;
	}
	public void setSelfie(int resId){
		mSelfie=resId;
	}
	/**
	 * provide just the resource ID of the selfie
	 * @return
	 */
	public int getSelfie(){
		return mSelfie;
	}
	public Diary (JSONObject json) throws JSONException
	{
		mId = UUID.fromString(json.getString(JSON_ID));
		if(json.has(JSON_TITLE))
		{
			mTitle = json.getString(JSON_TITLE);
		}
		mDate = new Date(json.getLong(JSON_DATE));
		
		if(json.has(JSON_SELFIE)){
			mSelfie = json.getInt(JSON_SELFIE);
		}
		
	}
	public JSONObject toJSON() throws JSONException{
		JSONObject json=new JSONObject();
		json.put(JSON_ID,mId.toString());
		json.put(JSON_TITLE,mTitle);
		json.put(JSON_DATE, mDate.getTime());
		if (mSelfie!=0)
			json.put(JSON_SELFIE, mSelfie);
		return json;
		
	}
}
