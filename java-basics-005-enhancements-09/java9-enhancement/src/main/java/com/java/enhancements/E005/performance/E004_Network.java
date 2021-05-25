package com.java.enhancements.E005.performance;

/**
 *
 *  ALPN (Application Layer Protocal Negotiation):
 *  -   Select application layer protocol during TLS handshake.
 *  -   HTTP/2 specifications requires it.
 *
 *  DTLS 1.0/1.2 (Datagram Transport Layer Security)
 *  -   Applicable for networking without reliable connection.
 *  -   Java 9 supports DTLS 1.0 and 1.2, aligned with TLS 1.1 and 1.2
 *      through SSLEngine and DatagramSocket.
 *
 *  OCSP Stapling:
 *  -   Online Certificate Status Protocol.
 *      -   Check for X.509 certificate invocation when establishing TLS connections.
 *
 *  SHA-1 Certificates Disabled:
 *  -   SHA-1 'broken' by collision attacks.
 *  -   Certificates using SHA-1 hash rejected by default.
 *  -   Local/enterprise certs not affected.
 *  -   SHA-3 support added.
 */
public class E004_Network {
}
