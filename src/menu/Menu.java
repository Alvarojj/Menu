package menu;

import javax.swing.JOptionPane;

public class Menu {

    // variables globales
    static int gen, gec;

    public static void main(String[] args) {
        //Variables locales
        int esw;
        char cop;
        int men[][] = new int[20][20];
        int ven[] = new int[20];
        String smenu;

        //Programa principal
        esw = 0;
        do {
            smenu = "1. leer matriz\n2. Escribir matriz\n3. Generar vector con positivos\n0. salir";
            cop = JOptionPane.showInputDialog(smenu).charAt(0);
            switch (cop) {
                case '1':
                    esw = 1;
                    Leer(men);
                    break;
                case '2':
                    if (esw == 0) {
                        JOptionPane.showMessageDialog(null, "Matriz no a sido leida", "Error", JOptionPane.WARNING_MESSAGE);

                    } else {
                        Escribir(men);
                    }
                    break;
                case '3':
                    if (esw == 0) {
                        JOptionPane.showMessageDialog(null, "Matriz no leida", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Vector(men, ven);
                    }
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Adios", "Saliendo...", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (cop != '0');

    }

    //procedimientos
    public static void Leer(int mat[][]) {
        // variables locales
        int ei, ek;

        // Proceso
        gen = Integer.parseInt(JOptionPane.showInputDialog("¿Filas?"));
        gec = Integer.parseInt(JOptionPane.showInputDialog("¿Columnas?"));

        for (ei = 1; ei <= gen; ei++) {
            for (ek = 1; ek <= gec; ek++) {
                mat[ei][ek] = Integer.parseInt(JOptionPane.showInputDialog("elemento" + ei + " , " + ek));
            }
        }
    }

    public static void Escribir(int mat[][]) {
        // variables locales 
        int ei, ek;
        String salida;
        // proceso
        salida = "";
        for (ei = 1; ei <= gen; ei++) {
            for (ek = 1; ek <= gec; ek++) {
                salida = salida + mat[ei][ek] + "   ";
            }
            salida = salida + "\n";
        }
        JOptionPane.showMessageDialog(null, salida, "matriz", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void Vector(int mat[][], int vec[]) {
        //variables locales 
        int ei, ek, et;
        String salida;

        // proceso
        et = 0;
        for (ei = 1; ei <= gen; ei++) {
            for (ek = 1; ek <= gec; ek++) {
               if (mat[ei][ek]>0){
                   et = et + 1;
                   vec[et] = mat[ei][ek];
               }
            }
        }
        salida = "";
        for (ei = 1; ei<= et; ei++){
            salida = salida + vec[ei] + "   ";
        }
        if (et ==0){
            JOptionPane.showMessageDialog(null, "la matriz no tiene numeros positivos", "salida", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, salida, "Vector de numeros positivos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
