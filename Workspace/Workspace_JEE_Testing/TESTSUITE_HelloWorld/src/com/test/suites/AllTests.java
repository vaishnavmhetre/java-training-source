package com.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.ProductDaoTest;
import com.test.UserDaoTest;

@RunWith(Suite.class)
@SuiteClasses({ ProductDaoTest.class, UserDaoTest.class })
public class AllTests {

}
