package com.ssafy.hw.step2;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements IUserManager {

	private List<User> userList = new ArrayList<>();

	private final int MAX_SIZE = 100;

	private static UserManager um = new UserManager();

	private UserManager() {
	};

	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (userList.size() < MAX_SIZE) {
			userList.add(user);
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록 불가.");
		}
	}

	public User[] getList() {

		User[] res = new User[userList.size()];

		return this.userList.toArray(res);
	}

	public User[] getUsers() {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add(userList.get(i));
			}
		}

		User[] res = new User[list.size()];

		return list.toArray(res);

	}

	public VipUser[] getVipUsers() {

		List<VipUser> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add((VipUser) userList.get(i));
			}
		}
		
		VipUser[] res = new VipUser[list.size()];

		return list.toArray(res);

	}
	
	// 예외를 던진다고 선언
	public User[] searchByName(String name) ___________ ___________ {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				list.add(userList.get(i));
			}
		}
		
		// 주어진 단어를 포함하는 사용자가 없으면 예외를 던진다.
		if(list.size() == 0)
			_______ ____ _________________;
		
		User[] res = new User[list.size()];

		return list.toArray(res);
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}

		return sum / userList.size();

	}

}
