package com.finalprojekpm;

import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuBaseAdapter extends BaseAdapter {
	private static ArrayList<EntitasProduk> searchArrayList;

	private LayoutInflater mInflater;
	String urlpic = "http://alvinux.xyz/api-android/";

	Bitmap bm;

	public MenuBaseAdapter(Context context, ArrayList<EntitasProduk> results) {
		searchArrayList = results;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return searchArrayList.size();
	}

	@Override
	public Object getItem(int p) {
		return searchArrayList.get(p);
	}

	@Override
	public long getItemId(int p) {
		return p;
	}

	@Override
	public View getView(int p, View v, ViewGroup parent) {
		ViewHolder holder;

		if (v == null) {
			v = mInflater.inflate(R.layout.item_custom_listview, null );
			holder = new ViewHolder();
//ini holder bisa diganti, R.id.nama diganti strNama untuk layout yang udah dibikin tadi t1.xml
			holder.nama = (TextView) v.findViewById(R.id.nama);
			holder.harga = (TextView) v.findViewById(R.id.harga);
			//holder.stok = (TextView) v.findViewById(R.id.strStok);
			holder.pic = (ImageView) v.findViewById(R.id.img_menu);
			// holder.deskripsi = (TextView) v.findViewById(R.id.d);
			new DownloadImageTask(holder.pic).execute(urlpic
					+ searchArrayList.get(p).getPictProduk());
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		holder.nama.setText(searchArrayList.get(p).getNamaProduk());
		holder.harga.setText(searchArrayList.get(p).getHargaProduk());
//		holder.stok.setText(searchArrayList.get(p).getStokProduk());
//		new DownloadImageTask(holder.pic).execute(urlpic
//				+ searchArrayList.get(p).getPictProduk());
		return v;
	}

	static class ViewHolder {
		TextView nama, harga;
		ImageView pic;

	}

	public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon11 = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			if (result != null) {
				Bitmap bmp2 = Bitmap.createScaledBitmap(result, 72, 72, true);
				bmImage.setImageBitmap(bmp2);
			}

		}
	}
}