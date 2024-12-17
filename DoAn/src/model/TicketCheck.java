package model;

import java.util.Random;

public class TicketCheck {
	private String flightcode;
	private String departure;
	private String arrival;
	private String passengerName;
	private String date;
	private String time;
	private String price;
	private String tax;
	private String total;
	private String id;
	private String phone;
	private String selectedSeats;

	// Constructor
	public TicketCheck(String departure, String arrival, String passengerName, String date, String time, String price,
			String tax, String total, String id, String phone, String selectedSeats) {
		this.departure = departure;
		this.arrival = arrival;
		this.passengerName = passengerName;
		this.date = date;
		this.time = time;
		this.price = price;
		this.tax = tax;
		this.total = total;
		this.id = id;
		this.phone = phone;
		this.selectedSeats = selectedSeats;
	}

	public String getFlightcode() {
		return flightcode;
	}

	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}

	// Getters and Setters
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(String selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public String generateFlightCode() {
		Random random = new Random();
		int number = 100 + random.nextInt(900);
		return "VN-" + number;
	}
}