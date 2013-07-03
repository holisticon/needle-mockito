package de.holisticon.toolbox.needle.provider;

import static de.holisticon.toolbox.needle.provider.NamedInjectionProvider.providerForNamedValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.junit.NeedleRule;
import de.holisticon.toolbox.needle.test.Bar;

public class NamedInjectionProviderTest {

    private static final String WORLD = "world";
    private static final String HELLO = "hello";

    @Rule
    public final NeedleRule needle = new NeedleRule(providerForNamedValue(HELLO, new Bar(HELLO)), providerForNamedValue(WORLD, new Bar(WORLD)));

    @SuppressWarnings("cdi-ambiguous-dependency")
    @Inject
    @Named(HELLO)
    private Bar hello;

    @SuppressWarnings("cdi-ambiguous-dependency")
    @Inject
    @Named(WORLD)
    private Bar world;

    @Test
    public void shouldInjectNamedValues() {
        assertThat(hello.getName(), is(HELLO));
        assertThat(world.getName(), is(WORLD));
    }

}
