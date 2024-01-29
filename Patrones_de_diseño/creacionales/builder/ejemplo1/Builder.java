public interface Builder {
//De no ser interfaz, aqui puede ir un atributo de la clase del producto
    //protected Product p;
    /*public Product getProduct{
        return p
    }*/
    public void buildPartOne();
    public void buildPartTwo();
    public void buildPartThree();
    public Product getProduct();

}
