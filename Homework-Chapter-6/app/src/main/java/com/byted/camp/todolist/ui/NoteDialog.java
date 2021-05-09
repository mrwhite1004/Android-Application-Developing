package com.byted.camp.todolist.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.byted.camp.todolist.R;

public class NoteDialog extends Dialog implements View.OnClickListener{
    private EditText editText;
    private Button btCancel,btConfirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public void setCancel(IOnCancelListener cancelListener) {
        this.cancelListener=cancelListener;
    }
    public void setConfirm(IOnConfirmListener confirmListener){
        this.confirmListener=confirmListener;
    }

    public NoteDialog(@NonNull Context context) {
        super(context);

        btCancel.setOnClickListener(this);
        btConfirm.setOnClickListener(this);
    }

    public String getEditTextContent(){
        return editText.getText().toString();
    }

    public void setEditTextContent(String content){
        editText.setText(content);
    }

    @Override
    public void onClick(View view) {

    }
    public interface IOnCancelListener{
        void onCancel(NoteDialog dialog);
    }
    public interface IOnConfirmListener{
        void onConfirm(NoteDialog dialog);
    }
}
