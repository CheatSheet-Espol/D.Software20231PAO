package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.estructurales.facade.ejemplo1_Computer;

public class CPU {
    public void freeze() {
        System.out.println("CPU: Freezing...");
    }

    public void execute() {
        System.out.println("CPU: Executing...");
    }

    public void jump() {
        System.out.println("CPU: Jumping...");
    }
}
