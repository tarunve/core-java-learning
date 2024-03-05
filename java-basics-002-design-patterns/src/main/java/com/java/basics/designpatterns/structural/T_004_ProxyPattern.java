package com.java.basics.designpatterns.structural;

/*
 * 	->	Provide a surrogate  or placeholder for another object to control access to it.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To provide controlled access to a sensitive master object.
 * 	2.	To provide a local reference to a remote object.
 * 	3.	To improve performance when an object needs to be accessed frequently.
 *
 * 	Benefits:
 * 	--------
 * 	1.	A proxy can mask the life-cycle and state of a volatile resource from its client.
 * 	2.	Easy to manage the access to the real object.
 * 	3.	Proxies can help in creating objects on-demand.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	Performance may be impacted due to the extra level of indirection.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Agents with power of Attorney
 * 	2.	Representatives/Brokers
 *
 * 	Software Example
 * 	----------------
 * 	1.	SSH Client
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	java.lang.reflect.Proxy
 * 	2.	java.rmi.*
 * 	3.	java.ejb.EJB
 * 	4.	javax.inject.Inject
 */
public class T_004_ProxyPattern {
	
	/*
	 * Create an interface. Both the real subject and proxy subject will implement this interface.
	 */
	public interface Server {
		void authenticate();
		void get();
		void post();
		void put();
		void delete();
		void logout();
	}
	
	/*
	 * Implement the real and proxy subject. Note that RealServer class is protected so that
	 * client can't access it.
	 */
	public static class RealServer implements Server {

		@Override
		public void authenticate() {
			System.out.println("Logged into the Real Server");
		}

		@Override
		public void get() {
			System.out.println("GET command executed");
		}

		@Override
		public void post() {
			System.out.println("POST command executed");
		}

		@Override
		public void put() {
			System.out.println("PUT command executed");
		}

		@Override
		public void delete() {
			System.out.println("DELETE command executed");
		}

		@Override
		public void logout() {
			System.out.println("Logged out from the server");
		}
	}
	
	public static class ProxyServer implements Server {
		
		protected RealServer realServer;
		protected boolean sessionActive;
		
		public ProxyServer() {
			this.realServer = new RealServer();
			sessionActive = false;
		}

		@Override
		public void authenticate() {
			realServer.authenticate();
			sessionActive = true;
		}

		@Override
		public void get() {
			if (sessionActive) {
				realServer.get();
			} else {
				System.out.println("Invalid Session");
			}
		}

		@Override
		public void post() {
			if (sessionActive) {
				realServer.post();
			} else {
				System.out.println("Invalid Session");
			}
		}

		@Override
		public void put() {
			if (sessionActive) {
				realServer.put();
			} else {
				System.out.println("Invalid Session");
			}
		}

		@Override
		public void delete() {
			if (sessionActive) {
				realServer.delete();
			} else {
				System.out.println("Invalid Session");
			}
		}

		@Override
		public void logout() {
			realServer.logout();
			sessionActive = false;
		}
	}
	
	/*
	 * Client Code - Client does not have access to RealServer .Every request is performed
	 * via the "surrogate" object called proxy.
	 */
	public static class ProxyClient {

		public static void main(String[] args) {
			Server server = new ProxyServer();
			server.authenticate();
			server.get();
			server.post();
			server.put();
			server.delete();
			server.logout();
		}
	}
}
