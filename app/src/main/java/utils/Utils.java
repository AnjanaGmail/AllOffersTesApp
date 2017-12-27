package utils;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;

/**
 * Created by Anjana
 */

public class Utils {
    public static SpannableString formTitle(String title, String subTitle, int titleStyle, int subTitleStyle, Context context) {
        SpannableString styledText = null;
        int start = 0;
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(subTitle)) {
            String textData = title + "\n" + subTitle;
            styledText = new SpannableString(textData);
            styledText.setSpan(new TextAppearanceSpan(context, titleStyle), start, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            start = textData.indexOf("\n");
            styledText.setSpan(new TextAppearanceSpan(context, subTitleStyle), start, start + subTitle.length() + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return styledText;
    }

    public static void changeFragment(FragmentManager manager, @IdRes int layout, Fragment fragment, int transitionStyle)
    {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(layout, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.setTransition(transitionStyle);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commitAllowingStateLoss();
//        manager.executePendingTransactions();
    }
}
