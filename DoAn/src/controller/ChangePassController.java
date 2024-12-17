package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.SavePass;
import model.UserManager;
import view.ChangePassword;
import view.Demo;
import view.LoginForm;

public class ChangePassController implements ActionListener {
	private ChangePassword change;
	private UserManager usermanager = new UserManager();
	private Demo demo;
	private SavePass savepass = new SavePass(LoginForm.class);

	public ChangePassController(ChangePassword change) {
		this.change = change;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = savepass.getUsername();

		try {
			usermanager.LoadUser("src/data/user.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String getAction = e.getActionCommand();
		if (getAction.equals("Thoát")) {
			change.dispose();
		} else if (getAction.equals("Xác nhận")) {
			if (change.checkIsEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} else {
				if (!change.checkPasswordCurrent()) {

					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp mật khẩu cũ!", "thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (!change.checkPassComfirm()) {
						JOptionPane.showMessageDialog(null, "Mật khẩu mới, xác nhận mật khẩu không khớp!", "thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (change.checkLengthPass()) {
							JOptionPane.showMessageDialog(null, "Độ dài mật khẩu phải lớn hơn 8 ký tự!", "Thông báo",
									JOptionPane.ERROR_MESSAGE);
						} else {

							usermanager.removePass(username, change.getMatKhauMoi());
							savepass.removePassword("password");
							savepass.savePassword(change.getNewPassword());
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
							try {
								usermanager.WriteUser("src/data/user.txt");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							change.dispose();
						}
					}
				}
			}
		}
	}

}
