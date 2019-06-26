package base.pkj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Main  extends Activity  {

	ImageButton iB, iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8, iB9;
	ImageButton iBeb, iBok; 
	TextView tV3;
	String nya = "Silakan tik angka";
	int smt = 0, kb = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        iB    = (ImageButton)findViewById(R.id.exit);
        iBeb  = (ImageButton)findViewById(R.id.eb);
        iBok  = (ImageButton)findViewById(R.id.ok);
        iB0   = (ImageButton)findViewById(R.id.zero);
        iB1   = (ImageButton)findViewById(R.id.one);
        iB2   = (ImageButton)findViewById(R.id.two);
        iB3   = (ImageButton)findViewById(R.id.three);
        iB4   = (ImageButton)findViewById(R.id.four);
        iB5   = (ImageButton)findViewById(R.id.five);
        iB6   = (ImageButton)findViewById(R.id.six);
        iB7   = (ImageButton)findViewById(R.id.seven);
        iB8   = (ImageButton)findViewById(R.id.eight);
        iB9   = (ImageButton)findViewById(R.id.nine);
        tV3 = (TextView)findViewById(R.id.pasal);
		iB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	   android.os.Process.killProcess(android.os.Process.myPid());
            	}
          });
		
        tV3.setText(nya);
		iB0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	kb = 0;
            	tambah(kb);
              }
          });
		
		iB1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	 kb=1;
            	 tambah(kb);
               }
          });

		iB2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	kb = 2;
            	tambah(kb);
              }
          });
		
		iB3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	 kb=3;
            	 tambah(kb);
               }
          });

		iB4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	kb = 4;
            	tambah(kb);
              }
          });
		
		iB5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	 kb=5;
            	 tambah(kb);
               }
          });

		iB6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	kb = 6;
            	tambah(kb);
              }
          });
		
		iB7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	 kb=7;
            	 tambah(kb);
               }
          });
	
		iB8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	kb = 8;
            	tambah(kb);
              }
          });
		
		iB9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	 kb=9;
            	 tambah(kb);
               }
          });
		
		iBok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Main.this, Tampil.class);
                    intent.putExtra("Pindah", (String) String.valueOf(smt));
                    Main.this.startActivity(intent);
                } catch (Exception e) {
                }
                android.os.Process.killProcess(android.os.Process.myPid());
               }
          });

		
		iBeb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            	int l = nya.length();
            	if(l>1){
            		nya = nya.substring(0,(l-1));
            		smt = Integer.parseInt(nya);
            		tV3.setText(nya);
            	}else{
            		smt=0;
            		tV3.setText("0");
            	}
               }
          });

    }
    
    public void tambah(int kb)
    {
    	if(smt==0)
    	{
    	   smt = kb;
    	}else if(smt<10)
    	{
    		smt = smt * 10 + kb;   		
    	}else if(smt<100)
    	{
    		smt = smt * 10 + kb; 
    	}
       if(smt<309){	
    	   nya = String.valueOf(smt);
 	       tV3.setText(nya);
       }else{
    	   smt = 0;
    	   nya = String.valueOf(smt);
    	   tV3.setText(nya);
       }

    }
}
