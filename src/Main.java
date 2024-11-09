import java.util.Scanner;

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
            System.out.println(studenti[i] + " gala atzīme: " + Math.round(galavert[i]));
        }
    }

    static void ievaditStudentusUnAtz() {
        do {
            System.out.print("Cik studenti būs kopumā? ");
            studSk = sc.nextInt();

            System.out.print("Cik atzīmes būs kopumā? ");
            AtzSk = sc.nextInt();

            if (studSk < 1) {
                System.out.println("Studentu daudzums nevar būt mazāks par 1!");
            }

            else if (AtzSk < 1) {
                System.out.println("Studentam jābūt vismaz vienai atzīmei, lai varētu izlikt gala vērtejumu!");
            }

        } while (studSk < 1 || AtzSk < 1);

        studenti = new String[studSk];
        atzimes = new int[studSk][AtzSk];
        kriteriji = new int[AtzSk];
        galavert = new double[studSk];

        for (int i = 0; i < studenti.length; i++) {
            System.out.print("Ievadi studenta vārdu: ");
            studenti[i] = sc.next();
            for (int j = 0; j < AtzSk; j++) {
                System.out.print("Ievadi šī studenta atzīmi: ");
                atzimes[i][j] = sc.nextInt();
            }
        }
    }

    static void vertesanasKrit() {
        int kriterijuSum = 0;

        System.out.println("Ievadi vērtēšanas kritērijus (%): ");
        for (int i = 0; i < kriteriji.length; i++) {
            do {
                System.out.print("Vērtēšanas kritērijs (%): ");
                kriteriji[i] = sc.nextInt();

                if (kriteriji[i] < 5 || kriteriji[i] > 100) {
                    System.out.println("Kritērijam jabūt robežās no 5% līdz 100%!");
                }

            } while (kriteriji[i] < 5 || kriteriji[i] > 100);
        }

        for (int i = 0; i < kriteriji.length; i++) {
            kriterijuSum += kriteriji[i];
        }

        if (kriterijuSum != 100) {
            System.out.println("Kritēriju summai jābūt 100%");
            vertesanasKrit();
        }
    }

    public static void main(String[] args) {
        ievaditStudentusUnAtz();
        vertesanasKrit();
        aprekinatVert();
    }
}
