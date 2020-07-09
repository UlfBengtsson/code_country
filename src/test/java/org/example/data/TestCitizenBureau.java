package org.example.data;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.example.model.CodeLanguage;
import org.junit.Before;
import org.junit.Test;

public class TestCitizenBureau {
/*
    @Test
    public void test() {
        //Arrange


        //Act


        //Assert
    }
*/

    private IdentificationBureau idBureau;
    private CitizenBureau citizenBureau;

    @Before
    public void init() {
        idBureau = new IdentificationBureau();
        citizenBureau = new CitizenBureau(idBureau);
    }

    @Test
    public void initialState() {
        //Arrange
        //@Before has taken care of setting up citizenBureau for us in our test.

        //Act
        int count = citizenBureau.populationCount();
        CodeLanguage[] codeLanguages = citizenBureau.requestListOfCitizens();

        //Assert
        assertEquals(0, count);
        assertNotNull(codeLanguages);
        assertEquals(count, codeLanguages.length);
    }

    @Test
    public void addPopulation() {
        //Arrange
        String codeName = "Java";
        String codeDescription = "One of the big once and bountiful";
        boolean codeIsOOP = true;

        //Act
        citizenBureau.registrationOfCitizenship(codeName,codeDescription, codeIsOOP);
        int count = citizenBureau.populationCount();
        CodeLanguage[] codeLanguages = citizenBureau.requestListOfCitizens();

        //Assert
        assertEquals(1, count);
        assertNotNull(codeLanguages);
        assertEquals(count, codeLanguages.length);
    }

    @Test
    public void addGoodCitizen() {
        //Arrange
        String codeName = "Java";
        String codeDescription = "One of the big once and bountiful";
        boolean codeIsOOP = true;

        //Act
        CodeLanguage codeLang = citizenBureau.registrationOfCitizenship(codeName, codeDescription, codeIsOOP);

        //Assert
        assertNotNull(codeLang);
        assertEquals(1, codeLang.getId());
        assertEquals(codeName, codeLang.getName());
        assertEquals(codeDescription, codeLang.getDescription());
        assertEquals(codeIsOOP, codeLang.isOop());
    }

    @Test
    public void TryToAddBadCitizens() {
        //Arrange
        String emptyName = "";
        String emptyDescription = "";
        String nullName = null;
        String nullDescription = null;

        //Act
        CodeLanguage nullAllLang = citizenBureau.registrationOfCitizenship(nullName, nullDescription, false);
        CodeLanguage emptyAllLang = citizenBureau.registrationOfCitizenship(emptyName, emptyDescription, false);
        CodeLanguage nullEmptyLang = citizenBureau.registrationOfCitizenship(nullName, emptyDescription, false);
        CodeLanguage emptyNullLang = citizenBureau.registrationOfCitizenship(emptyName, nullDescription, false);
        int count = citizenBureau.populationCount();

        //Assert
        assertNull(nullAllLang);
        assertNull(emptyAllLang);
        assertNull(nullEmptyLang);
        assertNull(emptyNullLang);
        assertEquals(0, count);
    }

    @Test
    public void removeOneCitizenInMiddle() {
        //Arrange
        String codeName1 = "Java";
        String codeDescription1 = "One of the big once and bountiful";
        boolean codeIsOOP1 = true;
        String codeName2 = "C#";
        String codeDescription2 = "Microsoft´s popular open source code language";
        boolean codeIsOOP2 = true;
        String codeName3 = "Basic";
        String codeDescription3 = "Old but it did it´s job";
        boolean codeIsOOP3 = false;

        citizenBureau.registrationOfCitizenship(codeName1,codeDescription1, codeIsOOP1);
        citizenBureau.registrationOfCitizenship(codeName2,codeDescription2, codeIsOOP2);
        citizenBureau.registrationOfCitizenship(codeName3,codeDescription3, codeIsOOP3);
        int countBefore = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesBefore = citizenBureau.requestListOfCitizens();

        //Act
        boolean result = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[1].getId());
        int countAfter = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesAfter = citizenBureau.requestListOfCitizens();

        //Assert
        assertTrue(result);
        assertEquals(countBefore - 1, countAfter);
        //asserting that the right CodeLanguage was removed.
        for ( CodeLanguage codeLang : codeLanguagesAfter ) {
            assertFalse(codeLang.getId() == codeLanguagesBefore[1].getId());
        }
    }

    @Test
    public void removeFirstCitizen() {
        //Arrange
        String codeName1 = "Java";
        String codeDescription1 = "One of the big once and bountiful";
        boolean codeIsOOP1 = true;
        String codeName2 = "C#";
        String codeDescription2 = "Microsoft´s popular open source code language";
        boolean codeIsOOP2 = true;
        String codeName3 = "Basic";
        String codeDescription3 = "Old but it did it´s job";
        boolean codeIsOOP3 = false;

        citizenBureau.registrationOfCitizenship(codeName1,codeDescription1, codeIsOOP1);
        citizenBureau.registrationOfCitizenship(codeName2,codeDescription2, codeIsOOP2);
        citizenBureau.registrationOfCitizenship(codeName3,codeDescription3, codeIsOOP3);
        int countBefore = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesBefore = citizenBureau.requestListOfCitizens();

        //Act
        boolean result = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[0].getId());
        int countAfter = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesAfter = citizenBureau.requestListOfCitizens();

        //Assert
        assertTrue(result);
        assertEquals(countBefore - 1, countAfter);
        //asserting that the right CodeLanguage was removed.
        for ( CodeLanguage codeLang : codeLanguagesAfter ) {
            assertFalse(codeLang.getId() == codeLanguagesBefore[0].getId());
        }
    }

    @Test
    public void removeLastCitizen() {
        //Arrange
        String codeName1 = "Java";
        String codeDescription1 = "One of the big once and bountiful";
        boolean codeIsOOP1 = true;
        String codeName2 = "C#";
        String codeDescription2 = "Microsoft´s popular open source code language";
        boolean codeIsOOP2 = true;
        String codeName3 = "Basic";
        String codeDescription3 = "Old but it did it´s job";
        boolean codeIsOOP3 = false;

        citizenBureau.registrationOfCitizenship(codeName1,codeDescription1, codeIsOOP1);
        citizenBureau.registrationOfCitizenship(codeName2,codeDescription2, codeIsOOP2);
        citizenBureau.registrationOfCitizenship(codeName3,codeDescription3, codeIsOOP3);
        int countBefore = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesBefore = citizenBureau.requestListOfCitizens();

        //Act
        boolean result = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[2].getId());
        int countAfter = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesAfter = citizenBureau.requestListOfCitizens();

        //Assert
        assertTrue(result);
        assertEquals(countBefore - 1, countAfter);
        //asserting that the right CodeLanguage was removed.
        for ( CodeLanguage codeLang : codeLanguagesAfter ) {
            assertFalse(codeLang.getId() == codeLanguagesBefore[2].getId());
        }
    }

    @Test
    public void removeAllCitizens() {
        //Arrange
        String codeName1 = "Java";
        String codeDescription1 = "One of the big once and bountiful";
        boolean codeIsOOP1 = true;
        String codeName2 = "C#";
        String codeDescription2 = "Microsoft´s popular open source code language";
        boolean codeIsOOP2 = true;
        String codeName3 = "Basic";
        String codeDescription3 = "Old but it did it´s job";
        boolean codeIsOOP3 = false;

        citizenBureau.registrationOfCitizenship(codeName1,codeDescription1, codeIsOOP1);
        citizenBureau.registrationOfCitizenship(codeName2,codeDescription2, codeIsOOP2);
        citizenBureau.registrationOfCitizenship(codeName3,codeDescription3, codeIsOOP3);
        int countBefore = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesBefore = citizenBureau.requestListOfCitizens();

        //Act
        boolean result0 = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[0].getId());
        boolean result1 = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[1].getId());
        boolean result2 = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[2].getId());
        int countAfter = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesAfter = citizenBureau.requestListOfCitizens();

        //Assert
        assertTrue(result0);
        assertTrue(result1);
        assertTrue(result2);
        assertEquals(0, countAfter);
    }

    @Test
    public void tryToRemoveCitizenTwice() {
        //Arrange
        String codeName1 = "Java";
        String codeDescription1 = "One of the big once and bountiful";
        boolean codeIsOOP1 = true;
        String codeName2 = "C#";
        String codeDescription2 = "Microsoft´s popular open source code language";
        boolean codeIsOOP2 = true;
        String codeName3 = "Basic";
        String codeDescription3 = "Old but it did it´s job";
        boolean codeIsOOP3 = false;

        citizenBureau.registrationOfCitizenship(codeName1,codeDescription1, codeIsOOP1);
        citizenBureau.registrationOfCitizenship(codeName2,codeDescription2, codeIsOOP2);
        citizenBureau.registrationOfCitizenship(codeName3,codeDescription3, codeIsOOP3);
        int countBefore = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesBefore = citizenBureau.requestListOfCitizens();

        //Act
        boolean resultYes = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[2].getId());
        boolean resultNo = citizenBureau.terminationOfCitizenship(codeLanguagesBefore[2].getId());
        int countAfter = citizenBureau.populationCount();
        CodeLanguage[] codeLanguagesAfter = citizenBureau.requestListOfCitizens();

        //Assert
        assertTrue(resultYes);
        assertFalse(resultNo);
        assertEquals(countBefore - 1, countAfter);
    }
}
