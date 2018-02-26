package sdk.fluig.com.example.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.model.ListItemType;
import sdk.fluig.com.example.utils.GuiUtils;

public class MainActivity extends AppCompatActivity implements MainFragment.Listener {

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //endregion

    //region MainFragment.Listener
    @Override
    public void onClickItem(ListItemType itemType) {
        switch (itemType) {
            //mode
            case FLOW:
            case COMPONENTS:
                showListOfType(itemType);
                break;

            //flows
            case LOGIN:
            case EULA:
                startFlowOfType(itemType);
                break;

            //components
            case BUTTON:
            case EDIT_TEXT:
            case GROUP_TEXT:
            case MEDIA_VIEW:
            case PAGER:
            case THUMB:
            case WEB_VIEW:
                showComponentOfType(itemType);
                break;

            default:
                break;
        }
    }
    //endregion

    //region Lists
    private void showListOfType(ListItemType type) {
        switch (type) {
            case FLOW:
                break;
            case COMPONENTS:
                break;
            default:
                GuiUtils.showToast(MainActivity.this, R.string.list_item_mode_notfound);
                break;
        }
    }
    //endregion

    //region Flows
    private void startFlowOfType(ListItemType type) {
        switch (type) {
            case LOGIN:
                break;
            case EULA:
                break;
            default:
                GuiUtils.showToast(MainActivity.this, R.string.list_item_flow_notfound);
                break;
        }
    }
    //endregion

    //region Components
    private void showComponentOfType(ListItemType type) {
        switch (type) {
            case BUTTON:
            case EDIT_TEXT:
            case GROUP_TEXT:
            case MEDIA_VIEW:
            case PAGER:
            case THUMB:
            case WEB_VIEW:
            default:
                GuiUtils.showToast(MainActivity.this, R.string.list_item_components_notfound);
                break;
        }
    }
    //endregion
}
