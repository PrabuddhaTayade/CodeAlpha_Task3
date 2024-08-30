
package com.hotel.ui;

	import com.hotel.models.Reservation;
	import com.hotel.models.Room;
	import com.hotel.services.PaymentService;
	import com.hotel.services.ReservationService;
	import com.hotel.services.RoomService;

	import java.util.List;
	import java.util.Scanner;
public class ReservationSystem {


	    public static void main(String[] args) {
	        RoomService roomService = new RoomService();
	        ReservationService reservationService = new ReservationService();
	        PaymentService paymentService = new PaymentService();

	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n--- Hotel Reservation System ---");
	            System.out.println("1. Search Rooms");
	            System.out.println("2. Make Reservation");
	            System.out.println("3. View Reservations");
	            System.out.println("4. Process Payment");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter room category (Standard/Deluxe/Suite): ");
	                    String category = scanner.next();
	                    List<Room> availableRooms = roomService.searchAvailableRooms(category);
	                    if (availableRooms.isEmpty()) {
	                        System.out.println("No available rooms found in the " + category + " category.");
	                    } else {
	                        System.out.println("Available Rooms:");
	                        availableRooms.forEach(System.out::println);
	                    }
	                    break;
	                case 2:
	                    System.out.print("Enter room ID to book: ");
	                    int roomId = scanner.nextInt();
	                    Room room = roomService.findRoomById(roomId);
	                    if (room != null && room.isAvailable()) {
	                        System.out.print("Enter customer name: ");
	                        String customerName = scanner.next();
	                        System.out.print("Enter check-in date (YYYY-MM-DD): ");
	                        String checkInDate = scanner.next();
	                        System.out.print("Enter check-out date (YYYY-MM-DD): ");
	                        String checkOutDate = scanner.next();
	                        Reservation reservation = reservationService.makeReservation(room, customerName, checkInDate, checkOutDate);
	                        roomService.updateRoomAvailability(roomId, false);
	                        System.out.println("Reservation created successfully: " + reservation);
	                    } else {
	                        System.out.println("Room not available or invalid room ID.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Reservations:");
	                    List<Reservation> reservations = reservationService.getAllReservations();
	                    if (reservations.isEmpty()) {
	                        System.out.println("No reservations found.");
	                    } else {
	                        reservations.forEach(System.out::println);
	                    }
	                    break;
	                case 4:
	                    System.out.print("Enter reservation ID for payment: ");
	                    int reservationId = scanner.nextInt();
	                    Reservation reservation = reservationService.findReservationById(reservationId);
	                    if (reservation != null && !reservation.isPaid()) {
	                        boolean paymentSuccess = paymentService.processPayment(reservation.getTotalAmount());
	                        if (paymentSuccess) {
	                            reservation.setPaid(true);
	                            System.out.println("Payment successful. Reservation updated.");
	                        } else {
	                            System.out.println("Payment failed.");
	                        }
	                    } else {
	                        System.out.println("Invalid reservation ID or reservation already paid.");
	                    }
	                    break;
	                case 5:
	                    System.out.println("Exiting system...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 5);

	        scanner.close();
	    }
	}

