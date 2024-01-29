package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.estructurales.facade.ejemplo1_Computer;

public class User {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
