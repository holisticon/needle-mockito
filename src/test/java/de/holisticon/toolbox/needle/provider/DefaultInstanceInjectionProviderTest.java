package de.holisticon.toolbox.needle.provider;

import static de.holisticon.toolbox.needle.provider.DefaultInstanceInjectionProvider.providerFor;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import javax.inject.Inject;

import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.junit.NeedleRule;
import de.holisticon.toolbox.needle.test.Foo;

public class DefaultInstanceInjectionProviderTest {

    private final String uuid = UUID.randomUUID().toString();

    @Rule
    public final NeedleRule needle = new NeedleRule(providerFor(new Foo(uuid)));

    @Inject
    private Foo injectedFoo;

    @Test
    public void shouldInjectConcreteInstance() {
        assertThat(injectedFoo.getName(), is(uuid));
    }

}
