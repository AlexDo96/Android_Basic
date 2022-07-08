package com.android.truyencuoi;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TruyencuoiActivity extends Activity {
    /** Called when the activity is first created. */

	Button dau,cuoi,truoc,sau;
	TextView tieude,noidung;
	int vt=0;
	String[] truyen;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dau=(Button)findViewById(R.id.button1);
        truoc=(Button)findViewById(R.id.button2);
        sau=(Button)findViewById(R.id.button3);
        cuoi=(Button)findViewById(R.id.button4);
        tieude=(TextView)findViewById(R.id.textView1);
        noidung=(TextView)findViewById(R.id.textView2);

        try {                                                         // try catch kiem tra su ton tai cua file
			InputStream in=getAssets().open("truyencuoi.txt");        // doc file tu thu muc Assets
			byte[] buffer=new byte[in.available()];                   // doc tung byte
			in.read(buffer);
			String chuoi=new String(buffer);                       // gan chuoi khi doc file
			truyen=chuoi.split("#");                               // truyen noi dung cua truyện vao mang được ngăn cách bởi dấu #
			hienthi(vt);                                           // Goi ham void hienthi()
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        dau.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				vt=0;                 // Vị trí đầu
				hienthi(vt);
			}
		});
        
        cuoi.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				vt=truyen.length-1;      // Vị trí cuối
				hienthi(vt);
			}
		});
        
        truoc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(vt!=0)
					vt--;             // Lùi về mẫu truyện trước
				hienthi(vt);
			}
		});
        
        sau.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(vt!=truyen.length-1)
					vt++;             // Tiến về mẫu truyện sau
				hienthi(vt);
			}
		});
        
    }

	// Ham void hienthi() khai bao ngoài onCreate

	public void hienthi(int vitri)                   // ham void hienthi() dung de tach tieu de va noi dung, xac dinh vi tri dau, cuoi, truoc, sau
	{
		String s_truyen=truyen[vitri].toString();
		String [] tach=s_truyen.split("\\*");          // tach tung truyen bang dau *

		if(vitri==0)                                   // khi doc truyen dau tien thi button dau, truoc bị ẩn
		{
			dau.setEnabled(false);
			truoc.setEnabled(false);
		}
		else
		{
			dau.setEnabled(true);
			truoc.setEnabled(true);
		}

		if(vitri==truyen.length-1)                     // khi doc truyen cuoi thi button sau, cuoi bị ẩn
		{
			sau.setEnabled(false);
			cuoi.setEnabled(false);
		}
		else
		{
			sau.setEnabled(true);
			cuoi.setEnabled(true);
		}

		tieude.setText(tach[0].toString());              // Hien thi tieu de khi tach lần đầu đọc chuỗi của mảng
		noidung.setText(tach[1].toString());             // Hien thi noi dung khi tach lần thu 2 đọc chuỗi của mảng
	}
	
	
}