import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    static Doctor[] docList;
    static int doctorCount = 0;
    static String textFileString = "";
    static int fileHeader = 0;
    static Scanner userInput = new Scanner(System.in);

    @Override
    public void initialize() {
        docList = new Doctor [10];

        for(int i = 0; i < 10; i++){
            docList[i] = new Doctor();
            docList[i].initializeDocument();
        }
    }



    @Override
    public void documentView(Doctor[] docList) {
        if (doctorCount <= 0) System.out.println("No doctors in the Center");
        else {
            for (Doctor doctor : docList) {
                if (!doctor.getFirstName().equals("A")) {
                    int doctorAge = LocalDate.now().getYear() - doctor.getDateOfBirth().getYear();
                    System.out.println("Dr. " + doctor.getFirstName() + " " + doctor.getLastName() +
                            "\nLicense Number : " + doctor.getLicenseNumber() + "\nDate Of Birth : " + doctor.getDateOfBirth() +
                            "\nAge : " + doctorAge + "\nSpecialization : " + doctor.getSpecialisation()  +
                            "\nMobile Number : " + doctor.getPhoneNumber()
                    );
                }
            }
        }
    }

    @Override
    public void addDoctor(Doctor[] docList) {
        String firstName, lastName;
        int doctorLicenseNumber, year, month, day;

        fileHeader++;

        if(fileHeader == 1)
            textFileString += "W1870584 Consultation Appointment - " + LocalDate.now() + "\n\n";
        while (true) {
            System.out.print("Enter the doctor's First Name : ");
            firstName = userInput.nextLine();
            if (firstName.equals(""))
                System.out.print("Please Enter Name");
            else {
                docList[doctorCount].setFirstName(firstName);
                break;
            }

        }
        while (true){
            System.out.print("Enter the doctor's Last Name : ");
            lastName = userInput.nextLine();
            if (lastName.equals(""))
            {
                System.out.println("Enter the Name Please : ");
            }
            else {
                docList[doctorCount].setLastName(lastName);
                break;
            }
        }

        while (true){

            System.out.print("Enter the birth year : ");
            year = userInput.nextInt();

            if (year > 1995 || year < 1960) {
                System.out.println("Enter a valid year.\n");
            } else
                break;
        }

        while (true) {
            System.out.print("Enter the birth month : ");
            month = userInput.nextInt();

            if (month > 13 || month < 0) {
                System.out.println("Enter a valid month.\n");
            } else
                break;
        }

        while (true) {
            System.out.print("Enter the birth date : ");
            day = userInput.nextInt();

            if (day > 32 || day < 0) {
                System.out.println("Enter a valid date.\n");
            } else{
                docList[doctorCount].setDateOfBirth(year, month, day);
                break;
            }
        }

        while (true) {
            boolean same = true;
            System.out.print("Enter the doctor's License number : ");
            doctorLicenseNumber = userInput.nextInt();

            if (doctorLicenseNumber == 0)
                System.out.println("Enter the doctor's License number.\n");
            else {
                docList[doctorCount].setLicenseNumber(doctorLicenseNumber);
                userInput.nextLine();
                break;
            }
        }


        while (true) {
            System.out.print("Enter doctor's Specialization  : ");
            docList[doctorCount].setSpecialisation(userInput.nextLine());
            if (docList[doctorCount].getSpecialisation().equals(""))
                System.out.println("Enter the specialization.");
            else
                break;
        }


        while (true) {
            System.out.print("Enter the doctor's Mobile Number : ");
            docList[doctorCount].setPhoneNumber(userInput.nextInt());
            if (docList[doctorCount].getPhoneNumber() == 0)
                System.out.println("Enter Phone Number");
            else {
                userInput.nextLine();
                break;
            }
        }

        textFileString +="Doctor added to the Center :" +
                "\nDoctor Name - " + firstName + " " + lastName +
                "\nDr.  " + firstName + " " + lastName + "'s License Number : " + docList[doctorCount].getLicenseNumber() +
                "\nDr. "  + firstName + " " + lastName + "'s Specialization : " + docList[doctorCount].getSpecialisation()+
                "\nDr. "  + firstName + " " + lastName + "'s Date Of Birth : " + docList[doctorCount].getDateOfBirth()+
                "\nDr. "  + firstName + " " + lastName + "'s Age : " + " " + (LocalDate.now().getYear() -
                docList[doctorCount].getDateOfBirth().getYear()
                + "\n\n");
        doctorCount++;
    }

    @Override
    public void deleteDoctor(Doctor[] docList) {
        int docLicenseNo;
        System.out.println("Doctors Name and license number mentioned below.");

        for (Doctor dr: docList){
            if (!dr.getFirstName().equals("A")){
                System.out.println("\nDr. " + dr.getFirstName() +" " + dr.getLastName()+
                        "\nLicense number : " + dr.getLicenseNumber());
            }
        }

        while(true){
            System.out.print("\nEnter the doctor's License number to remove from Consultancy : ");
            docLicenseNo = userInput.nextInt();
            if (docLicenseNo == 0)
                System.out.println("Number not entered.\n");
            else{
                userInput.nextLine();
                break;
            }
        }

        for(int i = 0; i < docList.length;){
            if (docLicenseNo == docList[i].getLicenseNumber()){
                System.out.println("Dr. " + docList[i].getFirstName() + " " + docList[i].getLastName() + " removed from the list.");
                textFileString +="Doctor removed from the Consultancy +" + "\nDoctor Name :  " + docList[i].getFirstName() +
                        " " + docList[i].getLastName() + "\nDr.  " + docList[i].getFirstName() + " " + docList[i].getLastName() +
                        "'s License Number : " + docList[i].getLicenseNumber() + "\n\n";
                docList[i].initializeDocument();
                i++;
                break;
            }
        }
    }

    @Override
    public void saveTextFile(Doctor[] docList, int programEnds) throws IOException {
        FileWriter writeFile = new FileWriter("W1870584_File.txt", true);
        if(programEnds == 0){
            for(int i = 0; i < docList.length; i++){
                if (!docList[i].getFirstName().equals("A")){
                    textFileString +="   Dr. " + docList[i].getFirstName() +" " + docList[i].getLastName()+
                            "\n   Doctor's License Number : " + docList[i].getLicenseNumber()+
                            "\n   Doctor's Specialisation : " + docList[i].getSpecialisation() +
                            "\n   Doctor's Mobile Number : " + docList[i].getPhoneNumber() +
                            "\n   Doctor's Date Of Birth : " + docList[i].getDateOfBirth() + "\n" +
                            "\n   Doctor's Age " + (LocalDate.now().getYear() - docList[i].getDateOfBirth().getYear()) +"\n";
                }
            }
            textFileString += "\n\n\n";
            writeFile.write(textFileString);
            writeFile.close();
        }
    }

}
