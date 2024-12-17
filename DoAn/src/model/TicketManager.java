package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketManager {
	public List<Ticket> ticketList;
	private static TicketManager instance;
	private List<TicketCheck> checks;

	public TicketManager(List<TicketCheck> checks) {
		super();
		this.checks = checks;
	}

	public TicketManager() {
		ticketList = new ArrayList<>();
		checks = new ArrayList<>();
		loadTickets();
	}
	 private void loadTickets() {
	        File file = new File("src/data/tickets.txt");
	        try (Scanner scanner = new Scanner(file)) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] data = line.split(",");
	                if (data.length == 5) {
	                    ticketList.add(new Ticket(
	                        data[0].trim(),
	                        data[1].trim(),
	                        data[2].trim(),
	                        data[3].trim(),
	                        data[4].trim()
	                    ));
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Không thể đọc file, sử dụng dữ liệu mặc định");
	        }
	    }

	// Getter for ticketList
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public static TicketManager getInstance() {
		if (instance == null) {
			instance = new TicketManager();
		}
		return instance;
	}

	public void addTicket(TicketCheck check) {
		checks.add(check);
	}

	public List<TicketCheck> getAllTickets() {
		return checks;
	}

	public void removeTicket(TicketCheck check) {
		checks.remove(check);
	}

}
