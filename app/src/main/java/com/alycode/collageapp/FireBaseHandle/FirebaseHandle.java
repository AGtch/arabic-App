package com.alycode.collageapp.FireBaseHandle;


import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;

import java.io.File;

public class FirebaseHandle extends BroadcastReceiver {
    public static FirebaseHandle firebaseHandleInstance;

    public static FirebaseHandle getFirebaseHandleInstance() {
        if (firebaseHandleInstance == null) {
            firebaseHandleInstance = new FirebaseHandle();
        }
        return firebaseHandleInstance;
    }

    public static long downloadID = -1L;
    public static String pdfName;
    static DownloadManager downloadManager;
    public Context context = ContextProvider.getContext();


    public SharedPreferences sharedPreferences = context.getSharedPreferences("com.alycode.collageapp", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();


    public void downloadFile(Context context, String fileName, String url) {

        FirebaseHandle.pdfName = fileName;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle(fileName);
        request.setDescription("Downloading " + fileName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.allowScanningByMediaScanner();
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
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
                // pdfViewModel = new ViewModelProvider(baseActivity).get(PdfViewModel.class); //init
                Log.d("file url", uri);

                String realUri = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + pdfName);
                editor.putString(pdfName, realUri);
                editor.commit();
                try {
                    openPdf(pdfName);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                // download is cancelled
            }
        } else {
            // download is cancelled
        }
    }

    public void openPdf(String filename) throws Exception {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename);
        Uri uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.alycode.collageapp" + ".provider", file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(intent);

    }
//    public static void getPdf(String fileName) {
//        Uri uri = Uri.parse(path);
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setDataAndType(uri, "*/*");
//        context.getApplicationContext().startActivity(intent);
//    }

//    // Request code for selecting a PDF document.
//    private static final int PICK_PDF_FILE = 2;
//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private void openFile(Activity activity,Uri pickerInitialUri) {
//        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        intent.setType("application/pdf");
//
//        // Optionally, specify a URI for the file that should appear in the
//        // system file picker when it loads.
//        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);
//        File file = new File(pickerInitialUri.getPath());
//        activity.startActivityForResult(intent, file.hashCode());
//    }

}
