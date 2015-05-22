package com.example.korgan.lottoandroid;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by korgan on 22/05/15.
 */
public class Paahtoleipa
{
    public static Void p(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        return null;
    }
}
