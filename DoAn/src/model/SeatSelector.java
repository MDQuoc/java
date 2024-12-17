package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.SeatDisplayComponent;

public class SeatSelector {
	private static final int TOTAL_SEATS = 50;
	private static final int ROWS = 5;
	private static final int COLS = 10;

	private final JDialog seatDialog;
	private final JButton[] seats;
	private final boolean[] seatStatus;
	private final List<Integer> selectedSeatsList;
	private final SeatDisplayComponent displayComponent;

	public SeatSelector(JFrame parent, List<Integer> initialSelectedSeats, SeatDisplayComponent display) {
		this.seatDialog = new JDialog(parent, "Chọn Ghế Ngồi", true);
		this.seats = new JButton[TOTAL_SEATS];
		this.seatStatus = new boolean[TOTAL_SEATS];
		this.selectedSeatsList = new ArrayList<>(initialSelectedSeats);
		this.displayComponent = display;

		initializeDialog();
	}

	private void initializeDialog() {
		seatDialog.setSize(750, 400);
		seatDialog.setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		mainPanel.add(createSeatsPanel(), BorderLayout.CENTER);
		mainPanel.add(createLegendPanel(), BorderLayout.NORTH);
		mainPanel.add(createControlPanel(), BorderLayout.SOUTH);

		seatDialog.add(mainPanel);
	}

	private JPanel createSeatsPanel() {
		JPanel seatsPanel = new JPanel(new GridLayout(ROWS, COLS, 10, 10));
		for (int i = 0; i < TOTAL_SEATS; i++) {
			seats[i] = createSeatButton(i);
			seatsPanel.add(seats[i]);
		}
		return seatsPanel;
	}

	private JButton createSeatButton(int seatNumber) {
		String seatLabel;
		if (seatNumber < 20) {
			seatLabel = String.format("<html>V-%d</html>", seatNumber + 1);
		} else {
			seatLabel = String.format("<html>G-%d</html>", seatNumber + 1);
		}

		JButton seatButton = new JButton(seatLabel);
		seatButton.setFont(new Font("Arial", Font.BOLD, 12));
		seatButton.setPreferredSize(new Dimension(50, 50));
		updateSeatButton(seatButton, seatNumber);
		seatButton.addActionListener(e -> handleSeatClick(seatNumber));
		return seatButton;
	}

	private void updateSeatButton(JButton seat, int seatNumber) {
		if (seatStatus[seatNumber]) {
			seat.setBackground(Color.red);
			seat.setEnabled(false);
		} else {
			seat.setBackground(Color.GREEN);
			seat.setEnabled(true);
		}
	}

	private void handleSeatClick(int seatNumber) {

		if (!seatStatus[seatNumber] && confirmSeatSelection(seatNumber)) {

			if (!selectedSeatsList.isEmpty()) {
				int previousSeat = selectedSeatsList.get(0);
				seatStatus[previousSeat] = false;
				updateSeatButton(seats[previousSeat], previousSeat);
				selectedSeatsList.clear();
			}

			seatStatus[seatNumber] = true;
			selectedSeatsList.add(seatNumber);
			updateSeatButton(seats[seatNumber], seatNumber);
			displayComponent.updateDisplay(selectedSeatsList);
			showSelectionConfirmation(seatNumber);
		}
	}

	private JPanel createLegendPanel() {
		JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		legendPanel.setBorder(BorderFactory.createTitledBorder("Chú thích"));
		legendPanel.add(createLegendLabel("Ghế trống", Color.GREEN));
		legendPanel.add(createLegendLabel("Ghế đã đặt", Color.RED));
		return legendPanel;
	}

	private JLabel createLegendLabel(String text, Color color) {
		JLabel label = new JLabel(text);
		label.setOpaque(true);
		label.setBackground(color);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label.setPreferredSize(new Dimension(100, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}

	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		controlPanel.add(createControlButton("Xóa tất cả", e -> clearSelectedSeats()));
		controlPanel.add(createControlButton("Đặt ghế", e -> seatDialog.setVisible(false)));
		return controlPanel;
	}

	private JButton createControlButton(String text, java.awt.event.ActionListener action) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		return button;
	}

	private void clearSelectedSeats() {
		if (confirmClearSeats()) {
			selectedSeatsList.clear();
			for (int i = 0; i < TOTAL_SEATS; i++) {
				seatStatus[i] = false;
				updateSeatButton(seats[i], i);
			}
			displayComponent.updateDisplay(selectedSeatsList);
		}
	}

	private boolean confirmSeatSelection(int seatNumber) {
		return JOptionPane.showConfirmDialog(seatDialog, "Bạn muốn chọn Ghế " + (seatNumber + 1) + "?",
				"Xác nhận chọn ghế", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	private boolean confirmClearSeats() {
		return JOptionPane.showConfirmDialog(seatDialog, "Bạn có chắc muốn xóa tất cả ghế đã chọn?", "Xác nhận xóa",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	private void showSelectionConfirmation(int seatNumber) {
		JOptionPane.showMessageDialog(seatDialog, "Đã chọn Ghế " + (seatNumber + 1), "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void show() {
		seatDialog.setVisible(true);
	}

}