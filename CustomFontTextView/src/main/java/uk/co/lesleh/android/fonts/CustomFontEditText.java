package uk.co.lesleh.android.fonts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class CustomFontEditText extends EditText {
    public CustomFontEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypefaceManager.initTypeface(this, context, attrs, defStyle);
    }
}
