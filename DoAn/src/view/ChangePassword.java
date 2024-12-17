package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.ChangePassController;
import model.SavePass;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textField_matKhau;
	private JPasswordField textField_matKhauMoi;
	private JPasswordField textField_xacNhanMatKhau;
	private Demo demo;
	private ActionListener changeController;
	private SavePass savepass = new SavePass(LoginForm.class);

	public ChangePassword() {

		setTitle("Hệ Thống đặt vé máy bay");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);

		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		changeController = new ChangePassController(this);

		JPanel panel_ChangePass_Titile = new JPanel();
		panel_ChangePass_Titile.setBounds(83, 11, 264, 38);
		contentPane.add(panel_ChangePass_Titile);

		JLabel lblNewLabel = new JLabel("Thay đổi mật khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_ChangePass_Titile.add(lblNewLabel);

		JPanel panel_ChangePass_Label = new JPanel();
		panel_ChangePass_Label.setBounds(45, 57, 359, 131);
		contentPane.add(panel_ChangePass_Label);
		panel_ChangePass_Label.setLayout(null);

		JLabel jlabel_matKhau = new JLabel("Mật khẩu");
		jlabel_matKhau.setBounds(10, 11, 79, 23);
		panel_ChangePass_Label.add(jlabel_matKhau);

		JLabel jlabel_matKhauMoi = new JLabel("Mật khẩu mới");
		jlabel_matKhauMoi.setBounds(10, 45, 90, 14);
		panel_ChangePass_Label.add(jlabel_matKhauMoi);

		JLabel jlabel_xacNhanMatKhau = new JLabel("Xác nhận mật khẩu");
		jlabel_xacNhanMatKhau.setBounds(10, 70, 117, 29);
		panel_ChangePass_Label.add(jlabel_xacNhanMatKhau);

		textField_matKhau = new JPasswordField();
		textField_matKhau.setEchoChar('*');
		;
		textField_matKhau.setBounds(125, 12, 169, 20);
		panel_ChangePass_Label.add(textField_matKhau);
		textField_matKhau.setColumns(10);

		textField_matKhauMoi = new JPasswordField();
		textField_matKhauMoi.setEchoChar('*');
		textField_matKhauMoi.setBounds(125, 42, 169, 20);
		panel_ChangePass_Label.add(textField_matKhauMoi);
		textField_matKhauMoi.setColumns(10);

		textField_xacNhanMatKhau = new JPasswordField();
		textField_xacNhanMatKhau.setEchoChar('*');
		textField_xacNhanMatKhau.setBounds(125, 76, 172, 20);
		panel_ChangePass_Label.add(textField_xacNhanMatKhau);
		textField_xacNhanMatKhau.setColumns(10);

		JCheckBox chckbxHinThMt = new JCheckBox("hiển thị mật khẩu");
		chckbxHinThMt.setBounds(125, 103, 129, 23);
		panel_ChangePass_Label.add(chckbxHinThMt);

		JPanel panel_ChangePass_button = new JPanel();
		panel_ChangePass_button.setBounds(45, 199, 359, 38);
		contentPane.add(panel_ChangePass_button);
		panel_ChangePass_button.setLayout(null);

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(changeController);
		btnNewButton.setBounds(64, 11, 105, 23);
		panel_ChangePass_button.add(btnNewButton);
		getRootPane().setDefaultButton(btnNewButton);
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(changeController);
		btnNewButton_1.setBounds(202, 11, 89, 23);
		panel_ChangePass_button.add(btnNewButton_1);
		setVisible(true);
	}

	public String getMatKhauHienTai() {
		String matKhauHienTai = new String(textField_matKhau.getPassword());
		return matKhauHienTai;
	}

	public String getMatKhauMoi() {
		String matKhauMoi = new String(textField_matKhauMoi.getPassword());
		return matKhauMoi;
	}

	public String getXacNhanMatKhau() {
		String xacNhanMatKhau = new String(textField_xacNhanMatKhau.getPassword());

		return xacNhanMatKhau;
	}

	public boolean checkIsEmpty() {

		return getMatKhauHienTai().isEmpty() || getMatKhauMoi().isEmpty() || getXacNhanMatKhau().isEmpty();
	}

	public boolean checkPasswordCurrent() {

		return savepass.getPassword().equals(getMatKhauHienTai());
	}

	public boolean checkPassComfirm() {

		return getMatKhauMoi().equals(getXacNhanMatKhau());
	}

	public boolean checkLengthPass() {
		return getMatKhauMoi().length() <= 8;
	}

	public String getNewPassword() {
		return getMatKhauMoi();
	}
}
