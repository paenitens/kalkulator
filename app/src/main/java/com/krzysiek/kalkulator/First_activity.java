package com.krzysiek.kalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class First_activity extends AppCompatActivity implements View.OnClickListener{

    final Context context = this;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);

        Button Simple = (Button) findViewById(R.id.Simple);
        Button Advenced = (Button) findViewById(R.id.Advenced);
        Button Dialog = (Button) findViewById(R.id.Dialog);
        Button Exit = (Button) findViewById(R.id.Exit);

        Simple.setOnClickListener(this);
        Advenced.setOnClickListener(this);
        Exit.setOnClickListener(this);
        Dialog.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Simple) {
            Intent nowyEkran = new Intent(this, Simple_activity.class);
            startActivity(nowyEkran);
        } else if (v.getId() == R.id.Advenced) {
            Intent nowyEkran = new Intent(this, Advenced_activity.class);
            startActivity(nowyEkran);
        } else if (v.getId() == R.id.Dialog) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("dialog");

            // set dialog message
            alertDialogBuilder
                    .setMessage(" ")
                    .setCancelable(false)
                    .setPositiveButton("Wyjscie", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // current activity
                            First_activity.this.finish();
                        }
                    })
                    .setNegativeButton("Cofnij", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }

        else if (v.getId() == R.id.Exit) {
            finish();
        }

    }
}