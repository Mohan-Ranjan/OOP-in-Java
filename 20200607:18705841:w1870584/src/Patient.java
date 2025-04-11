public class Patient extends Person{
    private int patientIdentityCardNumber;

    public int getPatientIdentityCardNumber() {
        return patientIdentityCardNumber;
    }

    public void setPatientIdentityCardNumber(int patientIdentityCardNumber) {
        this.patientIdentityCardNumber = patientIdentityCardNumber;
    }

    public void initializePattern(){
        setFirstName("A");
    }
}
