package DISEÑO_DE_SOFTWARE.Patrones_de_diseño.estructurales.facade.ejemplo1_Computer;

public class ComputerFacade {
    private CPU cpu;
    private HardDrive hardDrive;
    private Memoria memory;

    public ComputerFacade(){
        this.cpu       = new CPU();
        this.hardDrive = new HardDrive();
        this.memory    = new Memoria();
    }

    public void start(){
        System.out.println("STARTING...");
        cpu.freeze();
        memory.load();
        hardDrive.read();
        cpu.jump();
        cpu.execute();
    }
}
