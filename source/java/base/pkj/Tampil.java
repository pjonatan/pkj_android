package base.pkj;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class Tampil extends Activity  {

	TextView tV, tV2;
	ImageView iB;
	String pindah;
	int index;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tampil);

		pindah = getIntent().getExtras().getString("Pindah");
		tV = (TextView)findViewById(R.id.pasal);
		tV2 = (TextView)findViewById(R.id.textView);
		iB = (ImageView)findViewById(R.id.exit);
		index = Integer.parseInt(pindah);
		tV.setText("PKJ : " + String.valueOf(index));
		Cursor res = new DBH(this).getLirik(index);
		res.moveToFirst();
        tV2.setText(res.getString(1));
		res.close();
        
        tV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Tampil.this.startActivity(new Intent(Tampil.this, Main.class));
            	android.os.Process.killProcess(android.os.Process.myPid());
            }
          });		
		
		iB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	   android.os.Process.killProcess(android.os.Process.myPid());
            	}
          });
        
	}

}
