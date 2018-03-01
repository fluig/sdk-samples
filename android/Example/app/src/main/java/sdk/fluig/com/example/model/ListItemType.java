package sdk.fluig.com.example.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

import sdk.fluig.com.example.R;

/**
 * Created by gregorysholl on 26/02/18.
 */

public enum ListItemType implements Parcelable {
    //mode
    FLOW        (R.string.list_item_mode_flows, 0),
    COMPONENTS  (R.string.list_item_mode_components, 0),

    //flow
    LOGIN       (R.string.list_item_flow_login, 1),
    EULA        (R.string.list_item_flow_eula, 1),

    //components
    BUTTON      (R.string.list_item_components_button, 2),
    EDIT_TEXT   (R.string.list_item_components_edittext, 2),
    GROUP_TEXT  (R.string.list_item_components_grouptext, 2),
    MEDIA_VIEW  (R.string.list_item_components_mediaview, 2),
    THUMB       (R.string.list_item_components_profilethumb, 2),
    WEB_VIEW    (R.string.list_item_components_webview, 2);

    @StringRes
    private final int mStringRes;

    private final int mType;

    ListItemType(int stringRes, int type) {
        mStringRes = stringRes;
        mType = type;
    }

    public String getString(Context context) {
        return context.getString(mStringRes);
    }

    //region Helpers
    public static ListItemType[] allModes() {
        return getValuesOfType(0);
    }

    public static ListItemType[] allFlows() {
        return getValuesOfType(1);
    }

    public static ListItemType[] allComponents() {
        return getValuesOfType(2);
    }

    private static ListItemType[] getValuesOfType(int type) {
        List<ListItemType> list = new ArrayList<>();

        ListItemType[] values = ListItemType.values();
        for (ListItemType value: values) {
            if (value.mType == type) {
                list.add(value);
            }
        }

        return list.toArray(new ListItemType[list.size()]);
    }
    //endregion

    //region Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListItemType> CREATOR = new Creator<ListItemType>() {
        @Override
        public ListItemType createFromParcel(Parcel in) {
            return ListItemType.values()[in.readInt()];
        }

        @Override
        public ListItemType[] newArray(int size) {
            return new ListItemType[size];
        }
    };
    //endregion
}
