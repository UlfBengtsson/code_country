package org.example.data;

/**
 * Rules for Identification Bureau:
 * 1: Must be unique id.
 * 2: Can´t be Zero.
 * 3: Must be a positive number of int type.
 * 4: Provide a id validation that checks if id follows the rules and it´s in range of id´s that given out so far.
 */

public class IdentificationBureau {
    private int idHolder = 1;

    public int requestNewIdentification() {
        return idHolder++;
    }

    public boolean validateId(int id) {
        if (id < 1 || id >= idHolder) {
            return false;
        }
        else {
            return true;
        }
    }
}
