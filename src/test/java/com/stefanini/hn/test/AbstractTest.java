package com.stefanini.hn.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.stefanini.hn.constants.CallCenterConstants;

public class AbstractTest {

	static EntityManagerFactory emf;
	protected EntityManager em;
	
	@BeforeClass
	public static void setupStatic() {
		
		Persistence.generateSchema(CallCenterConstants.SCHEME, null);
		emf = Persistence.createEntityManagerFactory(CallCenterConstants.SCHEME);
		
	}
	@Before
	public void setup() {
		
		em = emf.createEntityManager();
	}
	@After
	public void tearDowm() {
		
		em.clear();
		em.close();
	}
	@AfterClass
	public static void tearDownStatic() {
		
		emf.close();
	}
}
