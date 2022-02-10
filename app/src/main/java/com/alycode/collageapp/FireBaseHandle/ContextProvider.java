package com.alycode.collageapp.FireBaseHandle;

import android.app.Application;
import android.content.Context;

public class ContextProvider extends Application {
    public static ContextProvider contextProviderInstance;
    private static Context mContext;

    public static ContextProvider getContextProviderInstance() {
        if (contextProviderInstance == null) {
            contextProviderInstance = new ContextProvider();
        }
        return contextProviderInstance;
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        ContextProvider.mContext = mContext;
    }
}
