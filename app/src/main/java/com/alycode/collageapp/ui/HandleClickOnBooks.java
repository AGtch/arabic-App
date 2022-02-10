package com.alycode.collageapp.ui;

import android.content.Context;
import android.widget.Toast;

import com.alycode.collageapp.FireBaseHandle.FirebaseHandle;
import com.alycode.collageapp.FireBaseHandle.OpenPdfFromStorage;
import com.alycode.collageapp.FireBaseHandle.SaveNamesOfDownloadedPdf;

public class HandleClickOnBooks {
    public static HandleClickOnBooks handleClickOnBooksInstance;

    public static HandleClickOnBooks getHandleClickOnBooksInstance() {
        if (handleClickOnBooksInstance == null) {
            handleClickOnBooksInstance = new HandleClickOnBooks();
        }
        return handleClickOnBooksInstance;
    }

    public void buttonClickedToDownloadOrOpenPdf(Context context, String pdfName, String pdfUrl) {
        if (SaveNamesOfDownloadedPdf.getSaveNamesOfDownloadedPdf().sharedPreferences.contains(pdfName)) {
            try {
                OpenPdfFromStorage.getOpenPdfFromStorage().openPdf(pdfName);
            } catch (Exception e) {

                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            FirebaseHandle.firebaseHandleInstance.downloadFile(context, pdfName, pdfUrl);
        }
    }
}
