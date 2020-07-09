package org.example.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * CodeLanguage lack of restriction or verification logic
 * on it´s fields and methods
 * decreases it´s priority on time i spend making test for it.
 */

public class TestCodeLanguage {


    @Test
    public void basicInstantiation() {
        //Arrange
        int idNumber = 1;
        String name = "Java";
        String description = "Java is a general-purpose programming language that is designed to have as few implementation dependencies as possible.";
        boolean isOOP = true;

        //Act
        CodeLanguage codeLanguage = new CodeLanguage(idNumber, name, description, isOOP);

        //Assert
        assertEquals(idNumber, codeLanguage.getId());
        assertEquals(name, codeLanguage.getName());
        assertEquals(description, codeLanguage.getDescription());
        assertEquals(isOOP, codeLanguage.isOop());
    }

    //Just for 100% code coverage
    @Test
    public void setters() {
        //Arrange
        int idNumber = 1;
        String name = "Java";
        String description = "Java is a general-purpose programming language that is designed to have as few implementation dependencies as possible.";
        boolean isOOP = true;
        String nameNew = "C";
        String descriptionNew = "Microsoft code language.";
        boolean isOOPNew = false;

        CodeLanguage codeLanguage = new CodeLanguage(idNumber, name, description, isOOP);

        //Act
        codeLanguage.setName(nameNew);
        codeLanguage.setDescription(descriptionNew);
        codeLanguage.setOop(isOOPNew);

        //Assert
        assertEquals(idNumber, codeLanguage.getId());
        assertEquals(nameNew, codeLanguage.getName());
        assertEquals(descriptionNew, codeLanguage.getDescription());
        assertEquals(isOOPNew, codeLanguage.isOop());
    }
}
