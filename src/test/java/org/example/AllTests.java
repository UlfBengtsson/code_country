package org.example;

import org.example.data.TestCitizenBureau;
import org.example.data.TestIdentificationBureau;
import org.example.model.TestCodeLanguage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        TestCodeLanguage.class,
        TestIdentificationBureau.class,
        TestCitizenBureau.class
})

public class AllTests {

}
