package com.alycode.collageapp.ui;

import android.content.Context;
import android.widget.Toast;

import com.alycode.collageapp.FireBaseHandle.FirebaseHandle;

public class HandleClickOnBooks {
    public static HandleClickOnBooks handleClickOnBooksInstance ;
    public static HandleClickOnBooks getHandleClickOnBooksInstance(){
        if (handleClickOnBooksInstance == null){
            handleClickOnBooksInstance = new HandleClickOnBooks();
        }
        return handleClickOnBooksInstance;
    }
    public void buttonClickedToDownloadOrOpenPdf(Context context , String pdfName , String pdfUrl){
        if (FirebaseHandle.getFirebaseHandleInstance().sharedPreferences.contains(pdfName)) {
            try {
                FirebaseHandle.getFirebaseHandleInstance().openPdf(pdfName);
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            FirebaseHandle.firebaseHandleInstance.downloadFile(context, pdfName, pdfUrl);
        }
    }
}
