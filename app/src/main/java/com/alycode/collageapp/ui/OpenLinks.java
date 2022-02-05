package com.alycode.collageapp.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class OpenLinks {
    public static OpenLinks openLinks;
    public static OpenLinks getOpenLinksInstance(){
        if (openLinks == null){
            openLinks = new OpenLinks();
        }
        return openLinks;
    }



    public void openLinksMethod(Context context, String linkToOpen){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkToOpen));
        context.startActivity(browserIntent);
    }
}
