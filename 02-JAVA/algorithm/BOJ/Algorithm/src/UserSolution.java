class UserSolution
{
	static class List{
		Node tail;
		Node head[];
		int size;
		int charcnt[][];
		int ly,lx;
		
		public List(int y, int x) {
			head = new Node[y+1];
			size = x;
			charcnt = new int[y+1]['z'-'a'+1];
		}

		void init(char data[]) {
			Node first = new Node(data[0]);
			head[1] = first;
			tail = first;
			charcnt[1][data[0]-'a']++;
			int i = 1;
			for(; data[i] != '\0'; i++) {
				Node now = new Node(data[i]);

				if(i % size == 0) {head[i/size+1] = now;}
				charcnt[i/size + 1][data[0]-'a']++;
				
			}
		}
		
		static class Node{
			char data;
			Node next;
			
			public Node(char data) {
				super();
				this.data = data;
			}
			
		}
	}
	void init(int H, int W, char mStr[])
	{
		
	}
	
	void insert(char mChar)
	{

	}

	char moveCursor(int mRow, int mCol)
	{
		return '$';
	}

	int countCharacter(char mChar)
	{
		return -1;
	}
}