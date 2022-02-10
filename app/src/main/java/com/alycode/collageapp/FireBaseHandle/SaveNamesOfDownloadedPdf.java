package com.alycode.collageapp.FireBaseHandle;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveNamesOfDownloadedPdf {
    public static SaveNamesOfDownloadedPdf saveNamesOfDownloadedPdf;

    public static SaveNamesOfDownloadedPdf getSaveNamesOfDownloadedPdf() {
        if (saveNamesOfDownloadedPdf == null) {
            saveNamesOfDownloadedPdf = new SaveNamesOfDownloadedPdf();
        }
        return saveNamesOfDownloadedPdf;
    }

    Context context = ContextProvider.getContext();
    public SharedPreferences sharedPreferences = context.getSharedPreferences("com.alycode.collageapp", Context.MODE_PRIVATE);

    public void savingPdfInSharedPreference(String pdfName, String pdfUriInStorage) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(pdfName, pdfUriInStorage);
        editor.apply();
    }
}
