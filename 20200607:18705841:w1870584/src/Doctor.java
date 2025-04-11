public class Doctor extends Person{
    private int licenseNumber;

    private String specialisation;

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void initializeDocument(){
        setFirstName("A");
        setLastName("A");
        setDateOfBirth(2000, 11, 16);
        setSpecialisation("A");
        setLicenseNumber(0);
        setPhoneNumber(0);
    }
}
