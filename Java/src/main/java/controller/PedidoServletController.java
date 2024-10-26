
package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.PedidoDAO;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

@WebServlet("/pedidos")
@MultipartConfig(
        location = "/Media/Temp",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10)

public class PedidoServletController extends HttpServlet{
    
    List<Pedido>pedidoList = new ArrayList();
    ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        
        String route = req.getParameter("action");
        
        switch(route){
            case "getAll"->{
                res.setContentType("application/json; charset=UTF-8");
                pedidoList = PedidoDAO.seleccionar();
                for(Pedido pedido : pedidoList){
                                       
                  }
                 mapper.writeValue(res.getWriter(), pedidoList);
        }
            default ->{
                System.out.println("Parametro no valido");
            }
        }
                
            }
        }
