import java.util.ArrayList;

public class OfferingsCatalog {
    private ArrayList<Lesson> offerings = new ArrayList<>();
    private SpaceCatalog spaceCatalog;
    private TimeslotCatalog timeslotCatalog;

    public OfferingsCatalog(SpaceCatalog spaceCatalog, TimeslotCatalog timeslotCatalog) {
        this.spaceCatalog = spaceCatalog;
        this.timeslotCatalog = timeslotCatalog;
    }

    public void makeOffering(String activity, Timeslot timeslot, Space space, String id, boolean isPublic) {
        Lesson newOffering = new Lesson(activity, timeslot, space,id );

        if (isPublic) {
            newOffering.makeOfferingPublic();
        }

        if (!spaceCatalog.spaceExists(space.getAddress())) {
            System.out.println("Error: Space does not exist in the catalog.");
            return;

        }

        if(timeslotCatalog.timeslotExists(timeslot)){
            System.out.println("time slot already booked");
            return;
        }

        offerings.add(newOffering);
        System.out.println("offering created successfully");
    }

    public void viewPublicOfferings() {
        System.out.println("Public Offerings:");
        boolean hasPublicOfferings = false;

        for (Lesson offering : offerings) {
            if (offering.getIsPublic()) {
                System.out.println("ID: " + offering.getId() + ", Activity: " + offering.getActivity() + 
                                   ", Space: " + offering.getSpace().getAddress() +
                                   ", Date: " + offering.getTimeslot().getStartDate() + 
                                   " " + offering.getTimeslot().getEndDate() + " to " + 
                                   offering.getTimeslot().getEndDate() + "Time: " + offering.getTimeslot().getStartTime()+ "until "+ offering.getTimeslot().getEndTime());
                hasPublicOfferings = true;
            }
        }

        if (!hasPublicOfferings) {
            System.out.println("No public offerings available.");
        }
    }

    public void viewAllOfferings() {
        System.out.println("Offerings:");
        for (Lesson offering : offerings) {
            System.out.println("ID: " + offering.getId() + ", Activity: " + offering.getActivity() + 
            ", Space: " + offering.getSpace().getAddress() +
            ", Date: " + offering.getTimeslot().getStartDate() + 
            " " + offering.getTimeslot().getEndDate() + " to " + 
            offering.getTimeslot().getEndDate() + "Time: " + offering.getTimeslot().getStartTime()+ "until "+ offering.getTimeslot().getEndTime());
        }
    }

    public ArrayList<Lesson> getOfferings() {
        return offerings;
    }

}