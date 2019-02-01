package com.frank.jmockit;


import static org.junit.Assert.assertEquals;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * just test for jmocket's fake methods and class, use java's LoginContext for test
 * using LoginContext
 */
public class FakeMethodsAndClass {

    /**
     * mocking loginContext
     */
    final class FakeLoginContext extends MockUp<LoginContext>
    {
        //this mock the construct
        @Mock
        public void $init(String name) {
            assertEquals("test", name);
        }

        //this mock function
        @Mock
        public void login() {
            System.out.println("login executed");
        }

        @Mock
        public Subject getSubject() { return null; }
    }

    @Test
    public void applyingAFakeClass() throws Exception {
        new FakeLoginContext();

        // Inside an application class which creates a suitable CallbackHandler:
        LoginContext context = new LoginContext("test");

    }
}
