package com.example.homework1;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import javax.xml.transform.sax.TemplatesHandler;

public class SearchLayout extends LinearLayout {

    private EditText mEditText;
    private TextView mCancel;
    private OnSearchTextChangedListener mListener;
    public interface OnSearchTextChangedListener {

        void afterChanged(String text);

    }
    public SearchLayout(Context context) {
        super(context);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setOnSearchTextChangedListener(OnSearchTextChangedListener listener) {
        mListener = listener;
    }
    private void initView(){
        inflate(getContext(),R.layout.layout_search, this);
        mEditText=findViewById(R.id.edit);
        mCancel=findViewById(R.id.cancel);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mListener != null) {
                    mListener.afterChanged(s.toString());
                }
            }
        });
        mCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();

            }
        });
    }
}
