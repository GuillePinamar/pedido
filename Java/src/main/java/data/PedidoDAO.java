
package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class PedidoDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM material";
    
    public static List<Pedido>seleccionar(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido>pedidos = new ArrayList();
        
        try{
            conn = getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int idmaterial = rs.getInt(1);
                String descripcion = rs.getString("descripcion");
                
                pedido = new Pedido(idmaterial, descripcion);
                pedidos.add(pedido);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            try{
                close(rs);
                close(ps);
                close(conn);
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return pedidos; 
}
}
