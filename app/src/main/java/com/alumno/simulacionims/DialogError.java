package com.alumno.simulacionims;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

/**
 * @author David Ruiz Garcia
 * Objeto Molde que se usa para poder generar en las actividades siempre que se quiera un dialogo de error
 */
public class DialogError extends DialogFragment {

    //region Dialogo

    /**
     * Este método se utiliza para poder generar un dialogo de error para utilizar en otras actividades
     * @param savedInstancedState The last saved instance state of the Fragment,
     * or null if this is a freshly created Fragment.
     *
     * @return
     */
    public Dialog onCreateDialog(Bundle savedInstancedState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Mensaje")
                .setMessage("Error, debes de rellenar los campos especificados")
                .setCancelable(false)
                .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();
    }
    //endregion
}

