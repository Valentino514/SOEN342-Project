public class UnderageClient extends Client {
    
    private String guardianName;
    private String guardianPhone;

    // constructor
    public UnderageClient(String name, String password, String guardianName, String guardianPhone, int age) {
        super(name, password, age); 
        this.guardianName = guardianName;
        this.guardianPhone = guardianPhone;
    }

    // getters
    public String getGuardianName() {
        return guardianName;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    // Adding an offering for underage Client
    public void addOffering(Offering offering) {
        if(offering.addClient(this)){
        offerings.add(offering);
        System.out.println("guardian "+ this.getGuardianName() + " made a booking for " +this.getName()+", who is "+this.getAge()+" successfully");
        }
        else{
            System.out.println("error booking this offer");
        }
    }
    
    @Override
    public String getName() {
        return super.getName() + " (Underage)";
    }

    // print Guardian informations
    public void displayGuardianInfo() {
        System.out.println("Guardian Name: " + guardianName);
        System.out.println("Guardian Phone: " + guardianPhone);
    }

    public void setGuardianName(String name) {
        this.guardianName=name;
    }

    public void setGuardianPhone(String phone) {
        this.guardianPhone = phone;
    }

    public String getUnderageClientid() {
        return super.getUserId();
    }


}
