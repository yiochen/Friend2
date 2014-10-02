package yiou.yuzhe.yeseul.androiddiaryapp;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class DiarySystem {
	private ArrayList<Diary> mDiaries;
	private static DiarySystem sDiarySystem;
	private Context mAppContext;
	private DiaryJSONSerializer mSerializer;
	private static final String FILENAME="diaries.json";
	
	private DiarySystem(Context appContext) {
		mAppContext=appContext;
		mSerializer=new DiaryJSONSerializer(mAppContext, FILENAME);
		mDiaries=new ArrayList<Diary>();
	}
	
	public static DiarySystem get(Context c){
		if (sDiarySystem==null){
			sDiarySystem=new DiarySystem(c.getApplicationContext());
		}
		return sDiarySystem;
	}
	
	public boolean contain(Diary dia){
		for (Diary d:mDiaries){
			if (dia.getId()==d.getId()) return true;
		}
		return false;
		
	}
	public ArrayList<Diary> getDiaries(){
		return mDiaries;
	}
	
	public Diary getDiary(UUID id){
		for (Diary d:mDiaries){
			if (d.getId().equals(id))
				return d;
		}
		return null;
	}
	public void addDiary(Diary d){
		mDiaries.add(d);
	}
	public boolean saveDiaries(){
		try{
			mSerializer.saveDiaries(mDiaries);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public void deleteDiary(Diary item) {
		mDiaries.remove(item);
		
	}
}
