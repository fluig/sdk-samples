package sdk.fluig.com.example.main.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import sdk.fluig.com.example.R;
import sdk.fluig.com.example.model.ItemType;

/**
 * Created by gregorysholl on 26/02/18.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private WeakReference<Context> mContext;

    private ItemType[] mTypes;

    private OnClickListener mListener;

    public MainAdapter(Context context, ItemType[] types, OnClickListener listener) {
        mContext = new WeakReference<>(context);
        mTypes = types;
        mListener = listener;
    }

    /*package*/ void setTypes(ItemType[] types) {
        mTypes = types;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = mContext.get();
        if (context == null) {
            return null;
        }

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mTypes.length;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = mContext.get();
        if (context == null) {
            return;
        }

        final ItemType type = mTypes[position];

        holder.textView.setText(type.getString(context));
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClickItem(type);
                }
            });
        }
    }

    /*package*/ static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        /*package*/ ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.mainAdapter_textView);
        }
    }

    public interface OnClickListener {
        void onClickItem(ItemType itemType);
    }
}
