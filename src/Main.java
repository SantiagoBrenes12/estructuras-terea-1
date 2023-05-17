
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int longitudArrayContrasenas = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Cuantas contraseñas quiere generar?"
            )
        );
        int longitudContrasenas = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Que longitud desea para estas contraseñas?"
            )
        );
        
        Password[] contrasenas = new Password[longitudArrayContrasenas];
        boolean[] seguridadContrasenas = new boolean[longitudArrayContrasenas];
        
        for (int i = 0; i < contrasenas.length; i++) {
            contrasenas[i] = new Password(longitudContrasenas);
            Password contrasena = contrasenas[i];
            seguridadContrasenas[i] = contrasena.esFuerte();
            boolean esFuerte = seguridadContrasenas[i];
            
            System.out.println(contrasena.getContrasena() + " " + esFuerte);
        }

    }
}
