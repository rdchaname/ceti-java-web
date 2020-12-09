package faker;

import org.ceti.sistemas.proyectoceti.beans.TipoCurso;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.TipoCursoDao;

public class TipoCursoData {
    public static void main(String[] args) {
        Conexion conn = new Conexion();
        TipoCursoDao tipoCursoDao  = new TipoCursoDao(conn.obtenerConexion());
        String[] tipos = {"Diplomado", "Certificación", "Curso", "Taller", "Especialización"};
        for (String tipo : tipos) {
            TipoCurso tipo_curso =new TipoCurso();
            tipo_curso.setNombre(tipo);
            tipoCursoDao.registrar(tipo_curso);
        }
    }
}
