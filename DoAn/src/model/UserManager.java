package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class UserManager {
	private LinkedHashSet<User> guest;
	User user;
	int count = 0;

	public UserManager(LinkedHashSet<User> guest) {
		this.guest = guest;

	}

	public int getCount() {
		return this.count;
	}

	public UserManager() {
		this.guest = new LinkedHashSet<User>();
	}

	public void LoadUser(String fileName) throws IOException {
		Map<String, String> StoreUser = new LinkedHashMap<String, String>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String str;
		while ((str = reader.readLine()) != null) {
			StringTokenizer stringtoker = new StringTokenizer(str, "\t");
			if (stringtoker.countTokens() >= 2) {
				String userName = stringtoker.nextToken();
				String password = stringtoker.nextToken();
				this.guest.add(new User(userName, password));
			}

		}
		reader.close();

	}

	public void removePass(String username, String password) {
		for (User user : guest) {
			if (user.getUsername().equals(username)) {
				user.setPassword(password);
			}
		}
	}

	public void WriteUser(String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter write = new BufferedWriter(fw);
		for (User user : guest) {
			write.write(user.toString());
		}
		write.close();
		fw.close();
	}

	public boolean addUser(User user) {
		return guest.add(user);
	}

	public boolean isExits(String user, String pass) {

		for (User userName : guest) {
			count++;
			if (userName.getUsername().equals(user) && userName.getPassword().equals(pass)) {
				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {
		return "UserManager [guest=" + guest + "]";
	}

}