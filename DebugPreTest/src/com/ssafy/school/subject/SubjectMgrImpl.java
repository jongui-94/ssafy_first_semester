package com.ssafy.school.subject;

public class SubjectMgrImpl implements SubjectMgr {
	private Subject[] virus;
	private int index = 0;

	public SubjectMgrImpl() {
		if (index < 100) {
			virus = new Subject[100];
		}
	}

	@Override
	public void add(Subject v) throws DuplicatedException {
		try {
			search(v.getName());
			throw new DuplicatedException(v.getName() + ": 등록된 과정입니다.");
		} catch (NotFoundException e) {
			virus[index++] = v;
		}
	}

	@Override
	public Subject[] search() {
		
		Subject[] tmp = new Subject[index];
		for(int i=0 ;i < index;++i)
		{
			tmp[i] = virus[i];
		}
		return tmp;
	}

//	@Override
//	public Subject search(String name) throws NotFoundException {
//		for (int i = 0; i < virus.length; i++) {
//			if (virus[i].getName().equals(name))
//				return virus[i];
//		}
//		return null;
//	}

	@Override
	public Subject search(String name) throws NotFoundException {
		try {
			for (int i = 0; i < virus.length; i++) {
				if (virus[i].getName().equals(name))
					return virus[i];
			}
		} catch (NullPointerException e) {
			throw new NotFoundException(name+": 미등록 과정입니다.");
		}
		
		return null;
	}
}
