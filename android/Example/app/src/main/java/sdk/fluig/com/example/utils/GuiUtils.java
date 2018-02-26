package sdk.fluig.com.example.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by gregorysholl on 26/02/18.
 */

public class GuiUtils {

    private GuiUtils() {}

    public static void showToast(Context context, @StringRes int stringRes) {
        Toast.makeText(context, context.getString(stringRes), Toast.LENGTH_SHORT).show();
    }
}
