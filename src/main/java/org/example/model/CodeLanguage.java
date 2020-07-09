package org.example.model;

public class CodeLanguage {
    private final int id;
    private String name;
    private String description;
    private boolean oop;

    public CodeLanguage(int id, String name, String description, boolean isOOP) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.oop = isOOP;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOop() {
        return oop;
    }

    public void setOop(boolean oop) {
        this.oop = oop;
    }
}
