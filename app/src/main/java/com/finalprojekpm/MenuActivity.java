package com.finalprojekpm;

import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.finalprojekpm.AmbilData.JsonObjectResult;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MenuActivity extends Activity {
	EntitasProduk entitasproduk;
	ArrayList<EntitasProduk> menu = new ArrayList<EntitasProduk>();
	ListView lv;
	String url = "http://guaga.hol.es/menu_service.php";
	String urlpic = "http://guaga.hol.es/menutoko/";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		lv = (ListView) findViewById(R.id.listMenu);

		Bundle b = this.getIntent().getExtras();
		if (b.containsKey("kategori")) {

			String kat = b.getString("kategori");
			Log.d("kat", kat);
			AmbilData ambildata = new AmbilData();
			ambildata.init(MenuActivity.this, jsresult, kat, url);
		}

	}

	public JsonObjectResult jsresult = new JsonObjectResult() {

		@Override
		public void gotJsonObject(JSONObject jobject) {
			// TODO Auto-generated method stub
			try {
				JSONArray arraytempat = jobject.getJSONArray("dataproduk");

				for (int i = 0; i < arraytempat.length(); i++) {
					entitasproduk = new EntitasProduk();
					entitasproduk.setIDproduk(arraytempat.getJSONObject(i)
							.getInt("idproduk"));
					entitasproduk.setNamaProduk(arraytempat.getJSONObject(i)
							.getString("nama_produk"));
					entitasproduk.setHargaProduk(arraytempat.getJSONObject(i)
							.getString("harga_produk"));
					entitasproduk.setDeskripsiProduk(arraytempat
							.getJSONObject(i).getString("deskripsi_produk"));
					entitasproduk.setPictProduk(arraytempat.getJSONObject(i)
							.getString("picture_ad"));
					entitasproduk.setStokProduk(arraytempat.getJSONObject(i)
							.getString("stok_produk"));

					menu.add(entitasproduk);

				}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			MenuBaseAdapter datatempat = new MenuBaseAdapter(MenuActivity.this,
					menu);
			lv.setAdapter(datatempat);
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int p,
						long arg3) {
					// TODO Auto-generated method stub
					String des = menu.get(p).getDeskripsiProduk();
					String nm = menu.get(p).getNamaProduk();
					String hrg = menu.get(p).getHargaProduk();
					String pic = menu.get(p).getPictProduk();
					String sto = menu.get(p).getStokProduk();

					tampilkandetail(nm, des, hrg, pic, sto);

				}
			});
		}

	};

	public void tampilkandetail(String nama, String desk, String harga,
			String pic, String stok) {

		final Dialog d = new Dialog(this);
		d.setTitle("detail");
		d.setContentView(R.layout.dialog_custom);

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(d.getWindow().getAttributes());
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.WRAP_CONTENT;

		d.getWindow().setAttributes(lp);

		ImageView gb = (ImageView) d.findViewById(R.id.picDialog);
		TextView n = (TextView) d.findViewById(R.id.idNamaProduk);
		TextView h = (TextView) d.findViewById(R.id.idHarga);
		TextView s = (TextView) d.findViewById(R.id.txtStok);
		TextView desc = (TextView) d.findViewById(R.id.idDeskripsi);
		Button bOk = (Button) d.findViewById(R.id.idOK);

		n.setText(nama);
		h.setText(harga);
		s.setText(stok);
		desc.setText(desk);
		new DownloadImageTask(gb).execute(urlpic + pic);
		bOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				d.dismiss();
			}
		});
		d.show();
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
