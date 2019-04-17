package br.com.ccee.mvc;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import br.com.ccee.MainClass;

public class MainTest {

	@Test
	public void test() throws SQLException {
		MainClass.main(new String[] {"Hello CCEE"});
		assertTrue(true);
	}

}
