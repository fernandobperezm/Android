package com.example.fernandoperez.anabelminovia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Como toda actividad es llamada por un Intent, entonces, se recibe el Intent que convocó a
        //esta actividad.
        Intent intent = getIntent();
        //Se recibe el string que viene en el Intent. Se tiene que saber cuál activity llama a esta
        // o por lo menos, donde está el string que se va a recibir.
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        //Se crea una nueva vista, un TextView, éste contendrá el mensaje que escribió el usuario
        //y se detallará en esta actividad con otras propiedades.
        TextView textView = new TextView(this);
        //Se cambia el tamaño del mensaje y además se detalla en el TextView cuál mensaje se mostrará.
        textView.setTextSize(40);
        textView.setText(message);
        //Ahora se añade la vista(TextView) que se acaba de crear en la actividad para que sea mostrado
        //en pantalla.
        setContentView(textView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Esta función la llama el sistema cuando un elemento de la Action Bar es presionado. Sin
        //embargo, debe preguntarse cuál elemento se presionó, para esto, se utiliza la función
        // getItemId() que devuelve el android:id del elemento que se presionó. Luego, se decide qué
        // acción debe realizarse.
        switch (item.getItemId()) {
            case R.id.action_search:
                //Cuando se presiona el botón de buscar, estas acciones se ejecutan.
                //openSearch(); Está comentada porque no se ha implementado.
                return true;

            case R.id.action_settings:
                //Cuando se presiona el botón de ajustes, estas acciones se ejecutan.
                //openSettings(); Está comentada porque no se ha implementado.
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
