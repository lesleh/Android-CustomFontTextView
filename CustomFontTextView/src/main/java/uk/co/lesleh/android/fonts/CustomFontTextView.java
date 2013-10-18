package uk.co.lesleh.android.fonts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomFontTextView extends TextView {
    public CustomFontTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        if(isInEditMode())
            return;
        if(attrs == null)
            return;

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomFontTextView, 0, 0);

        try {
            String font = a.getString(R.styleable.CustomFontTextView_font);
            if(font != null) {
                Typeface typeface = TypefaceManager.getTypeface(context, font);
                if(typeface != null) {
                    setTypeface(typeface);
                }
            }
        } finally {
            a.recycle();
        }
    }
}
