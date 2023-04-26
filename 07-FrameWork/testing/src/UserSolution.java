import java.util.*;

class UserSolution {

	static class Point implements Comparable<Point> {
		public int start;
		public int id;
		public int line;
		public int eque;
		public int time;

		public Point(int start, int id, int line, int eque, int time) {
			super();
			this.start = start;
			this.id = id;
			this.line = line;
			this.eque = eque;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return this.line - o.line;
		}

	}

	PriorityQueue<Point>[] line;
	Queue<Point>[] eq;
	HashMap<Integer, Integer> status;
	int linenow[];
	int eqnow[];
	HashMap<Integer, LinkedList<Point>> working;
	HashSet<Integer> wait;
	int time;

	void init(int L, int M) {
		line = new PriorityQueue[L + 1];
		for (int i = 0; i < L + 1; i++)
			line[i] = new PriorityQueue<>();
		eq = new LinkedList[M + 1];
		for (int i = 0; i < M + 1; i++)
			eq[i] = new LinkedList<>();
		status = new HashMap<>();
		linenow = new int[L + 1];
		for (int i = 0; i < L + 1; i++)
			linenow[i] = -1;
		eqnow = new int[M + 1];
		for (int i = 0; i < M + 1; i++)
			eqnow[i] = -1;
		working = new HashMap<>();
		wait = new HashSet<>();
		time = 1;
	}

	int request(int tStamp, int pId, int mLine, int eId, int mTime) {
		Point now = new Point(tStamp, pId, mLine, eId, mTime);
		line[now.line].add(now);
		eq[now.eque].add(now);
		status.put(pId, 1);
		wait.add(mLine);
		for (; time <= tStamp; time++)
			simulation(time);

		System.out.println((time-1) +" :  라인  : " + linenow[mLine]);
		return linenow[mLine];
	}

	private void simulation(int mTime) {
		if (working.containsKey(mTime)) {
			LinkedList<Point> end = working.get(mTime);
			for (Point del : end) {
				linenow[del.line] = -1;
				eqnow[del.eque] = -1;
				status.put(del.id, 3);
			}
		}
		HashSet<Integer> imm = new HashSet<>();
		for (int num : wait) {
			Point now = line[num].peek();
			Point nowEq = eq[now.eque].peek();
			if (linenow[now.line] == -1 && eqnow[now.eque] == -1 && nowEq.id == now.id) {
				line[num].poll();
				eq[now.eque].poll();
				linenow[now.line] = now.id;
				eqnow[now.eque] = now.id;

				status.put(now.id, 2);
				imm.add(num);

				if (working.containsKey(now.start + now.time))
					working.get(now.start + now.time).add(now);
				else {
					LinkedList<Point> im = new LinkedList<>();
					im.add(now);
					working.put(time + now.time, im);
				}

			}
		}
		for (int num : imm) {
			wait.remove(num);
		}
	}

	int status(int tStamp, int pId) {
		for (; time <= tStamp; time++)
			simulation(time);

		int answer = 0;
		if (status.containsKey(pId))
			answer = status.get(pId);

		System.out.println(time +" : 상태 : " +answer);
		return answer;
	}
}