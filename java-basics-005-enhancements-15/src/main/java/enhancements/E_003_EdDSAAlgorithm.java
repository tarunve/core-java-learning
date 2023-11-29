package enhancements;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

/**
 *  -   EdDSA (Edwards-Curve Digital Signature Algorithm) [RFC 8032] is another additional digital
 *      signature scheme added in Java 15 thorough JEP 339.
 *
 *  -   It does not replace the existing Elliptic Curve Digital Signature Algorithm (ECDSA) in JDK.
 *  -   EdDSA provides following parameter choices :
 *      Algorithm Name	            Description
 *          EdDSA	            Edwards-Curve signature algorithm as defined in RFC 8032
 *          Ed25519	            Edwards-Curve signature algorithm with Ed25519 as defined in RFC 8032
 *          Ed448	            Edwards-Curve signature algorithm with Ed448 as defined in RFC 8032
 *
 *  Advantages of EdDSA (using Ed25519)
 *  -   Provides platform-independent implementation of EdDSA with better performance than the
 *      existing ECDSA implementation.
 *  -   Does not change the execution time based on the length of secret key.
 *  -   Provides standardized parameter sets such as Ed25519 and Ed448 which can be specified
 *      using identifiers.
 *  -   It is scheduled to be integrated with JSSE for TLS 1.3. It is one of only three signature
 *      schemes that are allowed in TLS 1.3.
 */
public class E_003_EdDSAAlgorithm {

    public static void main(String[] args)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
        KeyPair kp = kpg.generateKeyPair();

        byte[] msg = "test_string".getBytes(StandardCharsets.UTF_8);

        Signature sig = Signature.getInstance("Ed25519");
        sig.initSign(kp.getPrivate());
        sig.update(msg);
        byte[] s = sig.sign();

        String encodedString = Base64.getEncoder().encodeToString(s);
        System.out.println(encodedString);
    }
}
