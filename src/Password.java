
import java.util.Random;

public class Password {

    private static final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private int longitud = 8;
    private String contrasena;

    public Password() {
        this.contrasena = this.generarPassword();
    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contrasena = this.generarPassword();
    }

    public boolean esFuerte() {
        int[] valoresDeComprobacion = obtenerValoresDeComprobacion();
        
        int numeros = valoresDeComprobacion[0];
        int mayusculas = valoresDeComprobacion[1];
        int minusculas = valoresDeComprobacion[2];
        
        //system.out.println("mayusculas: "+mayusculas+" minusculas: "+minusculas+"  numeros: "+numeros);
        
        if(mayusculas > 2 &&  minusculas>1 && numeros>5){
            return true;
        }
        
        return false;
    }

    private int[] obtenerValoresDeComprobacion() {
        int numeros = 0;
        int mayusculas = 0;
        int minisculas = 0;

        for (int i = 0; i < this.contrasena.length(); i++) {
            Character caracter = Character.valueOf(this.contrasena.charAt(i));

            if (Character.isDigit(caracter)) {
                numeros++;
                continue;
            }

            if (Character.isUpperCase(caracter)) {
                mayusculas++;
                continue;
            }

            if (Character.isLowerCase(caracter)) {
                minisculas++;
            }
        }
        
        return new int[] {numeros,mayusculas,minisculas};
    }

    private String generarPassword() {
        String contrasenaGenerada = "";
        Random random = new Random();

        for (int i = 0; i < this.getLongitud(); i++) {
            int randomNumber = random.nextInt(letras.length());
            contrasenaGenerada += letras.charAt(randomNumber);
        }

        return contrasenaGenerada;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContrasena() {
        return contrasena;
    }
}
