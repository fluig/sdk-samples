package sdk.fluig.com.example.utils;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by gregorysholl on 26/02/18.
 */

public class GuiUtils {

    private GuiUtils() {}

    public static void showToast(Context context, @StringRes int stringRes) {
        showToast(context, stringRes, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, @StringRes int stringRes, int length) {
        Toast.makeText(context, context.getString(stringRes), length).show();
    }

    public static void addFragment(AppCompatActivity activity,
                                   @IdRes int containerViewId,
                                   Fragment fragment,
                                   String tag) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentManager.beginTransaction().add(containerViewId, fragment, tag).commit();
        }
    }
}
