package org.example.data;

import org.example.model.CodeLanguage;

import java.util.Arrays;

/**
 * Rules for Citizen Bureau:
 * 1: Must have a unique id per citizen of the population.
 * 2: Name & Description of citizen may not be null or empty.
 * 3: Citizen must have declare if they are OOP (Object orientated programing) or not.
 * 4: Those that want to get citizenship must follow the rules.
 * 5: Keep a array of current population (no null/empty slots in array allowed).
 * 6: If another bureau can provide a service,
 *    used them to so the citizen bureau can work with what it should focus on.
 */

public class CitizenBureau {
    private CodeLanguage[] population = new CodeLanguage[0];
    private IdentificationBureau idBureau;

    public CitizenBureau(IdentificationBureau identificationBureau) {
        idBureau = identificationBureau;
    }

    public int populationCount() {
        return population.length;
    }

    public CodeLanguage[] requestListOfCitizens() {
        return Arrays.copyOf(population, population.length);
    }

    public CodeLanguage registrationOfCitizenship(String name, String description, boolean isOOP) {
        if (name == null || name.isEmpty()                  //validate name
                         ||
            description == null || description.isEmpty())   //validate description
        {
            return null;
        }

        CodeLanguage citizen = new CodeLanguage(
                idBureau.requestNewIdentification(),
                name, description,
                isOOP
        );

        addCitizen(citizen);

        return citizen;
    }

    public boolean terminationOfCitizenship(int id) {
        if (idBureau.validateId(id)) {
            for (int i = 0; i < populationCount() ; i++) {
                if (population[i].getId() == id) {
                    for (int j = i + 1; j < populationCount(); j++, i++) {
                        population[i] = population[j];
                    }
                    population = Arrays.copyOf(population, population.length - 1);
                    return true;
                }
            }
        }
        return false;
    }

    private void addCitizen(CodeLanguage citizen) {
        population = Arrays.copyOf(population, population.length + 1);
        population[population.length - 1] = citizen;
    }
}
