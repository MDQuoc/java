package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.User;
import model.UserManager;
import view.RegistrationForm;

public class RegisterController implements ActionListener {
	RegistrationForm register;
	UserManager userManager = new UserManager();
	boolean checkAccount;

	public RegisterController(RegistrationForm register) {
		this.register = register;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if (action.equals("Đăng ký")) {
			// kiểm tra empty
			if (register.getRegisUserName().isEmpty() || register.getRegisPass().isEmpty()
					|| register.getRegisConfirmPass().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Thông báo",
						JOptionPane.ERROR_MESSAGE);

			} else { // nếu không empty kiểm tra mật khẩu có khớp hay không
				if (!register.getRegisPass().equals(register.getRegisConfirmPass())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!", "Thông báo", JOptionPane.ERROR_MESSAGE);
				} else { // mật khẩu khớp -> kiểm tra độ dài

					checkLengthPassword();
				}

			}

		}
		if (action.equals("Hủy")) {
			register.dispose();
		}
	}

	public void checkLengthPassword() {
		if (register.getRegisUserName().length() <= 8 && register.getRegisPass().length() <= 8) {
			JOptionPane.showMessageDialog(null, "Độ dài tài khoản và mật khẩu phải lớn hơn 8 ký tự!", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				userManager.LoadUser("src/data/user.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			User user1 = new User(register.getRegisUserName(), register.getRegisPass());

			if (userManager.addUser(user1)) {
				JOptionPane.showMessageDialog(null, "Đăng ký thành công!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				try {
					userManager.WriteUser("src/data/user.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				register.dispose();
			} else if (userManager.isExits(register.getRegisUserName(), register.getRegisPass())) {
				JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
