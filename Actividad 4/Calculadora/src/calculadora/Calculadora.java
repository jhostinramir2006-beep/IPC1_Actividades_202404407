package calculadora;
import java.util.Scanner;

public class Calculadora{
        private static Scanner scanner = new Scanner(System.in);
        public static boolean salir;
    public static void suma(){
    int primer, segundo, resultado;
    System.out.println("Ingrese el primer número");
    primer=Integer.parseInt(scanner.nextLine());
    System.out.println("Ingrese el segundo número");
    segundo=Integer.parseInt(scanner.nextLine());
    resultado = primer + segundo;
    System.out.println("El resultado de la suma es: " + resultado);
    }
    //METODOS
    public static void resta(){
    int primer, segundo, resultado;
    System.out.println("Ingrese el primer número");
    primer=Integer.parseInt(scanner.nextLine());
    System.out.println("Ingrese el segundo número");
    segundo=Integer.parseInt(scanner.nextLine());
    resultado = primer - segundo;
    System.out.println("El resultado de la resta es: " + resultado);
    }
    public static void multiplicacion(){
    int primer, segundo, resultado;
    System.out.println("Ingrese el primer número");
    primer=Integer.parseInt(scanner.nextLine());
    System.out.println("Ingrese el segundo número");
    segundo=Integer.parseInt(scanner.nextLine());
    resultado = primer * segundo;
    System.out.println("El resultado de la multiplicacion es: " + resultado);
    }
    public static void division(){
    double primer, segundo, resultado;
    System.out.println("Ingrese el primer número");
    primer=Integer.parseInt(scanner.nextLine());
    System.out.println("Ingrese el segundo número");
    segundo=Integer.parseInt(scanner.nextLine());
    resultado = primer / segundo;
    if (segundo==0){
        System.out.println("Error: No se puede dividir entre 0");
    }else{
        System.out.println("El resultado de la divicion es: " + resultado);
    }
    }
    public static void potencia(){
    double primer, segundo, resultado;
    System.out.println("Ingrese el número de base");
    primer=Integer.parseInt(scanner.nextLine());
    System.out.println("Ingrese el número del exponente");
    segundo=Integer.parseInt(scanner.nextLine());
    resultado =Math.pow(primer, segundo);
    System.out.println("El resultado de la potencia es: " + resultado);
    }
    public static void raiz(){
    double primer, segundo, resultado;
    System.out.println("Ingrese el número del indice");
    primer=Integer.parseInt(scanner.nextLine());
    System.out.println("Ingrese el número del radicando");
    segundo=Integer.parseInt(scanner.nextLine());
    resultado =Math.pow(segundo,1.0 /primer);
    System.out.println("El resultado de la raiz es: " + resultado);
    }
    public static void leerMenuPrincipal(){
        try {
            String opcion;
            opcion = scanner.nextLine().trim();
             switch(opcion){
                case "uno":
                     suma();
                break;
                case "dos":
                     resta();
                break;
                case "tres":
                    multiplicacion();
                break;
                case "cuatro":
                     division();
                break;
                case "cinco":
                     potencia();
                break;
                case"seis":
                    raiz();
                break;
                 case "siete":
                     System.out.println("Saliendo....");
                    salir=true;
                 break;
                 default:
                 break;
               
            }
            
             } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
    }
    public static void imprimirMenuPrincipal(){
        salir=false;
        while(!salir){
            System.out.println("=============Menú de Operaciones=========");
            System.out.println("1. Suma ('uno')");
            System.out.println("2. Resta ('dos')");
            System.out.println("3. Multiplicación ('tres')");
            System.out.println("4. Division ('cuatro')");
            System.out.println("5. Potencia ('cinco)");
            System.out.println("6. Raiz ('seis')");
            System.out.println("7. Salir ('siete')");
            System.out.println("Elige una opción: ");
            leerMenuPrincipal();
        }
    }
    public static void main(String args[]){
        imprimirMenuPrincipal();
        
    }
}
    

