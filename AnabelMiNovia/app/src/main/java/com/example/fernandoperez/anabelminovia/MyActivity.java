package com.example.fernandoperez.anabelminovia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends AppCompatActivity {
    //Es buena práctica que estas keys tengan añadido el nombre del paquete como un prefijo, si esta
    //llave actúa con otra aplicación, se puede asegurar que las llaves serán únicas.
    public final static String EXTRA_MESSAGE = "com.example.fernandoperez.anabelminovia.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Con esta función, se crean los botones en la ActionBar. Cuando se infla el menú, debe
        //pasarse en .inflate() el recurso (en donde está el xml del action bar) y además, el menú
        //que entra a la función onCreateOptionsMenu.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my, menu);
        return super.onCreateOptionsMenu(menu);
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

    /** Called when the user clicks the Send button */
    public void sendMessage(View view){
        //Se recibe el intent que se crea cuando se pulsa el botón de enviar, se crea la nueva
        // actividad DisplayMessageActivity.
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Se recibe la vista que crea el Intent por id, en este caso, es el texto escrtito. Se
        //hace un cast para transformar el objeto en EditText, además, en R se tienen todos los
        //objetos de la aplicación, entonces, se busca el id utilizando los recursos que están en R.
        EditText editText = (EditText) findViewById(R.id.edit_message);
        //Se toma el texto que contiene editText, y se crea un String con él, que luego será mostrado.
        String message = editText.getText().toString();
        if(!(message.isEmpty())){
            //Se añaden datos extra al intent actual, en este caso, se añade el string que se acaba de
            //extraer de la vista. El nombre que tendrá en el intent es EXTRA_MESSAGE y su valor es message.
            //La función putExtra recibe como parámetros (String name, Parcelable[] value). Los extras
            //son colecciones de diccionarios(key-valor) que llevan consigo los intent. La key debe estar
            //definida en la actividad.
            intent.putExtra(EXTRA_MESSAGE, message);
            //Finalmente, se crea la nueva actividad, y tendrá los datos que tenga el Intent que se
            //recibe al comienzo, con el mensaje que se le añade después.
            startActivity(intent);
        }

    }
}
