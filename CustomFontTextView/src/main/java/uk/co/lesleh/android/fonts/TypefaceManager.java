package uk.co.lesleh.android.fonts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class TypefaceManager {

    private static final String TAG = "TypefaceManager";

    public static Map<String, Typeface> typefaces = new HashMap<String, Typeface>();

    public static Typeface getTypeface(Context context, String font) {
        if(typefaces.containsKey(font))
            return typefaces.get(font);
        else
            return loadTypeface(context, font);
    }

    private static synchronized Typeface loadTypeface(Context context, String font) {
        if(typefaces.containsKey(font)) {
            return typefaces.get(font);
        }

        Typeface typeface = null;

        try {
            String path = "fonts/" + font;
            typeface = Typeface.createFromAsset(context.getAssets(), path);
        } catch(RuntimeException e) {
            Log.e(TAG, "Failed to load typeface.");
        }

        // Even if we failed, store the result to prevent Android trying repeatedly
        typefaces.put(font, typeface);
        return typeface;
    }

    // Save duplicating the same code constantly
    public static void initTypeface(TextView textView, Context context, AttributeSet attrs, int defStyle) {
        if (textView.isInEditMode())
            return;
        if (attrs == null)
            return;

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomFontTextView, 0, 0);

        try {
            String font = a.getString(R.styleable.CustomFontTextView_font);
            if (font != null) {
                Typeface typeface = TypefaceManager.getTypeface(context, font);
                if (typeface != null) {
                    textView.setTypeface(typeface);
                }
            }
        } finally {
            a.recycle();
        }
    }

}
