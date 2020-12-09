package faker;

import com.github.javafaker.Faker;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Locale;
import org.ceti.sistemas.proyectoceti.beans.Curso;
import org.ceti.sistemas.proyectoceti.beans.TipoCurso;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.CursoDao;

public class CursoData {

    public static void main(String[] args) {
        Conexion conn = new Conexion();
        CursoDao cursoDao = new CursoDao(conn.obtenerConexion());
        String[] diplomados = {"PHP", "Java Web", "Curso", "Taller", "Especialización"};
        for (String item : diplomados) {
            Curso curso = new Curso();
            curso.setNombre(item);
            Integer maximo = (item.length() < 20) ? item.length() : 20;
            curso.setNombre_corto(item.substring(0, maximo));
            curso.setImagen(CursoData.descargarImagenUrl(item));
            curso.setCosto(200.00);
            TipoCurso tipo_curso = new TipoCurso();
            tipo_curso.setId(1);
            curso.setTipo_curso(tipo_curso);
            cursoDao.registrar(curso);
        }

        String[] certificaciones = {"CCNA", "Office", "Android", "PMI"};
        for (String item : certificaciones) {
            Curso curso = new Curso();
            curso.setNombre(item);
            Integer maximo = (item.length() < 20) ? item.length() : 20;
            curso.setNombre_corto(item.substring(0, maximo));
            curso.setCosto(200.00);
            curso.setImagen(CursoData.descargarImagenUrl(item));
            TipoCurso tipo_curso = new TipoCurso();
            tipo_curso.setId(2);
            curso.setTipo_curso(tipo_curso);
            cursoDao.registrar(curso);
        }

        String[] cursos = {"Tienda Virtua", "Facturación Eletrónica"};
        for (String item : cursos) {
            Curso curso = new Curso();
            curso.setNombre(item);
            Integer maximo = (item.length() < 20) ? item.length() : 20;
            curso.setNombre_corto(item.substring(0, maximo));
            curso.setCosto(200.00);
            curso.setImagen(CursoData.descargarImagenUrl(item));
            TipoCurso tipo_curso = new TipoCurso();
            tipo_curso.setId(3);
            curso.setTipo_curso(tipo_curso);
            cursoDao.registrar(curso);
        }
    }

    public static String descargarImagenUrl(String nombreCuro) {
        Faker faker = new Faker(new Locale("es"));
        String nombreImagen = null;
        try {
            URL url = new URL(faker.internet().image(700, 400, false, "technics"));
            InputStream in = new BufferedInputStream(url.openStream());
            String path = new File(".").getCanonicalPath() + "/src/main/webapp/img/";
            // System.out.println(path);
            nombreImagen = nombreCuro + ".jpg";
            OutputStream out = new BufferedOutputStream(new FileOutputStream(path + nombreImagen));
            for (int i; (i = in.read()) != -1;) {
                out.write(i);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            nombreImagen = null;
        }
        return nombreImagen;
    }
}
