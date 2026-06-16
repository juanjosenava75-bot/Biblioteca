package biblioteca.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import biblioteca.dominio.Persona;

public class TableUsuarioModel extends AbstractTableModel {

    private String[] columnas = { "Nombre", "Apellido", "Dni", "Edad" };
    private List<Persona> personas;

    public TableUsuarioModel(List<Persona> personas) {
        this.personas = personas;

    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Persona p = personas.get(fila);

        switch (columna) {
            case 0:
                return p.getNombre();
            case 1:
                return p.getApellido();
            case 2:
                return p.getDni();
            case 3:
                return p.getEdad();

            default:
                return null;
        }

    }

    @Override

    public String getColumnName(int columna) {

        return columnas[columna];

    }

    // Método para agregar usuarios
    public void editarPersona(Persona p) {

    }

    // Método para borrar usuarios
    public void borrarPersona(int fila) {
        personas.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }

    public void agregarUsuario(Persona p) {

        this.personas.add(p);
        fireTableRowsInserted(personas.size() - 1, personas.size() - 1);
        //Supongamos que la lista tenía 0 elementos.Agregás un usuario → ahora size = 1.El índice del nuevo elemento es size - 1 = 0.

    }

    public void actualizarUsuario(int fila, Persona p) {
        
        personas.set(fila, p);//Reemplaza el objeto en la lista en la posición indicada (fila)
        fireTableRowsUpdated(fila, fila);

        //Recibe dos parámetros: firstRow y lastRow.

        //Si ponés (fila, fila), significa: “solo la fila número fila fue actualizada”.

        //El JTable entonces refresca únicamente esa fila en pantalla, sin redibujar toda la tabla.
    }

    public List<Persona> getPersonas() {
        return personas;
    }

}
