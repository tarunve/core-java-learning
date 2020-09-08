package com.maven.FirstMavenProject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppAddTest.class, AppSubtractTest.class })
public class AppTestSuite {

}
