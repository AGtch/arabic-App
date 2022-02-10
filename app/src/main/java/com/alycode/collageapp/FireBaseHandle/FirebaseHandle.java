package com.alycode.collageapp.FireBaseHandle;


import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.alycode.collageapp.ui.fragment.MassageDialog;

public class FirebaseHandle extends BroadcastReceiver {
    public static long downloadID = -1L;
    public static String pdfName;
    public static FirebaseHandle firebaseHandleInstance;
    static DownloadManager downloadManager;
    public Context context = ContextProvider.getContext();


    public static FirebaseHandle getFirebaseHandleInstance() {
        if (firebaseHandleInstance == null) {
            firebaseHandleInstance = new FirebaseHandle();
        }
        return firebaseHandleInstance;
    }

    public void downloadFile(Context context, String fileName, String url) {
        FirebaseHandle.pdfName = fileName;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle(fileName);
        request.setDescription("Downloading " + fileName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(true);
        request.allowScanningByMediaScanner();
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        MassageDialog.getMassageDialog().showProgressBar();

        downloadID = downloadManager.enqueue(request);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
        if (downloadId == -1)
            return;
        // query download status
        Cursor cursor = downloadManager.query(new DownloadManager.Query().setFilterById(downloadId));
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            if (status == DownloadManager.STATUS_SUCCESSFUL) {
                // download is successful
                @SuppressLint("Range") String uri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                String realUri = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + pdfName);
                SaveNamesOfDownloadedPdf.getSaveNamesOfDownloadedPdf().savingPdfInSharedPreference(pdfName, realUri);
                MassageDialog.getMassageDialog().hideProgressBar();
                try {
                    OpenPdfFromStorage.getOpenPdfFromStorage().openPdf(pdfName);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                // download is cancelled
                MassageDialog.getMassageDialog().showErrorMassage();
            }
        } else {
            // download is cancelled
            MassageDialog.getMassageDialog().showErrorMassage();
        }
    }
}
