public class Cruise {

    // Instance Variables
    private String cruiseName;
    private String cruiseShipName;
    private String departurePort;
    private String destination;
    private String returnPort;

    // Constructor - default
    Cruise() {
    }

    // Constructor - full
    Cruise(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        cruiseName = tCruiseName;
        cruiseShipName = tShipName;
        departurePort = tDeparture;
        destination = tDestination;
        returnPort = tReturn;
    }

    // Accessors
    public String getCruiseName() {
        return cruiseName;
    }

    public String getCruiseShipName() {
        return cruiseShipName;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDestination() {
        return destination;
    }

    public String getReturnPort() {
        return returnPort;
    }

    // Mutators
    public void setCruiseName(String tVar) {
        cruiseName = tVar;
    }

    public void setCruiseShipName(String tVar) {
        cruiseShipName = tVar;
    }

    public void setDeparturePort(String tVar) {
        departurePort = tVar;
    }

    public void setDestination(String tVar) {
        destination = tVar;
    }

    public void setReturnPort(String tVar) {
        returnPort = tVar;
    }

    // print cruise details
    // this method prints cruise details and spaces them to align with their correct column
    public void printCruiseDetails() {
        int spaceCount;
        String spaces = "";
        spaceCount = 20 - cruiseName.length();

        for (int i = 1; i <= spaceCount; i++) {
            spaces = spaces + " ";
        }

        System.out.println(cruiseName + spaces + cruiseShipName + "\t\t" +
                departurePort + "\t\t\t" + destination + "\t\t" + 
                returnPort + "\t\t");
    }
    // method added to print ship's name vice memory address
    @Override
    public String toString() {
        return cruiseName;
    }
}
