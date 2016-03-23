package link.sharein.cherry.presentation.ui.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RadioButton;

import link.sharein.cherry.R;

/**
 * Created by jiang on 2016/3/6.
 */
public class CustomRadioButton extends RadioButton {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomRadioButton(Context context) {
        super(context, null, 0, R.style.CustomRadioButton);

    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
