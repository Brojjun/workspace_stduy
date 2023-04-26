import java.util.HashMap;

class UserSolution
{
	int mainCnt;
	static int map[][];
	static HashMap<String, Integer> main;
	static HashMap<String,String> real;
	static HashMap<String,String> fake;
	static HashMap<String,Integer> update;
	static HashMap<String, String> reverse;
	
	public void init()
	{
		mainCnt = 0;
		map = new int[11][200001];
		main = new HashMap<>();
		real = new HashMap<>();
		fake = new HashMap<>();
		update = new HashMap<>();
		reverse = new HashMap<>();
	}

	private String getString(char name[]) {
		String a = "";
		int cnt = 0;
		int len = name.length;
		while(cnt < len) {
			if(name[cnt] == '\0')break;
			a += name[cnt++];
			}
		return a;
	}
	public void makeList(char mName[], int mLength, int mListValue[])
	{
		String name = getString(mName);
		main.put(name, mainCnt);
		for(int i = 0; i < mLength; i++) {
			map[mainCnt][i] = mListValue[i];
		}
		mainCnt++;
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy)
	{
		String fakename = getString(mDest);
		String realname = getString(mSrc);
		realname = find(realname);
		if(mCopy) {
			real.put(fakename,realname);
			reverse.put(realname, fakename);
		}
		else {
			fake.put(fakename, realname);
		}
	}

	private String find(String name) {
		while(fake.containsKey(name)) {
			name = fake.get(name);
		}
		return name;
	}
	
	public void updateElement(char mName[], int mIndex, int mValue)
	{
		String name = getString(mName);
		
		name = find(name);
		String keyname = name + mIndex;
			
		if(reverse.containsKey(name)) {
			String immname = reverse.get(name) + mIndex;
			if(!update.containsKey(immname))
				update.put(immname, element(name, mIndex));
		}
		update.put(keyname, mValue);
	}
	
	private int element(String name, int mIndex)
	{
		String keyname = "";
		int n = 0;
		while(true) {
			name = find(name);
			keyname = name + mIndex;
			if(update.containsKey(keyname)) {n = update.get(keyname); break;}
			
			if(main.containsKey(name)) {n = map[main.get(name)][mIndex]; break;}
			if(real.containsKey(name)) name = real.get(name);
		}
		return n;
	}
	
	public int element(char mName[], int mIndex)
	{
		String name = getString(mName);
		int n = 0;
		while(true) {
			name = find(name);
			String keyname = name + mIndex;
			if(update.containsKey(keyname)) {n = update.get(keyname); break;}
			
			if(main.containsKey(name)) {n = map[main.get(name)][mIndex]; break;}
			if(real.containsKey(name))name = real.get(name);
		}
		//System.out.println(n);
		return n;
	}
}