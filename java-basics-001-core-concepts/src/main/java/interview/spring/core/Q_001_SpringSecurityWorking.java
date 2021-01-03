package interview.spring.core;

/**
 * 	How does Spring Security works:
 * 	=============================
 * 	->	Spring security module make use of filter - DelegatingFilterProxy for achieving this.
 * 	->	And one of the Filter Spring uses is - AuthenticationFilter.
 * 	->	AuthenticationFilter
 * 		->	Spring uses this filter for authentication.
 * 	    ->  It passes inputs as credentials(Authentication) to AuthenticationManager and get
 * 	        output as principle(Authentication).
 * 	->	AuthenticationManager :
 * 		->	There can be many implementations for AuthenticationProvider for different type of
 * 			authentication like basic, oauth etc.
 * 		->	It has one method - authentication().
 * 	->	ProviderManager :
 * 		->	Implements the AuthenticationManager interface and helps to identify the providers.
 * 	->	AuthenticationProvider - Main provider which is actually responsible for authentication.
 * 		->	This interface has method - authenticate() which can be implemented.
 * 		->	method - supports() tells which type of authentication provider supports.
 * 		->	It takes inputs as credentials(Authentication) and provides output as user(Principle).
 * 	->	UserDetailsService:
 * 		->	Providers above make use of this service to retrieve user details and authentication.
 * 		->	method- loadUserByUserName().
 * 	->	Some Filter
 * 		->	Takes the authenticated principle for the user and associates it with the User Session.
 * 		->	Taking the SecurityContext from session and saving it to ThreadLocal and vice versa.
 */
public class Q_001_SpringSecurityWorking {
}
