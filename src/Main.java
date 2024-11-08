import java.util.Scanner;

public class Main {

    static int studSk, AtzSk;
    static String[] studenti;
    static int[][] atzimes;
    static int[] kriteriji;
    static double[] galavert;
    static Scanner sc = new Scanner(System.in);

    static void ievaditStudentusUnAtz() {
        System.out.print("Cik studenti būs kopumā? ");
        studSk = sc.nextInt();

        System.out.print("Cik atzīmes būs kopumā? ");
        AtzSk = sc.nextInt();

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


    public static void main(String[] args) {
        ievaditStudentusUnAtz();
    }
}