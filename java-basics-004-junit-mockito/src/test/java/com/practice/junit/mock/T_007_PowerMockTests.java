package com.practice.junit.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import com.practice.junit.helper.Dependency;
import com.practice.junit.helper.SystemUnderTest;
import com.practice.junit.helper.UtilityClass;

/**
 * 	-> 	To Test Private, Static methods and Constructors - We can use PowerMock
 * 		Framework. -> We need to add dependency (powermock-api-mockito, powermock-module-junit4) for it.
 */
@SuppressWarnings({ "unchecked" })
@RunWith(PowerMockRunner.class)
@PrepareForTest({ UtilityClass.class })
public class T_007_PowerMockTests {

	private static final int SOME_DUMMY_SIZE = 100;

	@Mock
	Dependency dependencyMock;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void powerMockito_MockingAStaticMethodCall() {
		Mockito.when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
		PowerMockito.mockStatic(UtilityClass.class);
		Mockito.when(UtilityClass.staticMethod(Mockito.anyLong())).thenReturn(150);
		Assert.assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
		// To verify a specific method call
		// First : Call PowerMockito.verifyStatic()
		// Second : Call the method to be verified
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(1 + 2 + 3);
		// verify exact number of calls
		// PowerMockito.verifyStatic(Mockito.times(1));
	}

	@Test
	public void powerMockito_MockingAConstructor() throws Exception {
		ArrayList<String> mockList = mock(ArrayList.class);
		when(mockList.size()).thenReturn(SOME_DUMMY_SIZE);
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		Assert.assertEquals(1, size);
	}
	
	@Test
	public void powerMockito_CallingAPrivateMethod() throws Exception {
		when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3, 5));
		long value = (Long) Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		Assert.assertEquals(11, value);
	}
	
	@Test(expected=RuntimeException.class)
	public void testUtilityClassStaticMethod() {
		UtilityClass.staticMethod(2);
	}
}
