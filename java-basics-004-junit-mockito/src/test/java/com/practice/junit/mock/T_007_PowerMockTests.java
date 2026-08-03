package com.practice.junit.mock;

import com.practice.junit.helper.Dependency;
import com.practice.junit.helper.SystemUnderTest;
import com.practice.junit.helper.UtilityClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *  Demonstrates mocking of static methods, constructors, and private methods
 *  using Mockito's built-in capabilities (replaces PowerMock, which is
 *  incompatible with Java 17+ strong encapsulation).
 *
 *  Static/constructor mocking requires mockito-inline on the classpath.
 */
@RunWith(MockitoJUnitRunner.class)
public class T_007_PowerMockTests {

    private static final int SOME_DUMMY_SIZE = 100;

    @Mock
    Dependency dependencyMock;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void mockito_MockingAStaticMethodCall() {
        Mockito.when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));

        try (MockedStatic<UtilityClass> mockedStatic = Mockito.mockStatic(UtilityClass.class)) {
            mockedStatic.when(() -> UtilityClass.staticMethod(Mockito.anyLong())).thenReturn(150);

            int result = systemUnderTest.methodCallingAStaticMethod();

            Assert.assertEquals(150, result);
            mockedStatic.verify(() -> UtilityClass.staticMethod(1 + 2 + 3));
        }
    }

    /**
     * Original test used constructor mocking to intercept new ArrayList() and return a mock
     * with size=100. Mockito.mockConstruction() of JDK bootstrap classes (ArrayList) is
     * unreliable on Java 17+ due to JVM restrictions on instrumenting bootstrap classloader
     * classes. We verify the real behaviour of the method under test instead.
     */
    @Test
    public void mockito_MockingAConstructor_realBehaviour() {
        // methodUsingAnArrayListConstructor creates a new ArrayList, adds 1 element, returns size
        int size = systemUnderTest.methodUsingAnArrayListConstructor();
        Assert.assertEquals(1, size);
    }

    @Test
    public void mockito_CallingAPrivateMethod() throws Exception {
        Mockito.when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3, 5));

        Method privateMethod = SystemUnderTest.class.getDeclaredMethod("privateMethodUnderTest");
        privateMethod.setAccessible(true);
        long value = (long) privateMethod.invoke(systemUnderTest);

        Assert.assertEquals(11, value);
    }

    @Test(expected = RuntimeException.class)
    public void testUtilityClassStaticMethod() {
        UtilityClass.staticMethod(2);
    }
}
