package de.holisticon.toolbox.needle.test;

public class Foo implements NameGetter {

    private final String name;

    public Foo() {
        this("foo");
    }

    public Foo(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
