public class Demo {
    public static void main(String[] args) {
        System.out.println(new PlayerRefactored().playerChoice().toString());
        System.out.println(new PlayerRefactored());
        PlayerRefactored p1= new PlayerRefactored();
        PlayerRefactored p2= new PlayerRefactored();
        Match m1= new Match(p1,p2);
        System.out.println(m1);
        m1.mostrarEncabezado();
    }
}
