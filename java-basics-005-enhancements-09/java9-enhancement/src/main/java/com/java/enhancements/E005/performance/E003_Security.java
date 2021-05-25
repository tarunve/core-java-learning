package com.java.enhancements.E005.performance;

/**
 *  Serialization:
 *  -   conversion of java to raw objects or vice versa.
 *  -   There can be many vulnerabilities in this process.
 *
 *  Filter Incoming Serialization Data:
 *  ----------------------------------
 *  -   New Interface, to filter data before deserialization:
 *              interface ObjectInputFilter{
 *                  Status checkInput(FilterInput filterInfo);
 *
 *                  enum Status{
 *                      UNDECIDED,
 *                      ALLOWED,
 *                      REJECTED
 *                  }
 *              }
 *      -   We can provide the implementation for this filter interface
 *          for whitelisting.
 *  -   Filter without adding or changing code
 *          jdk.serialFilter system property:
 *              maxbytes=n;
 *              maxarray=n;
 *              maxdepth=n;
 *              com.learning.abc.**;
 *              com.learning.def.**;
 *              !com.learning.xyz*;
 */
public class E003_Security {
}
