package mx.edu.tesoem.isc.ciclovida2;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DatosModel extends ViewModel {
    List<Datos> lista = new ArrayList<>();
    public DatosModel(){}

    public DatosModel(List<Datos> lista){
        this.lista = lista;
    }
    public void agregar (Datos datos){
        lista.add(datos);
    }
    public List<Datos> getDatos(){
        return lista;
    }
}
