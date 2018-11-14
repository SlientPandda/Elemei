package com.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.javaee.utils.DAOFactory;

public class DAOFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNewInstance() {
		assertNotNull(DAOFactory.newInstance("UserDAO"));
	}

}
