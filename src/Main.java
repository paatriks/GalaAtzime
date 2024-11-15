import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

    static int studSk, AtzSk;
    static String[] studenti;
    static int[][] atzimes;
    static int[] kriteriji;
    static double[] galavert;
    static Scanner sc = new Scanner(System.in);

    static void aprekinatVert() {
        for (int i = 0; i < studenti.length; i++) {
            for (int j = 0; j < AtzSk; j++) {
                galavert[i] += atzimes[i][j] * (kriteriji[j] / 100.0);
            }
            JOptionPane.showMessageDialog(null, studenti[i] + " gala atzīme: " + Math.round(galavert[i]), "Gala atzīme",  JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static void ievaditStudentusUnAtz() {
        do {
            
            studSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik studenti būs kopumā?", "Studentu skaits", JOptionPane.INFORMATION_MESSAGE));

            AtzSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Cik atzīmes būs kopumā?", "Atzīmju skaits", JOptionPane.INFORMATION_MESSAGE));

            if (studSk < 1) {
            	JOptionPane.showMessageDialog(null, "Studentu skaits nevar but mazāks par 1", "Error",  JOptionPane.ERROR_MESSAGE);
            }

            else if (AtzSk < 1) {
            	JOptionPane.showMessageDialog(null, "Studentam jābūt vismaz vienai atzīmei, lai sanāktu gala vērtējums", "Error",  JOptionPane.ERROR_MESSAGE);
            }

        } while (studSk < 1 || AtzSk < 1);

        studenti = new String[studSk];
        atzimes = new int[studSk][AtzSk];
        kriteriji = new int[AtzSk];
        galavert = new double[studSk];

        for (int i = 0; i < studenti.length; i++) {
            
            studenti[i] = JOptionPane.showInputDialog(null, "Ievadi " + (i+1) + ". studenta vārdu:", "Studentu vārdi", JOptionPane.INFORMATION_MESSAGE);
            for (int j = 0; j < AtzSk; j++) {
                do {
                    atzimes[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ievadi studenta " + (j+1) +  ". atzīmi:", "Studenta atzīme", JOptionPane.INFORMATION_MESSAGE));

                    if (atzimes[i][j] < 1 || atzimes[i][j] > 10) {
                    	JOptionPane.showMessageDialog(null, "Atzīme nevar būt mazāka par 1 vai lielāka par 10", "Error",  JOptionPane.ERROR_MESSAGE);
                    }
                } while (atzimes[i][j] < 1 || atzimes[i][j] > 10);
            }
        }
    }

    static void vertesanasKrit() {
        int kriterijuSum = 0;

       // JOptionPane.showConfirmDialog(null, "Ievadi vertesanas kriterijus", "Vertesanas kriteriji", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        for (int i = 0; i < kriteriji.length; i++) {
            do {
                kriteriji[i] = Integer.parseInt(JOptionPane.showInputDialog(null, + (i+1) + ". vērtēšanas kritērijs: ", "Vērtēšanas kritēriji", JOptionPane.INFORMATION_MESSAGE));

                if (kriteriji[i] < 5 || kriteriji[i] > 100) {
                	JOptionPane.showMessageDialog(null, "Kritērijam jābūt robežās no 5% līdz 100%", "Error",  JOptionPane.WARNING_MESSAGE);
                }

            } while (kriteriji[i] < 5 || kriteriji[i] > 100);
        }

        for (int i = 0; i < kriteriji.length; i++) {
            kriterijuSum += kriteriji[i];
        }

        if (kriterijuSum != 100) {
        	JOptionPane.showMessageDialog(null, "Kritēriju summai jābūt 100%", "Error",  JOptionPane.ERROR_MESSAGE);
            vertesanasKrit();
        }
    }

    public static void main(String[] args) {
        ievaditStudentusUnAtz();
        vertesanasKrit();
        aprekinatVert();
    }
}
