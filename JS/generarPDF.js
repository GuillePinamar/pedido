document.addEventListener("DOMContentLoaded", function(){
   
   addEventListener("click", function(){
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();
            
            const sect = document.querySelector('option').value;
            const fec = document.querySelector('#fecha').value;
            
            html2canvas(document.querySelector("#datosTabla")).then(canvas => {
            const imgData = canvas.toDataURL('image/png');
            const imgWidth = 190;
            const pageHeight = 190;
            const imgHeight = canvas.height * imgWidth / canvas.width;
            let heightLeft = imgHeight;

            let position = 30;
            
            doc.text(`Sector: ${sect}`, 10, 10);
            doc.text(`Fecha: ${fec}`, 10, 20);

            doc.addImage(imgData, 'PNG', 10,  position, imgWidth, imgHeight);
            heightLeft -= pageHeight;
            

            while (heightLeft >= 0) {
                position = heightLeft - imgHeight;
                doc.addPage();
                doc.addImage(imgData, 'PNG', 10,  position, imgWidth, imgHeight);
                heightLeft -= pageHeight;
        }
        doc.save('Pedido.pdf');
    });
   });
});

