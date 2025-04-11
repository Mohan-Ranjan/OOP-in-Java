import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        WestminsterSkinConsultationManager Main = new WestminsterSkinConsultationManager();
        Main.initialize();
        System.out.println("""
               A : Add doctor to the Center
               D : Delete Doctor from Center
               S : Save Data of Doctor to the file
               V : View Doctors of the Center
               Q : Quit from the Code
               """);
        String task = "";
        label:
        while(true){
            System.out.print("\nEnter the option to demonstrate task : ");
            task = userInput.nextLine();
            switch (task) {
                case "A" :
                    Main.addDoctor(WestminsterSkinConsultationManager.docList);
                    break;
                case "D":
                    Main.deleteDoctor(WestminsterSkinConsultationManager.docList);
                    break;
                case "V":
                    Main.documentView(WestminsterSkinConsultationManager.docList);
                    break;
                case "S":
                    Main.saveTextFile(WestminsterSkinConsultationManager.docList, 1);
                    break;
                case "Q":
                    Main.saveTextFile(WestminsterSkinConsultationManager.docList, 0);
                    break label;
                default:
                    System.out.println("Try the valid Input value.");
                    break;
            }
        }
    }
}
