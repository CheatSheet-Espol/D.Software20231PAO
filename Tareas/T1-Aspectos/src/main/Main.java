package main;
import java.util.ArrayList;
import java.util.Scanner;
import interfaz.*;

public class Main {
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Discord android = new Android();
		Discord navegador = new Navegador();
		Discord ios = new AdapterToIOS();
		
		
		/*Usuario u1 = new Usuario("Carlos", "hola@gmail.com","si", false);
		Usuario u2 = new Usuario("Daniel", "chao@gmail.com","no", true);
		Usuario u3 = new Usuario("Angel", "gato@gmail.com","contraseña", false);
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);*/
		
		
		
		int opcionMenuPrincipalDiscord;
		int opcionMenuSecundario;
		int opcionMenutercero;
		boolean volverMenuPrincipal = false;
		do {
            mostrarMenuPrincipal();
            opcionMenuPrincipalDiscord = sc.nextInt();
            

            switch (opcionMenuPrincipalDiscord) {
                case 1:
                    System.out.println("\n\nBienvenido usuario Android!");
                    System.out.println("------------------------------------");
                    sc.nextLine();
                    do {
                    	mostrarMenuSecundario();
                    	opcionMenuSecundario = sc.nextInt();
                    	switch (opcionMenuSecundario) {
                        case 1:
                        	System.out.println("INGRESO");
                        	sc.nextLine();
                        	if(android.login(sc)) {
                       	 			do {
                       	 				mostrarMenuTercero();
                       	 				opcionMenutercero = sc.nextInt();

                       	 				switch (opcionMenutercero) {
                       	 				case 1:
                       	 					System.out.println("Mensaje");
                       	 					android.enviarMensaje(null, usuarios.get(0));
                       	 				break;
                       	 				case 2:
                       	 					System.out.println("Llamada");
                       	 					android.llamar(usuarios.get(0), usuarios.get(1));
                                        break;
                       	 				case 3:
                       	 					volverMenuPrincipal = true;
                                        break;
                       	 				default:
                       	 					System.out.println("Opción inválida. Intenta nuevamente.");
                                        break;
                       	 				}
                       	 			}while (opcionMenutercero != 0 && !volverMenuPrincipal);
                       	 			
                       	 			}
                    			 
                       	    break;
                    case 2:
                    	System.out.println("REGISTRO");
                       	android.crearUsuario(null, null, null, false);
                       	 
                       	break;
                    case 3:
                        volverMenuPrincipal = true; 
                        break;
                    default:
                         System.out.println("Opción inválida. Intenta nuevamente.");
                         break;
                        }
            	}while (opcionMenuSecundario != 0 && !volverMenuPrincipal);
                    
                    break;
                case 2:
                    System.out.println("\n\nBienvenido usuario de Navegador!");
                    System.out.println("------------------------------------");
                    sc.nextLine();
                    do {
                    	mostrarMenuSecundario();
                    	opcionMenuSecundario = sc.nextInt();
                    	switch (opcionMenuSecundario) {
                        case 1:
                        	System.out.println("INGRESO");
                       	 sc.nextLine();
                     	 if(navegador.login(sc)) {
                    	 			do {
                    	 				mostrarMenuTercero();
                    	 				opcionMenutercero = sc.nextInt();

                    	 				switch (opcionMenutercero) {
                    	 				case 1:
                    	 					System.out.println("Mensaje");
                    	 					navegador.enviarMensaje(null, usuarios.get(0));
                    	 				break;
                    	 				case 2:
                    	 					System.out.println("Llamada");
                    	 					navegador.llamar(usuarios.get(0), usuarios.get(1));
                                     break;
                    	 				case 3:
                    	 					volverMenuPrincipal = true;
                                     break;
                    	 				default:
                    	 					System.out.println("Opción inválida. Intenta nuevamente.");
                                     break;
                    	 				}
                    	 			}while (opcionMenutercero != 0 && !volverMenuPrincipal);
                    	 			
                    	 			}
                       	 break;
                        case 2:
                       	 	System.out.println("REGISTRO");
                       	 	navegador.crearUsuario(null, null, null, false);
                       	 
                       	 	break;
                        case 3:
                        	volverMenuPrincipal = true; 
                        	break;
                        default:
                            System.out.println("Opción inválida. Intenta nuevamente.");
                            break;
                        
                    	}
                    }while (opcionMenuSecundario != 0 && !volverMenuPrincipal);
                    
                    break;
                case 3:
                    System.out.println("\n\nBienvenido usuario IOS!");
                    System.out.println("------------------------------------");
                    sc.nextLine();
                    do {
                    	mostrarMenuSecundario();
                    	opcionMenuSecundario = sc.nextInt();
                    	switch (opcionMenuSecundario) {
                        case 1:
                        	System.out.println("INGRESO");
                        	sc.nextLine();
                        	 if(ios.login(sc)) {
                       	 			do {
                       	 				mostrarMenuTercero();
                       	 				opcionMenutercero = sc.nextInt();

                       	 				switch (opcionMenutercero) {
                       	 				case 1:
                       	 					System.out.println("Mensaje");
                       	 					ios.enviarMensaje(null, usuarios.get(0));
                       	 				break;
                       	 				case 2:
                       	 					System.out.println("Llamada");
                       	 					ios.llamar(usuarios.get(0), usuarios.get(1));
                                        break;
                       	 				case 3:
                       	 					volverMenuPrincipal = true;
                                        break;
                       	 				default:
                       	 					System.out.println("Opción inválida. Intenta nuevamente.");
                                        break;
                       	 				}
                       	 			}while (opcionMenutercero != 0 && !volverMenuPrincipal);
                       	 			
                       	 			}

                       	 break;
                        case 2:
                       	 	System.out.println("REGISTRO");
                       	 	ios.crearUsuario(null, null, null, false);
                       	 
                       	 	break;
                        case 3:
                        	System.out.println("\n");
                        	volverMenuPrincipal = true; 
                        	break;
                        default:
                            System.out.println("Opción inválida. Intenta nuevamente.");
                            break;
                        
                    	}
                    }while (opcionMenuSecundario != 0 && !volverMenuPrincipal);
                    break;
                case 0:
                    System.out.println("Gracias por tu visita, vuelve pronto!");
                    System.out.println("------------------------------------");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    break;
            }
        } while (opcionMenuPrincipalDiscord !=0);
		 
		sc.close();
		
      }
	 public static void mostrarMenuPrincipal(){
         System.out.println("==== Bievenido a Discord ====");
         System.out.println("------------------------------------");
         System.out.println("Selecciones su plataforma de inicio de sesión");
         System.out.println("------------------------------------");
         System.out.println("1. Android");
         System.out.println("2. Navegador");
         System.out.println("3. IOS");
         System.out.println("0. Salir");
         System.out.print("Selecciona una opción:");
     }
	 
	 public static void mostrarMenuSecundario(){
		 System.out.println("¿Qué deseas hacer?");
		 System.out.println("Selecciones una de las opciones");
         System.out.println("------------------------------------");
         System.out.println("1. Ingresar");
         System.out.println("2. Registrar");
         System.out.println("3. Volver al menú principal");
         System.out.print("Selecciona una opción:");
		 
	 }
	 public static void mostrarMenuTercero() {
		 
		 System.out.println("De qué manera quieres hablar con tus amigos?");
         System.out.println("------------------------------------");
         System.out.println("1. Mensaje");
         System.out.println("2. Texto");
         System.out.println("3. Salir");
         System.out.print("Selecciona una opción:");
		 
	 }
	 
}