package sdk.fluig.com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gregorysholl on 26/02/18.
 */

public enum ListItemType implements Parcelable {
    //mode
    FLOW("Fluxos", 0),
    COMPONENTS("Componentes", 0),

    //flow
    LOGIN("Login", 1),
    EULA("Termos de Uso", 1),

    //components
    BUTTON("FluigSdkButton", 2),
    EDIT_TEXT("FluigSdkEditText", 2),
    GROUP_TEXT("FluigSdkGroupText", 2),
    MEDIA_VIEW("FluigSdkMediaView", 2),
    PAGER("FluigSdkPager", 2),
    THUMB("FluigSdkProfileThumb", 2),
    WEB_VIEW("FluigSdkWebView", 2);

    private final String mName;

    private final int mType;

    ListItemType(String name, int type) {
        mName = name;
        mType = type;
    }

    public String toString() {
        return mName;
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
        dest.writeString(mName);
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
