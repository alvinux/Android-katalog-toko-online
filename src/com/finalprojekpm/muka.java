package com.finalprojekpm;

import com.finalprojekpm.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class muka extends Activity implements OnClickListener{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
        
        View gambar=
    findViewById(R.id.gambar);
        gambar.setOnClickListener(this);
        
       
    }
    public void onClick(View v){
    	switch (v.getId()){
    	case R.id.gambar:
    		Intent menu= new Intent (this, menu.class);
    		startActivity(menu);
    		break;
    	
    		
    		
    	}
    	}
    }
