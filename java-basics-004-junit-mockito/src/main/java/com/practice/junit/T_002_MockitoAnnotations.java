package com.practice.junit;

/**
 *	->	@Mock : We can use this annotation to mock any class or interface.
 *		@InjectMocks : To inject the mocks automatically.
 *		@RunWith(MockitoJUnitRunner.class) : to use @Mock, @InjectMocks , we need to use this annotation to run the tests.
 *		@Captor : To capture the arguments passed in the mock.
 *		@Spy : Instead of mock, we can spy the objects to be mocked for partial mocking.
 *	->	These annotations helps to reduce the complexity of code.
 *	->	We can use JUnit Rules. Using MockitoJUnit.rule() instead of @RunWith(MockitoJUnitRunner.class).
 */
public class T_002_MockitoAnnotations {

}
