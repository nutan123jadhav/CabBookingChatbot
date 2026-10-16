import java.util.Random;
import java.util.Scanner;

public class CabBookingChatbot {

    static Scanner sc = new Scanner(System.in);
    static boolean booked = false;

    static String route = "";
    static String cabType = "";
    static int distance = 0;
    static int fare = 0;

    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    static void bookCab() {
        if (booked) {
            System.out.println("You already have an active booking.");
            return;
        }

        System.out.println("\nSelect Route:");
        System.out.println("1. Pune to Mumbai (150 km)");
        System.out.println("2. Pune to Nashik (210 km)");
        System.out.println("3. Mumbai to Nashik (170 km)");
        System.out.print("Enter choice: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                route = "Pune to Mumbai";
                distance = 150;
                break;
            case 2:
                route = "Pune to Nashik";
                distance = 210;
                break;
            case 3:
                route = "Mumbai to Nashik";
                distance = 170;
                break;
            default:
                System.out.println("Invalid route choice.");
                return;
        }

        System.out.println("\nSelect Cab Type:");
        System.out.println("1. Mini (Rs. 10/km)");
        System.out.println("2. Sedan (Rs. 15/km)");
        System.out.println("3. SUV (Rs. 20/km)");
        System.out.print("Enter choice: ");

        int cabChoice = readInt();
        int rate;

        switch (cabChoice) {
            case 1:
                cabType = "Mini";
                rate = 10;
                break;
            case 2:
                cabType = "Sedan";
                rate = 15;
                break;
            case 3:
                cabType = "SUV";
                rate = 20;
                break;
            default:
                System.out.println("Invalid cab choice.");
                return;
        }

        fare = distance * rate;
        booked = true;

        System.out.println("\nCab booked successfully!");
        System.out.println("Route: " + route);
        System.out.println("Cab Type: " + cabType);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: Rs. " + fare);
    }

    static void viewBooking() {
        if (!booked) {
            System.out.println("No active booking found.");
            return;
        }

        System.out.println("\n--- Booking Details ---");
        System.out.println("Route: " + route);
        System.out.println("Cab Type: " + cabType);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: Rs. " + fare);
    }

    static void cancelBooking() {
        if (!booked) {
            System.out.println("No active booking to cancel.");
            return;
        }

        Random random = new Random();
        int otp = 1000 + random.nextInt(9000);

        System.out.println("Your cancellation OTP is: " + otp);
        System.out.print("Enter OTP to cancel booking: ");

        int enteredOtp = readInt();

        if (enteredOtp == otp) {
            booked = false;
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Incorrect OTP! Booking is not cancelled.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book a Cab");
            System.out.println("2. View Booking");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    bookCab();
                    break;
                case 2:
                    viewBooking();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.out.println("Thank you for using Cab Booking Chatbot!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}