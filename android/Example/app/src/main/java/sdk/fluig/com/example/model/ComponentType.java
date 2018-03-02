package sdk.fluig.com.example.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringRes;

import sdk.fluig.com.example.R;

/**
 * Created by gregorysholl on 02/03/18.
 */

public enum ComponentType implements ItemType, Parcelable {

    BUTTON      (R.string.list_item_components_button),
    EDIT_TEXT   (R.string.list_item_components_edittext),
    GROUP_TEXT  (R.string.list_item_components_grouptext),
    MEDIA_VIEW  (R.string.list_item_components_mediaview),
    WEB_VIEW    (R.string.list_item_components_webview);

    @StringRes
    private final int mStringRes;

    ComponentType(int stringRes) {
        mStringRes = stringRes;
    }

    //region ItemType
    @Override
    public String getString(Context context) {
        return context.getString(mStringRes);
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

    public static final Creator<ComponentType> CREATOR = new Creator<ComponentType>() {
        @Override
        public ComponentType createFromParcel(Parcel in) {
            return ComponentType.values()[in.readInt()];
        }

        @Override
        public ComponentType[] newArray(int size) {
            return new ComponentType[size];
        }
    };
    //endregion
}
