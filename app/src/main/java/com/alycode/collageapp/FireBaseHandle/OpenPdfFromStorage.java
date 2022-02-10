package com.alycode.collageapp.FireBaseHandle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import androidx.core.content.FileProvider;

import com.alycode.collageapp.ui.fragment.MassageDialog;

import java.io.File;

public class OpenPdfFromStorage {
    Context context = ContextProvider.getContext();
    public static OpenPdfFromStorage openPdfFromStorage;

    public static OpenPdfFromStorage getOpenPdfFromStorage() {
        if (openPdfFromStorage == null) {
            openPdfFromStorage = new OpenPdfFromStorage();
        }
        return openPdfFromStorage;
    }

    public void openPdf(String filename) {

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);
        Uri uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.alycode.collageapp" + ".provider", file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            context.startActivity(intent);
        } catch (Exception exception) {
            MassageDialog.getMassageDialog().showErrorMassage();
        }
    }
}
