package de.holisticon.toolbox.needle.test;

public class Bar implements NameGetter {

    private final String name;

    public Bar() {
        this("bar");
    }

    public Bar(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
