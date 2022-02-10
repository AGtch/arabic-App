package com.alycode.collageapp.ui.fragment;

import android.app.AlertDialog;
import android.content.Context;

import com.alycode.collageapp.FireBaseHandle.ContextProvider;
import com.alycode.collageapp.R;

public class MassageDialog {
    Context context = ContextProvider.getContext();
    private AlertDialog dialog;
    public static MassageDialog massageDialog ;
    public static MassageDialog getMassageDialog(){
        if (massageDialog == null){
            massageDialog = new MassageDialog();
        }
        return massageDialog;
    }
    public void showProgressBar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.progress_bar);
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }

    public void showErrorMassage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("حدث خطا");
        builder.setCancelable(true);
        builder.setMessage("من فضلك تأكد من الاتضال بالانترنت واعاده المحاوله");
        builder.setPositiveButton("حسنا", (dialog, which) -> {
            hideProgressBar();
        });
        builder.setNegativeButton("تواصل معنا لحل مشكلتك", (dialog, which) -> {
            hideProgressBar();
        });
        dialog = builder.create();
        dialog.show();
    }

    public void hideProgressBar() {
        dialog.dismiss();
        dialog.cancel();
    }
}
