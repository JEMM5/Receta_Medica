package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;


/**
 *
 * @author JONATHAN
 */

@WebServlet(name="ServletPDF", urlPatterns={"/ServletPDF"})
public class ServletPDF extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String alerg = "";
        
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        String genero = request.getParameter("genero");
        String edad = request.getParameter("edad1") + request.getParameter("edad2");
        String peso = request.getParameter("peso");
        String estatura = request.getParameter("estatura");
        String[] alergias = request.getParameterValues("alergia");
        String comentarios = request.getParameter("comentarios");
        String nombreMed = request.getParameter("nombreMed");
        String especialidad = request.getParameter("especialidad");
        String diagnostico = request.getParameter("diagnostico");
        String medicamentos = request.getParameter("medicamentos");
        String dosis = request.getParameter("dosis");
        
        String fechaNombre = "";
        for(int i=0;i<fecha.length();i++){
            for(int n=0; n<=9; n++){
                int sub = i + 1;
                String m = Integer.toString(n);
                if(fecha.substring(i,sub).equals(m)){
                    fechaNombre += fecha.substring(i,sub); 
                }
                
            }
        }
        
        
        Document documento = new Document();
        try{
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+ "/Desktop/"+id.trim() +fechaNombre +"form.pdf"));
            
            documento.open();
            
            PdfPTable tabla1 = new PdfPTable(1);
            tabla1.addCell("                            RECETA MÉDICA - CENTRO MÉDICO\n ");
            documento.add(tabla1);
            PdfPTable tabla = new PdfPTable(4);
            PdfPTable tabla3 = new PdfPTable(2);
            
            tabla.addCell("Fecha:");
            tabla.addCell(fecha);
            tabla.addCell("Hora");
            tabla.addCell(hora);
            tabla.addCell("Datos del Paciente");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("Nombre: ");
            tabla.addCell(nombre);
            tabla.addCell("No. Documento: ");
            tabla.addCell(id);
            tabla.addCell("Género: ");
            tabla.addCell(genero);
            tabla.addCell("Edad: ");
            tabla.addCell(edad);
            tabla.addCell("Peso: ");
            tabla.addCell(peso);
            tabla.addCell("Estatura: ");
            tabla.addCell(estatura);
            tabla.addCell("Alergias: ");
            for(String alergia : alergias){
            alerg += "[ "+alergia + " ]\n";
            } 
            tabla.addCell(alerg);
            tabla.addCell("Comentarios: ");
            tabla.addCell(comentarios);
            tabla.addCell("Datos del médico");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("Nombre: ");
            tabla.addCell(nombreMed);
            
            tabla.addCell("Especialidad: ");
            tabla.addCell(especialidad);
            tabla.addCell("Datos de la receta");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("");
            documento.add(tabla);
            tabla3.addCell("Diagnostico");
            tabla3.addCell(diagnostico);
            tabla3.addCell("Medicamentos: ");
            tabla3.addCell(medicamentos);
            tabla3.addCell("Dosis: ");
            tabla3.addCell(dosis);
            documento.add(tabla3);
            
            Paragraph pie = new Paragraph();
            pie.setAlignment(Paragraph.ALIGN_CENTER);
            pie.setFont(FontFactory.getFont("Lucida Sans Unicode", 14, Font.BOLD, BaseColor.BLACK));
            pie.add("\n\nClinica Médica | Formulario recectas");
            pie.setFont(FontFactory.getFont("Lucida Sans Unicode", 10, Font.NORMAL, BaseColor.BLACK));
            pie.add("\nCalle X AV. XX, Tel: 5555555");
            pie.setFont(FontFactory.getFont("Lucida Sans Unicode", 8, Font.NORMAL, BaseColor.BLACK));
            pie.add("\nDesarrollado por Jonathan Macias | Correo: jemacias464@misena.edu.co");
                        
            documento.add(pie);
            
            //
        }catch(DocumentException | FileNotFoundException e){
            e.printStackTrace();
        }
        
        try(PrintWriter out = response.getWriter()){
            response.setContentType("text/html;charset=UTF-8");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PDF generado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tu receta médica ha sido generada Exitosamente en PDF</h1>");
            out.println("<a href='/RecetaMedica'>Regresar</a>");
            out.println("</body>");
            out.println("</html>");
            
        }
        
        documento.close();
        
        String url = System.getProperty("user.home")+ "/Desktop/"+id.trim() +fechaNombre +"form.pdf";
        Runtime.getRuntime().exec("cmd /c start " + url);
        /*
        ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe",url);
        System.out.println(url);
        */
    }
    
}
