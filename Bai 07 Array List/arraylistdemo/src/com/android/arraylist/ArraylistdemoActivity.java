package com.android.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ArraylistdemoActivity extends Activity {
    
/** Called when the activity is first created. */
	
	
EditText et_nhap;
	
Button bt_th;
	
TextView tv_day,tv_thongbao;
	
ArrayList<Integer> daymay;
	ArrayList<Integer> daynguoi;
	
    
@Override
    public void onCreate(Bundle savedInstanceState) {
        
super.onCreate(savedInstanceState);
        setContentView(R.layout.main);  
        
et_nhap=(EditText)findViewById(R.id.editText1);
        
et_nhap.setInputType(0);
        
bt_th=(Button)findViewById(R.id.button1);
        
tv_day=(TextView)findViewById(R.id.textView2);
        
tv_thongbao=(TextView)findViewById(R.id.textView3);
        
daymay=new ArrayList<Integer>();
        
daynguoi=new ArrayList<Integer>();
        
        
Random r=new Random();
        
for(int i=0;i<4;i++)
        
{
        	int so=r.nextInt(6-1+1)+1; //(b-a+1)+a;
        	
daymay.add(so);
        }
        
        
bt_th.setOnClickListener(new View.OnClickListener() {		
			
public void onClick(View arg0) {
				
//lay chuoi nguoi nhap ra
				
String s_daynguoi=et_nhap.getText().toString();
				
//cat thanh mang chuoi
				
String [] mangchuoi=s_daynguoi.split(" ");
				
				
daynguoi.clear();
				//ep thành Integer va đưa vao ArrayList
				
for(int i=0;i<mangchuoi.length;i++)
					
daynguoi.add(Integer.parseInt(mangchuoi[i]));
				
				
String chuoi="day may: ";
				
for(Integer item : daymay)
					
chuoi+=item + " , ";
				
				
chuoi+="\ndaynguoi: ";
				
for(Integer item: daynguoi)
					
chuoi+=item +  " , ";
				
tv_day.setText(chuoi);
				
				/////////////////
				int coso=0;
				int dungsodungvitri=0;
				for(int i=0;i<daynguoi.size();i++)
					if(daymay.contains(daynguoi.get(i))==true)
						coso++;
				
				for(int i=0;i<daynguoi.size();i++)
					if(daynguoi.get(i)==daymay.get(i))
						dungsodungvitri++;
				
				tv_thongbao.setText("phan tu nguoi nhap nam trong phan tu may : "+ coso+
						"\nso phan tu dung so dung vi tri voi may: "+ dungsodungvitri);	
			}
		});
    }
}