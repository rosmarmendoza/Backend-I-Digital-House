package ProyectoMenu;

public class MenuInfantil extends Menu{

    private int cantidadJuguetes;
    private double precioBase;

    public MenuInfantil(int i) {
    }

    public MenuInfantil(int cantidadJuguetes, double precioBase) {
        this.cantidadJuguetes = cantidadJuguetes;
        this.precioBase = precioBase;
    }

    @Override

    public double calcularRecargo () {
        double total = 0;
        total = this.precioBase + ( 3 * this.cantidadJuguetes);

        return total;

    }

    public String armado (){

       return "Al ser menú infantil, recuerda agregar el juguete ";

    }
}


