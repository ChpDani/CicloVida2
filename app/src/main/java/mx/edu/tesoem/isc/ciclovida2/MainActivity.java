package mx.edu.tesoem.isc.ciclovida2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView nombre, edad;
    EditText tnombre, tedad;
    Button btnagregar, btnmostrar;
    FloatingActionButton bfinfo;
    DatosModel datosModel;
    GridView gvdato;
    List<Datos> lista = new ArrayList<>();
    ArrayList<String> listagrid = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tnombre = findViewById(R.id.txtNombre);
        tedad = findViewById(R.id.txtEdad);
        btnagregar = findViewById(R.id.btnAgregar);
        btnmostrar = findViewById(R.id.btnMostrar);
        bfinfo = findViewById(R.id.BFA);
        gvdato = findViewById(R.id.gvdatos);


        datosModel = new ViewModelProvider(this).get(DatosModel.class);
        cargarGrid();

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datos datos = new Datos(tnombre.getText().toString(), Integer.valueOf(tedad.getText().toString()));
                datosModel.agregar(datos);
            }
        });

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listagrid.clear();
            cargarGrid();
            }
        });

        bfinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Barra de mensaje", Snackbar.LENGTH_LONG);
                Toast.makeText(MainActivity.this, "Mensaje", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void cargarGrid(){
        lista = datosModel.getDatos();
        listagrid.add("Nombre");
        listagrid.add("Edad");
        ArrayAdapter<String> adaptador;

        for(Datos datos : lista){
            listagrid.add(datos.getNombre());
            listagrid.add(String.valueOf(datos.getEdad()));
        }
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listagrid);
        gvdato.setAdapter(adaptador);
    }

}