package testcase;

import huawei.Demo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

	@Test
	public void testNumber() {

		System.out.println("123 is number: " + Demo.isNumber("123"));
		System.out.println("000 is number: " + Demo.isNumber("000"));
		System.out.println("00.00 is number: " + Demo.isNumber("00.00"));
		System.out.println(".00 is number: " + Demo.isNumber(".00"));
		System.out.println("00. is number: " + Demo.isNumber("00."));
		System.out.println("+.00 is number: " + Demo.isNumber("+.00"));
		System.out.println("-.00 is number: " + Demo.isNumber("-.00"));
		System.out.println("+123.45 is number: " + Demo.isNumber("+123.45"));


		System.out.println("+123.45 is number: " + Demo.isNumber(" +123.45"));
		System.out.println("+123.45 is number: " + Demo.isNumber(" +123.45 "));
		System.out.println("+123.45 is number: " + Demo.isNumber("+123.45 "));
	}

	//����1:
	@Test
	public void testCase01() {
		String minuend = "85";
		String subtrahend = "79";
		String result = Demo.decrease(minuend, subtrahend);
		Assert.assertEquals(result, "6");

	}

	// ����2:
	@Test
	public void testCase02() {
		String minuend = "8.5";
		String subtrahend = "0.91";
		String result = Demo.decrease(minuend, subtrahend);
		Assert.assertEquals(result, "7.59");

	}

	// ����3:
	@Test
	public void testCase03() {
		String minuend = "8.5";
		String subtrahend = "7.5";
		String result = Demo.decrease(minuend, subtrahend);
		Assert.assertEquals(result, "1");

	}

	// ����4:
	@Test
	public void testCase04() {
		String minuend = "12.34";
		String subtrahend = "17.24";

		String result = Demo.decrease(minuend, subtrahend);
		Assert.assertEquals(result, "-4.9");

	}

	
}
