package com.finalprojekpm;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class AmbilData extends AsyncTask<Object, Object, Object> {
	private JSONParser jsonparser;
	ArrayList<String> d;
	JsonObjectResult jobres;
	Context context;
	ProgressDialog pd;

	public void init(Context c, JsonObjectResult jres, String kategori,
			String url) {
		this.context = c;
		this.jobres = jres;

		AmbilData ad = this;
		ad.execute(url, kategori, "");
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pd = ProgressDialog.show(context, "Retrieve Data", "aaa");
		pd.setMessage("Please wait...");
		pd.show();
	}

	@Override
	protected Object doInBackground(Object... parameter) {
		// TODO Auto-generated method stub
		JSONObject jsobj = null;
		String url = (String) parameter[0];
		String kat = (String) parameter[1];
		Log.i("url", url);
		Log.i("kat", kat);
		jsonparser = new JSONParser();
		List<NameValuePair> datajson = new ArrayList<NameValuePair>();
		datajson.add(new BasicNameValuePair("kategori", kat));
		try {
			jsobj = jsonparser.getObject(url, "POST", datajson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsobj;
	}

	@Override
	protected void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (pd.isShowing()) {
			pd.dismiss();
		}

		if (result != null) {
			JSONObject js = (JSONObject) result;
			jobres.gotJsonObject(js);
		}
	}

	public static abstract class JsonObjectResult {
		public abstract void gotJsonObject(JSONObject jobject);
	}

}

