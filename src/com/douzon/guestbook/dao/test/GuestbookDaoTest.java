package com.douzon.guestbook.dao.test;

import java.util.List;

import com.douzon.guestbook.dao.GuestbookDao;
import com.douzon.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		getListTest();

	}
	
	public static void getListTest() {
		List<GuestbookVo> list = new GuestbookDao().getList();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}
}
