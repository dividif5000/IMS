package com.alumno.simulacionims;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public class Pin extends DialogFragment {

    private EditText pinEditText;

    public interface PinDialogListener {
        void onPinEntered(String pin);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // TODO Crea el layout del diálogo programáticamente
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(48, 32, 48, 32);

        // TODO Agrega un EditText para introducir el PIN
        pinEditText = new EditText(getActivity());
        pinEditText.setHint("Introduce un PIN de 4 cifras");
        pinEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        pinEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        pinEditText.setGravity(Gravity.CENTER);
        pinEditText.setTransformationMethod(new PasswordTransformationMethod());
        layout.addView(pinEditText);

        builder.setView(layout)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String pin = pinEditText.getText().toString();
                        PinDialogListener listener = (PinDialogListener) getActivity();
                        listener.onPinEntered(pin);
                        dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });

        return builder.create();
    }
}
