
package ModelandoTabla;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class ModeloTabla  extends  DefaultTableModel{
    
 String[] titulos;
 Object[][] datos;
 
//
// Determina el modelo con el que se va a construir la tabla
// @param datos
// @param titulos
//
 public ModeloTabla(Object[][] datos, String[] titulos) {
  super();
  this.titulos=titulos;
  this.datos=datos;
  setDataVector(datos, titulos);
 }
 
 public ModeloTabla() {
  // TODO Auto-generated constructor stub
 }

 public boolean isCellEditable (int row, int column)
 {
     
  //Definimos si una celda puede ser o no editable
  if (column!=0 && column!=9){   
        
         return true;
        }else{
       return false; 
        }
 }
}
