package yiou.yuzhe.yeseul.androiddiaryapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

	private Context context;


	// references to our images. Need to add images
	public static final Integer[] mThumbIds = { 
			R.drawable.angry, R.drawable.disappointed, 
			R.drawable.excited, R.drawable.happy, 
			R.drawable.jealous, R.drawable.omg, 
			R.drawable.sad, R.drawable.surprised
		   /* R.drawable.sample_5, R.drawable.sample_6,
			R.drawable.sample_7, R.drawable.sample_0, R.drawable.sample_1,
			R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
			R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
			R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
			R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
			R.drawable.sample_6, R.drawable.sample_7*/ };
	
	
	public GridAdapter(Context c) {
		context = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return mThumbIds[pos];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView;
		if (convertView == null) // if it's not recycled, initialize some
									// attirbutes
		{
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(150, 200));
			imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			imageView.setPadding(5, 5, 5, 5);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[pos]);
		return imageView;
	}


}
