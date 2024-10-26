document.addEventListener("DOMContentLoaded", function(){
     
     const pedidoList = document.getElementById("pediList");
     const pedidos = [];
   
     function cargarLista(){
         fetch("/appi/pedidos?action=getAll")
                 .then(response => response.json())
                 .then(data =>{
                     data.forEach(pedido =>{
                         pedidos.push(pedido);
                         pedidoList.innerHTML += `
                        <option value="${pedido.descripcion}">
                        `;
                 
                     });     
         });
         
     }     
     cargarLista();
 });
 

