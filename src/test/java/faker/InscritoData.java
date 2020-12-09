package faker;

import com.github.javafaker.Faker;
import java.util.Locale;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.beans.Usuario;
import org.ceti.sistemas.proyectoceti.dao.Conexion;
import org.ceti.sistemas.proyectoceti.dao.InscritoDao;
import org.ceti.sistemas.proyectoceti.dao.UsuarioDao;
import org.ceti.sistemas.proyectoceti.utils.Encriptacion;

public class InscritoData {

    public static void main(String[] args) {
        Conexion conn = new Conexion();
        InscritoDao inscritoDao = new InscritoDao(conn.obtenerConexion());
        UsuarioDao usuarioDao = new UsuarioDao(conn.obtenerConexion());
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < 100; i++) {
            Inscrito inscrito = new Inscrito();
            inscrito.setApellido_paterno(faker.name().lastName());
            inscrito.setApellido_materno(faker.name().lastName());
            inscrito.setNombres(faker.name().firstName());
            inscrito.setCelular(faker.phoneNumber().cellPhone());
            inscrito = inscritoDao.registrar(inscrito);
            // registrar usuarios
            Usuario usuario = new Usuario();
            usuario.setEmail(faker.internet().emailAddress());
            usuario.setPassword(Encriptacion.encriptarPassword("123456"));
            usuario.setInscrito(inscrito);
            usuarioDao.registrar(usuario);
        }
    }
}
