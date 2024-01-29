package FacadePattern;

public class FachadaTiendaMinorista implements Fachada {
    private Pweb plataformaWeb=new Pweb();
    private Pmovil plataformaMovil= new Pmovil();
    private Ptelefonica plataformaTelefonica= new Ptelefonica();

    public void usarElSistema(String plataforma){
        if (plataforma=="web"){
            plataformaWeb.activarDarkMode();
        }else if(plataforma=="movil"){
            plataformaMovil.escanearQr();
        }else if(plataforma=="telefonica"){
            plataformaTelefonica.consultarCatalogo();
        }else{
            System.out.println("No contamos con esa plataforma...");
        }
    }
}
