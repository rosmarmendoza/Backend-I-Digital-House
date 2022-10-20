package ProyectoMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfantilTest {

    @Test

    public void probarCalcularElRecargo (){

      //GIVEN

        MenuInfantil pruebaRecargo = new MenuInfantil(1, 200.5);

      //WHEN

        double respuestaTest = pruebaRecargo.calcularRecargo();

      //THEN

        assertEquals(203.5, respuestaTest);
}
 @Test
    public void probarCalcularElRecargoIncorrecto(){

        //GIVEN

        MenuInfantil pruebaRecargoIncorrecto = new MenuInfantil (2, 100);

        //WHEN

        double respuestaTest = pruebaRecargoIncorrecto.calcularRecargo();

        //THEN

        assertEquals(107, respuestaTest);
    }

    @Test

    public void verificarTexto(){

        //GIVEN

        MenuInfantil pruebaTexto = new MenuInfantil(1);

        //WHEN

        String respuestaTest = pruebaTexto.armado();

        //THEN

        assertNotEquals("", respuestaTest);
    }
}
