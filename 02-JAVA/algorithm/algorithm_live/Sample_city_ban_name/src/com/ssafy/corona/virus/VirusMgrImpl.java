package com.ssafy.corona.virus;



public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			if (search(v.getName()) != null)
				throw new DuplicatedException(v.getName() +": " + "등록된 바이러스입니다.");
		} catch (NotFoundException | NullPointerException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		Virus[] v = new Virus[index];
		for (int i = 0 ; i < v.length; i++) {
			v[i] = virus[i];
		}
		return v;
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<index; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
	


}
