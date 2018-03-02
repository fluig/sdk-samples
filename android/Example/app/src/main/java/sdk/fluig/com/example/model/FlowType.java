package sdk.fluig.com.example.model;

import android.content.Context;
import android.support.annotation.StringRes;

import sdk.fluig.com.example.R;

/**
 * Created by gregorysholl on 02/03/18.
 */

public enum FlowType implements ItemType {

    LOGIN   (R.string.list_item_flow_login),
    EULA    (R.string.list_item_flow_eula);

    @StringRes
    private final int mStringRes;

    FlowType(int stringRes) {
        mStringRes = stringRes;
    }

    //region ItemType
    @Override
    public String getString(Context context) {
        return context.getString(mStringRes);
    }
    //endregion
}
