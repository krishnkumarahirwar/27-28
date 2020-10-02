package com.capgemini.healthcaremanagementsystem;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcaremanagementsystem.dao.TestDao;
import com.capgemini.healthcaremanagementsystem.serviceimpl.AdminServiceImpl;

@SpringBootTest
public class TestAddTest {

	@Mock
	private TestDao dao;

	@InjectMocks
	private AdminServiceImpl service;

	@Test
	public void Addtest() {

//		Test test = new Test();
//		test.setTestId(1);
//		test.setTestName("Blood Test");
//		test.setTestPrice(354);
//		test.setCenterId(2);
//		service.addTest(test);
//		Mockito.verify(dao, Mockito.times(1).save(test));

	}

}
