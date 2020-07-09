package org.example.data;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TestIdentificationBureau {

    @Test
    public void idsAreGreaterThenZero() {
        //Arrange
        int idOne, idTwo, idThree;
        IdentificationBureau identificationBureau = new IdentificationBureau();

        //Act
        idOne = identificationBureau.requestNewIdentification();
        idTwo = identificationBureau.requestNewIdentification();
        idThree = identificationBureau.requestNewIdentification();

        //Assert
        assertTrue(idOne > 0);
        assertTrue(idTwo > 0);
        assertTrue(idThree > 0);

    }

    @Test
    public void uniqueIds() {
        //Arrange
        int idOne, idTwo, idThree;
        IdentificationBureau identificationBureau = new IdentificationBureau();

        //Act
        idOne = identificationBureau.requestNewIdentification();
        idTwo = identificationBureau.requestNewIdentification();
        idThree = identificationBureau.requestNewIdentification();

        //Assert
        assertNotEquals(idOne, idTwo);
        assertNotEquals(idOne, idThree);
        assertNotEquals(idTwo, idOne);
        assertNotEquals(idTwo, idThree);
        assertNotEquals(idThree, idOne);
        assertNotEquals(idThree, idTwo);
    }

    @Test
    public void validateIds() {
        //Arrange
        int idOne, idTwo, idThree;
        IdentificationBureau identificationBureau = new IdentificationBureau();
        idOne = identificationBureau.requestNewIdentification();
        idTwo = identificationBureau.requestNewIdentification();
        idThree = identificationBureau.requestNewIdentification();

        //Act
        boolean resultOne = identificationBureau.validateId(idOne);
        boolean resultTwo = identificationBureau.validateId(idTwo);
        boolean resultThree = identificationBureau.validateId(idThree);

        //Assert
        assertTrue(resultOne);
        assertTrue(resultTwo);
        assertTrue(resultThree);
    }

    @Test
    public void validateFalseIds() {
        //Arrange
        int idOne, idTwo, idThree;
        IdentificationBureau identificationBureau = new IdentificationBureau();
        idOne = identificationBureau.requestNewIdentification();
        idTwo = identificationBureau.requestNewIdentification();
        idThree = identificationBureau.requestNewIdentification();

        //Act
        boolean notNegative = identificationBureau.validateId(-1);
        boolean notZero = identificationBureau.validateId(0);
        boolean outSideRange = identificationBureau.validateId(Integer.MAX_VALUE);// No one has bin given that high of a id yet(This assumes we have not used up all "2 147 483 647" id´s).

        //Assert
        assertFalse(notNegative);
        assertFalse(notZero);
        assertFalse(outSideRange);
    }

    @Test
    public void validateEdgeFalseId() {
        //Arrange
        int idOne, idTwo, idThree;
        IdentificationBureau identificationBureau = new IdentificationBureau();

        //Act
        boolean outSideRange = identificationBureau.validateId(1);// No one has bin given that id yet.

        //Assert
        assertFalse(outSideRange);
    }
}
