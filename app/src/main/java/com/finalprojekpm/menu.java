package com.finalprojekpm;



import com.finalprojekpm.R;

import com.finalprojekpm.MenuActivity;


import android.app.Activity;
import android.app.AlertDialog;


import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle; //import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class menu extends Activity implements OnClickListener{
	Button btnTas, btnSepatu, btnAbout, btnHelp, btnExit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		btnTas = (Button) findViewById(R.id.btnTas);
		btnSepatu = (Button) findViewById(R.id.btnSepatu);
		btnAbout = (Button) findViewById(R.id.btnAbout);
		btnHelp = (Button) findViewById(R.id.btnHelp);
		btnExit = (Button) findViewById(R.id.btnExit);
		
		
		btnTas.setOnClickListener(this);
		btnSepatu.setOnClickListener(this);
		btnAbout.setOnClickListener(this);
		btnHelp.setOnClickListener(this);
		btnExit.setOnClickListener(this);
		
		
	}
	
	
	@Override
	public void onClick(View v) {
		Intent i = null;
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnTas:
			Bundle b = new Bundle();
			Intent intent = new Intent(menu.this, MenuActivity.class);
			b.putString("kategori", "1");
			intent.putExtras(b);
			startActivity(intent);
			
			break;
			
		case R.id.btnSepatu:
			Bundle bu = new Bundle();
			Intent intent2 = new Intent(menu.this, MenuActivity.class);
			bu.putString("kategori", "2");
			intent2.putExtras(bu);
			startActivity(intent2);

			break;
		
			
		case R.id.btnHelp:
			i = new Intent(this, help.class);
			startActivity(i);
			break;	
			
		case R.id.btnAbout:
			i = new Intent(this, about.class);
			startActivity(i);
			break;	
			
			
		case R.id.btnExit:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Anda Yakin Ingin Menutup Aplikasi?")
					.setCancelable(false).setPositiveButton("Ya",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent exit = new Intent(
											Intent.ACTION_MAIN);
									exit.addCategory(Intent.CATEGORY_HOME);
									exit
											.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
									startActivity(exit);
								}
							}).setNegativeButton("Tidak",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							}).show();
			break;	
			
	
		

		default:
			
			Toast.makeText(
					this,
					" , Actionnya belum dibuat",
					Toast.LENGTH_LONG).show();
		
			break;
		}
		
		
		
	}
	
	

}



//public void onCreate(Bundle icicle) {
//super.onCreate(icicle);
//
//			        
//
//// Create an array of Strings, that will be put to our ListActivity
//String[] menu = new String[] { "Tas Wanita", "Sepatu","Bantuan", "About", "Exit" };
//
//
//// Menset nilai array ke dalam list adapater sehingga data pada array
//// akan dimunculkan dalam list
//this.setListAdapter(new ArrayAdapter<String>(this,
//		android.R.layout.two_line_list_item, menu));
//		getListView().setBackgroundResource(R.drawable.bg);
//
//}
//
//@Override
///**method ini akan mengoveride method onListItemClick yang ada pada class List Activity
//* method ini akan dipanggil apabilai ada salah satu item dari list menu yang dipilih
//*/
//protected void onListItemClick(ListView l, View v, int position, long id) {
//super.onListItemClick(l, v, position, id);
//// Get the item that was clicked
//// Menangkap nilai text yang dklik
//Object o = this.getListAdapter().getItem(position);
//String pilihan = o.toString();
//// Menampilkan hasil pilihan menu dalam bentuk Toast
//tampilkanPilihan(pilihan);
//
//}
//
///**
//* Tampilkan Activity sesuai dengan menu yang dipilih
//* 
//*/
//protected void tampilkanPilihan(String pilihan) {
//try {
//	// Intent digunakan untuk sebagai pengenal suatu activity
//	Intent i = null;
//	if (pilihan.equals("Tas Wanita")) {
//		i = new Intent(this, menutas.class);	
//		
//	} else if (pilihan.equals("Sepatu")) {
//		i = new Intent(this, menusepatu.class);
//	} else if (pilihan.equals("Bantuan")) {
//		i = new Intent(this, help.class);
//	} else if (pilihan.equals("About")) {
//		i = new Intent(this, about.class);
//	} else if (pilihan.equals("Exit")) {
//		// Intent exit = new Intent(Intent.ACTION_MAIN);
//		// startActivity(exit);
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		builder.setMessage("Anda Yakin Ingin Menutup Aplikasi?")
//				.setCancelable(false).setPositiveButton("Ya",
//						new DialogInterface.OnClickListener() {
//							public void onClick(DialogInterface dialog,
//									int id) {
//								Intent exit = new Intent(
//										Intent.ACTION_MAIN);
//								exit.addCategory(Intent.CATEGORY_HOME);
//								exit
//										.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//								startActivity(exit);
//							}
//						}).setNegativeButton("Tidak",
//						new DialogInterface.OnClickListener() {
//							public void onClick(DialogInterface dialog,
//									int id) {
//								dialog.cancel();
//							}
//						}).show();
//	
//	} else {
//		Toast.makeText(
//				this,
//				"Anda Memilih: " + pilihan
//						+ " , Actionnya belum dibuat",
//				Toast.LENGTH_LONG).show();
//	}
//	startActivity(i);
//} catch (Exception e) {
//	e.printStackTrace();
//}
//}