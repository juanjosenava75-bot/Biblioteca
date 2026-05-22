package biblioteca.util;

import java.util.Comparator;

import biblioteca.dominio.Persona;

public class CompararPorApellido implements Comparator <Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        // TODO Auto-generated method stub
        return o1.getApellido().compareTo(o2.getApellido());
    }

}
