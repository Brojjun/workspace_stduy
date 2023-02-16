package com.ssafy.corona.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProblemMngImpl implements ProblemMng {
	List<Problem> list;
	
	private static ProblemMng instance = new ProblemMngImpl();
	
	private ProblemMngImpl() {
		list = new ArrayList<>();
	}
	
	public static ProblemMng getinstance() {
		return instance;
	}
	
	@Override
	public void save(String filename) {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
				){
			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String filename) {
		try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
				){
			list = (List<Problem>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void add(Problem problem) {
		
	}

}
