import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class UserSolution {
	class List {
		/*
		 * lastAdd ( tail 뒤에 붙이기 -> size가 작을 때 확장해주는 역할 ); updateData (at, key, value);
		 * ( 실질적으로 해당 위치에 데이터 넣어줌)
		 */
		Node head;
		Node tail;
		int size = 0;

		boolean checkNum(int at, String key) {
			Node nowNode = head;
			int nowat = 0;
			while (nowat < at) {
				nowNode = nowNode.next;
				nowat++;
			}
			return nowNode.keyMap.containsKey(key);
		}

		void makeSize(int targetSize) {
			if (head == null) {
				head = tail = new Node();
				size++;
			}
			while (targetSize >= size) {
				Node newNode = new Node();
				tail.next = newNode;
				tail = newNode;
				size++;
			}
		}

		void makeData(String name, int data[], int dataSize) {
			Node nowNode = head;
			for (int i = 0; i < dataSize; i++) {
				nowNode.keyMap.put(name, data[i]);
				nowNode = nowNode.next;
			}
		}

		void updateElement(int at, String key, int value) {
			Node nowNode = head;
			int nowat = 0;
			while (nowat < at) {
				nowNode = nowNode.next;
				nowat++;
			}
			if(nowNode.keyMap.containsKey(key))nowNode.keyMap.remove(key);
			nowNode.keyMap.put(key, value);
		}

		// 데이터 반환
		int element(int at, String mkey) {
			Node nowNode = head;
			int nowat = 0;
			while (nowat < at) {
				nowNode = nowNode.next;
				nowat++;
			}
			return nowNode.keyMap.get(mkey);
		}

		class Node {
			public HashMap<String, Integer> keyMap = new HashMap<>();
			public Node next;

		}
	}

	static HashMap<String, String> keyMap;
	static Set<String> deepSet;
	static Set<String> realSet;
	static List list;

	/*
	 * 1. makeList를 하면 mName을 key로 list에 데이터 저장 2. copyList를 하면 key에 mSrc이름을 value에
	 * mDest를 저장한다. 2-1. 깊은 복사 : deepCopy에도 저장한다. -> deepSet에서 값이 있으면 해당 키 값이 list에
	 * 있는지 탐색 후 없으면 key를 통해 원본을 찾는다. -> update 할 때에도 set을 통해 deepSet라는 것을 확인 하고
	 * list에 새로 key,value를 만든다. 2-2. 얕은 복사 : 다른 함수에서 호출 시 key 맵을 통해 value로 사용한다.
	 */
	public void init() {
		keyMap = new HashMap<>();
		deepSet = new HashSet<>();
		realSet = new HashSet<>();
		list = new List();
	}

	public void makeList(char mName[], int mLength, int mListValue[]) {

		String nowKey = "";
		for (int i = 0; i <= 20; i++) {
			if (mName[i] == '\0')
				break;
			nowKey += mName[i];

		}

		list.makeSize(mLength);
		list.makeData(nowKey, mListValue, mLength);
		realSet.add(nowKey);
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy) {
		String dopple = "";
		for (int i = 0; i <= 20; i++) {
			if (mDest[i] == '\0')
				break;
			dopple += mDest[i];
		}

		String origin = "";
		for (int i = 0; i <= 20; i++) {
			if (mSrc[i] == '\0')
				break;
			origin += mSrc[i];
		}

		// 깊은 복사
		if (mCopy) {
			deepSet.add(dopple);
		}
		keyMap.put(dopple, origin);

	}

	public void updateElement(char mName[], int mIndex, int mValue) {
		String name = "";
		for (int i = 0; i <= 20; i++) {
			if (mName[i] == '\0')
				break;
			name += mName[i];
		}
		if (realSet.contains(name)) list.updateElement(mIndex, name, mValue);
				
		else if (deepSet.contains(name)) list.updateElement(mIndex, name, mValue);
				
		else {
			while(keyMap.containsKey(name)) {
				name = keyMap.get(name);
				if(realSet.contains(name) || deepSet.contains(name))break;
			}
			list.updateElement(mIndex, name, mValue);
		}

	}

	public int element(char mName[], int mIndex) {
		String name = "";
		for (int i = 0; i <= 20; i++) {
			if (mName[i] == '\0')
				break;
			name += mName[i];
		}
		while(true) {
			if(realSet.contains(name))break;
			if(deepSet.contains(name)) {
				if(list.checkNum(mIndex, name))break;
			}
			if(!keyMap.containsKey(name))break;
			name = keyMap.get(name);
		}
		
		return list.element(mIndex, name);
	}
}