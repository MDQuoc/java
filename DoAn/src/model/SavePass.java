package model;

import java.util.prefs.Preferences;

public class SavePass {
	private Preferences prefs;

	public SavePass(Class<?> clazz) {
		prefs = Preferences.userNodeForPackage(clazz);

	}

	public void save(String username, String password) {
		prefs.put("username", username);
		prefs.put("password", password);
	}

	public void remove(String username, String pass) {
		prefs.remove(username);
		prefs.remove(pass);
	}

	public void removePassword(String pass) {
		prefs.remove(pass);
	}

	// Truy xuất thông tin username
	public String getUsername() {
		return prefs.get("username", "");
	}

	// Truy xuất thông tin password
	public String getPassword() {
		return prefs.get("password", "");
	}

	public void savePassword(String password) {
		prefs.get(password, "");
	}

	public boolean getCheckboxState(String key, boolean defaultValue) {
		return prefs.getBoolean(key, defaultValue); // Lấy giá trị boolean
	}

	public void saveCheckboxState(String key, boolean value) {
		prefs.putBoolean(key, value); // Lưu giá trị boolean vào Preferences
	}

}
