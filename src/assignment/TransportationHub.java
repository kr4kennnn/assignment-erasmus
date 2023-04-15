package assignment;

import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransportationHub implements Serializable {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        ArrayList<Ride> rideList = new ArrayList<Ride>();
        String make;
        String model;
        String licensePlate;
        int maxPassenger;
        float maxVolume;
        float maxWeight;
        int distance;
        int numOfPass;
        int count = 0;
        float volumeCargo;
        float weightCargo;

        Vehicle v1;
        v1 = new Van(6, 15, 20, true, true, "Mercedes", "GLA", "59TR867", (float) 5);
        vehicleList.add(v1);

        Vehicle c1;
        c1 = new Car(4, true, false, "Hyundai", "Sonata", "22TTR254", (float) 2.5);
        vehicleList.add(c1);

        Vehicle c2;
        c2 = new Car(5, true, false, "Audi", "A4", "34TR847", (float) 3.5);
        vehicleList.add(c2);

        Vehicle f1;
        f1 = new Freight(30, 50, false, true, "BMW", "M6", "SE224OP", (float) 8.8);
        vehicleList.add(f1);

        Vehicle f2;
        f2 = new Freight(35, 50, false, true, "Nissan", "Sunny", "TR201154", (float) 7.9);
        vehicleList.add(f2);

        while (true) {
            System.out.println("\nWhat do you want to do?:\n"
                    + "1.Add vehicle\n"
                    + "2.Modify vehicle\n"
                    + "3.See available vehicles\n"
                    + "4.See vehicles on ride\n"
                    + "5.Reserve a ride\n"
                    + "6.Finish a ride\n"
                    + "7.See the overview of the rides\n"
                    + "8.Sort vehicles by plate\n"
                    + "9.Sort rides by date and distance\n"
                    + "10.Write vehicle data to the file\n"
                    + "11.Read vehicle data from the file\n"
                    + "12.Write ride data to the file\n"
                    + "13.Read ride data from the file\n"
                    + "0.Exit the program");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("What do you want to add?:\n"
                            + "1.Car\n"
                            + "2.Van\n"
                            + "3.Freight");
                    int menu2 = input.nextInt();
                    switch (menu2) {
                        case 1:
                            input.nextLine();
                            System.out.println("Enter make: ");
                            make = input.nextLine();
                            System.out.println("Enter model: ");
                            model = input.nextLine();
                            System.out.println("Enter LPlate: ");
                            licensePlate = input.nextLine();
                            System.out.println("Enter max passenger count: ");
                            maxPassenger = input.nextInt();
                            vehicleList.add(new Car(maxPassenger, true, false, make, model, licensePlate, (float) 2.5));
                            break;
                        case 2:
                            input.nextLine();
                            System.out.println("Enter make: ");
                            make = input.nextLine();
                            System.out.println("Enter model: ");
                            model = input.nextLine();
                            System.out.println("Enter LPlate: ");
                            licensePlate = input.nextLine();
                            System.out.println("Enter max passenger count: ");
                            maxPassenger = input.nextInt();
                            System.out.println("Enter max volume: ");
                            maxVolume = input.nextFloat();
                            System.out.println("Enter max weight: ");
                            maxWeight = input.nextFloat();
                            vehicleList.add(new Van(maxPassenger, maxWeight, maxVolume, true, true, make, model, licensePlate, (float) 5.2));
                            break;
                        case 3:
                            input.nextLine();
                            System.out.println("Enter make: ");
                            make = input.nextLine();
                            System.out.println("Enter model: ");
                            model = input.nextLine();
                            System.out.println("Enter LPlate: ");
                            licensePlate = input.nextLine();
                            System.out.println("Enter max volume: ");
                            maxVolume = input.nextFloat();
                            System.out.println("Enter max weight: ");
                            maxWeight = input.nextFloat();
                            vehicleList.add(new Freight(maxWeight, maxVolume, false, true, make, model, licensePlate, (float) 8.8));
                            break;
                        default:
                            System.out.println("This is not a valid Menu Option! Please Select Another");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Which vehicle do you want to edit?");
                    for (int i = 0; i < vehicleList.size(); i++) {
                        System.out.println(i + 1 + ". " + vehicleList.get(i) + "\n");
                    }
                    int num = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter make: ");
                    vehicleList.get(num - 1).setMake(input.nextLine());
                    System.out.println("Enter model: ");
                    vehicleList.get(num - 1).setModel(input.nextLine());
                    System.out.println("Enter LPlate: ");
                    vehicleList.get(num - 1).setLicensePlate(input.nextLine());
                    break;
                case 3:
                    for (Vehicle vehicleList1 : vehicleList) {
                        if (vehicleList1.isAvailable()) {
                            System.out.println(vehicleList1);
                        }
                    }
                    break;
                case 4:
                    for (Vehicle vehicleList1 : vehicleList) {
                        if (vehicleList1.isAvailable() == false) {
                            System.out.println(vehicleList1);
                        }
                    }
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Start time for the ride? (DD/MM/YYYY hh:mm)");
                    String sDate1 = input.nextLine();
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sDate1);
                    System.out.println("End time for the ride? (DD/MM/YYYY hh:mm)");
                    String sDate2 = input.nextLine();
                    Date date2 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sDate2);

                    System.out.println("Enter the distance ib KM: ");
                    distance = input.nextInt();

                    System.out.println("for passenger/cargo?: ");
                    input.nextLine();
                    String inp = input.nextLine();

                    if (inp.equalsIgnoreCase("passenger")) {
                        System.out.println("Number of passengers: ");
                        numOfPass = input.nextInt();
                        System.out.println("Available vehicles:");
                        for (int i = 0; i < vehicleList.size(); i++) {
                            if (vehicleList.get(i).isForPassenger() && vehicleList.get(i).isAvailable()) {
                                System.out.println(i + 1 + ". " + vehicleList.get(i));
                                count++;
                            }
                        }
                    } else if (inp.equalsIgnoreCase("cargo")) {
                        System.out.println("Volume and veight of the cargo: ");
                        volumeCargo = input.nextFloat();
                        weightCargo = input.nextFloat();
                        System.out.println("Available vehicles:");
                        for (int i = 0; i < vehicleList.size(); i++) {
                            if (vehicleList.get(i).isForCargo() && vehicleList.get(i).isAvailable()) {
                                System.out.println(i + 1 + ". " + vehicleList.get(i));
                                count++;
                            }
                        }
                    } else {
                        System.out.println("Wrong input");
                        return;
                    }

                    if (count == 0) {
                        System.out.println("No vehicle could be found");
                        return;
                    } else {
                        System.out.println("Select vehicle number for your ride: ");
                        num = input.nextInt();
                        vehicleList.get(num - 1).setAvailable(false);
                        rideList.add(new Ride(vehicleList.get(num - 1), distance, date1, date2));
                        vehicleList.get(num - 1).calcRidePrice(distance, vehicleList.get(num - 1).getGasUsageKm());
                        vehicleList.get(num - 1).addTotal(distance);
                        System.out.println("Ride reserved.\n");
                    }
                    break;
                case 6:
                    System.out.println("Which ride do you want to finish?");
                    for (int i = 0; i < rideList.size(); i++) {
                        System.out.println(i + 1 + ". " + rideList.get(i) + "\n");
                    }
                    num = input.nextInt();
                    rideList.get(num - 1).setFinished(true);
                    System.out.println(rideList.get(num - 1).finalRidePrice());
                    System.out.println("Ride finished");
                    break;
                case 7:
                    rideList.forEach(rideList1 -> {
                        System.out.println(rideList1);
                    });
                    break;

                case 8:
                    Collections.sort(vehicleList, new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle o1, Vehicle o2) {
                            return o1.getLicensePlate().compareToIgnoreCase(o2.getLicensePlate());
                        }
                    }
                    );
                    vehicleList.forEach(vehicleList1 -> {
                        System.out.println(vehicleList1);
                    });
                    break;

                case 9:
                    //CUSTOM SORTING CODE FOR LISTING BY DATE
                    Collections.sort(rideList, new Comparator<Ride>() {
                        @Override
                        public int compare(Ride o1, Ride o2) {
                            return o1.getStartTime().compareTo(o2.getStartTime());
                        }
                    }
                    );
                    System.out.println("Listed by starting date:\n");
                    rideList.forEach(rideList1 -> {
                        System.out.println(rideList1);
                    });

                    //CUSTOM SORTING CODE FOR LISTING BY DISTANCE
                    Collections.sort(rideList, new Comparator<Ride>() {
                        @Override
                        public int compare(Ride o1, Ride o2) {
                            return o1.getDistance() - o2.getDistance();
                        }
                    }
                    );
                    System.out.println("\nListed by distance:\n");
                    rideList.forEach(rideList1 -> {
                        System.out.println(rideList1);
                    });
                    break;
                case 10:
                    try {
                    FileOutputStream writeData = new FileOutputStream("vehicledata.ser");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                    writeStream.writeObject(vehicleList);
                    writeStream.flush();
                    writeStream.close();                    
                    System.out.println("Successfully written to the file");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    try {
                    FileInputStream readData = new FileInputStream("vehicledata.ser");
                    ObjectInputStream readStream = new ObjectInputStream(readData);

                    ArrayList<Vehicle> vehicleList2 = (ArrayList<Vehicle>) readStream.readObject();
                    readStream.close();
                    for (Vehicle vehicleList1 : vehicleList2) {
                        System.out.println(vehicleList1);
                    }
                    } catch (Exception e) {
                     e.printStackTrace();
                    }
                    break;
                case 12:
                    try {
                    FileOutputStream writeData = new FileOutputStream("ridedata.ser");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                    writeStream.writeObject(rideList);
                    writeStream.flush();
                    writeStream.close();
                    System.out.println("Successfully written to the file");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                break;
                case 13:
                    try {
                    FileInputStream readData = new FileInputStream("ridedata.ser");
                    ObjectInputStream readStream = new ObjectInputStream(readData);

                    ArrayList<Ride> rideList2 = (ArrayList<Ride>) readStream.readObject();
                    readStream.close();
                    for (Ride rideList1 : rideList2) {
                        System.out.println(rideList1);
                    }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;
            }
        }
    }
}
