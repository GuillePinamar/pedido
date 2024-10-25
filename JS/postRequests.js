 document.addEventListener("DOMContentLoaded", function(){
      
        let contador = 1;
        
        document.getElementById('dataForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        const cant = document.getElementById('cantidad').value;
        const list = document.getElementById('lista').value;
        
        const tabla = document.getElementById('datosTabla').getElementsByTagName('tbody')[0];
        const nuevaFila = tabla.insertRow();
    
        const campoRp = nuevaFila.insertCell(0);
        const campoLista = nuevaFila.insertCell(1);
        const campoCant = nuevaFila.insertCell(2);
    
        campoRp.textContent = contador++;
        campoLista.textContent = list;
        campoCant.textContent = cant;
        
        document.getElementById('cantidad').value = "";
        document.getElementById('lista').value = "";
        });
    });
    

