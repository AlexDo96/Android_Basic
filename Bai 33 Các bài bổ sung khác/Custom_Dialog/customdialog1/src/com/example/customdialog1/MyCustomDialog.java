package com.example.customdialog1;


import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

public class MyCustomDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // yes 
        dialog.findViewById(R.id.yes_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	MainActivity main=(MainActivity)getActivity();
            	main.dialogTraVe("yes");
                dismiss();
            }
        });
        
        //no
        dialog.findViewById(R.id.no_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	MainActivity main=(MainActivity)getActivity();
            	main.dialogTraVe("no");
                dismiss();
            }
        });

        // Close 
        dialog.findViewById(R.id.close_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return dialog;
    }
}
