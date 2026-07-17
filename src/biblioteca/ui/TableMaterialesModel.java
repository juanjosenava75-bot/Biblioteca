package biblioteca.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import biblioteca.dominio.Material;
import biblioteca.dominio.Persona;

public class TableMaterialesModel extends AbstractTableModel{

     private String[] columnas = { "Titulo", "Autor", "Estado" };
    private List<Material> materials;

    public TableMaterialesModel(List<Material> materials) {
        this.materials = materials;

    }

    @Override
    public int getRowCount() {
        return materials.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Material m = materials.get(fila);

        switch (columna) {
            case 0:
                return m.getTitulo();
            case 1:
                return m.getAutor();
            case 2:
                return m.getEstado();
            default:
                return null;
        }

    }

    @Override

    public String getColumnName(int columna) {

        return columnas[columna];

    }

  

    // Método para borrar materiales
    public void borrarMaterial(int fila) {
        materials.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }

    public void agregarMaterial(Material m) {

        this.materials.add(m);
        fireTableRowsInserted(materials.size() - 1, materials.size() - 1);
        //Supongamos que la lista tenía 0 elementos.Agregás un usuario → ahora size = 1.El índice del nuevo elemento es size - 1 = 0.

    }

    public void actualizarMaterial(int fila, Material m) {
        
        materials.set(fila, m);//Reemplaza el objeto en la lista en la posición indicada (fila)
        fireTableRowsUpdated(fila, fila);

        //Recibe dos parámetros: firstRow y lastRow.

        //Si ponés (fila, fila), significa: “solo la fila número fila fue actualizada”.

        //El JTable entonces refresca únicamente esa fila en pantalla, sin redibujar toda la tabla.
    }

    public List<Material> getMaterials() {
        return materials;
    }

}
