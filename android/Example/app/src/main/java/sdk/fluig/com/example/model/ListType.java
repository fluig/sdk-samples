package sdk.fluig.com.example.model;

import android.content.Context;
import android.support.annotation.StringRes;

import sdk.fluig.com.example.R;

/**
 * Created by gregorysholl on 02/03/18.
 */

public enum ListType implements ItemType {

    FLOW        (R.string.list_item_mode_flows),
    COMPONENTS  (R.string.list_item_mode_components);

    @StringRes
    private final int mStringRes;

    ListType(int stringRes) {
        mStringRes = stringRes;
    }

    //region ItemType
    @Override
    public String getString(Context context) {
        return context.getString(mStringRes);
    }
    //endregion
}
