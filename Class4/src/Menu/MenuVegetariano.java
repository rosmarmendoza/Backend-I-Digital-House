package ProyectoMenu;

public class MenuVegetariano extends Menu {

    private double precioBase;
    private int cantidadEspecias;
    private int cantidadSalsas;

    @Override

    public double calcularRecargo () {
        double total = 0;
        total = this.precioBase + ( 2 * this.cantidadSalsas) + (1.01 * this.cantidadEspecias);

        return total;

    }

    public String armado (){

        return "Al ser menú vegetariano, recuerda agregar las salsas y especias solicitadas ";

    }

}
