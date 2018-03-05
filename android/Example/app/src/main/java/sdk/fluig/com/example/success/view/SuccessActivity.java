package sdk.fluig.com.example.success.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sdk.fluig.com.example.R;

public class SuccessActivity extends AppCompatActivity {

    public static final String ARG_FLOW_SOURCE = "SuccessActivity.FlowSource";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        setupView(getIntent().getExtras());
    }

    private void setupView(Bundle extras) {
        String flow = null;
        if (extras != null) {
            flow = extras.getString(ARG_FLOW_SOURCE);
        }

        TextView textView = findViewById(R.id.successActivity_tvFlowSource);

        if (flow == null) {
            textView.setVisibility(View.GONE);
        } else {
            String flowSource = getString(R.string.success_flow_source);
            flowSource = flowSource.replace("#flow", flow);

            textView.setVisibility(View.VISIBLE);
            textView.setText(flowSource);
        }
    }
}
