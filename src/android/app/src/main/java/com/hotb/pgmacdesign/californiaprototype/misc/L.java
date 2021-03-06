package com.hotb.pgmacdesign.californiaprototype.misc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.hotb.pgmacdesign.californiaprototype.utilities.StringUtilities;

/**
 * Simple class, used primarily for logs, toasts, and OTHER tedious things
 * Created by pmacdowell on 2017-02-13.
 */
public class L {

    private static final String TAG = "PGMacUtilities";
    /**
     * Quick println
     * @param myObject The string to print (or double, int, whatever)
     * @param <E> Extends object
     */
    public static <E> void m (E myObject){
        String str = myObject + "";
        if(StringUtilities.isNullOrEmpty(str)){
            return;
        }
        if (str.length() > 4000) {
            Log.v(TAG, "sb.length = " + str.length());
            int chunkCount = str.length() / 4000;     // integer division
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= str.length()) {
                    Log.d(TAG, "chunk " + i + " of " + chunkCount + ":" + str.substring(4000 * i));
                } else {
                    Log.d(TAG, "chunk " + i + " of " + chunkCount + ":" + str.substring(4000 * i, max));
                }
            }
        } else {
            Log.d(TAG, str);
        }
    }
    /**
     * Quick println for the line number
     * @param x int, line number
     */
    public static void l(int x){
        Log.d(TAG, "Line Number " + x + " hit");
    }

    /**
     * Quick println for the line number
     * @param x int, line number
     */
    public static void l(Context context, int x){
        String activityName = null;
        try {
            activityName = context.getClass().getSimpleName();
        } catch (Exception e){}
        if(activityName == null){
            activityName = "Unknown";
        }
        Log.d(TAG, "Activity: " + activityName + ", " + "Line Number " + x + " hit");
    }

    /**
     * Short toast
     * @param context context
     * @param myObject String to print (If OTHER things are passed in, it converts it to a String first)
     */
    public static <E> void toast(Context context, E myObject){
        String str = myObject + ""; //Cast it to a String
        Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT).show();
    }

    /**
     * Long toast
     * @param context context
     * @param myObject String to print (If OTHER things are passed in, it converts it to a String first)
     */
    public static <E> void Toast(Context context, E myObject){
        String str = myObject + ""; //Cast it to a String
        Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_LONG).show();


    }

}
