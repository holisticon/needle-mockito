package de.holisticon.toolbox.needle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.junit.testrule.NeedleTestRule;
import de.holisticon.toolbox.needle.provider.DefaultInstanceInjectionProvider;
import de.holisticon.toolbox.needle.provider.InjectionProviderInstancesSupplier;
import de.holisticon.toolbox.needle.provider.NamedInjectionProvider;
import de.holisticon.toolbox.needle.test.Bar;
import de.holisticon.toolbox.needle.test.Foo;

public class NeedleTestRuleBuilderTest {

    private final InjectionProviderInstancesSupplier supplier = new InjectionProviderInstancesSupplier() {

        @Override
        public Set<InjectionProvider<?>> get() {
            return InjectionProviderInstancesSupplier.Factory.newProviderSet(DefaultInstanceInjectionProvider.providerFor(new Bar("hello")),
                    NamedInjectionProvider.providerForNamedValue("foo", new Foo("named")));
        }

    };

    @Rule
    public final NeedleTestRule needle = NeedleTestRuleBuilder.needleTestRule()
            .addProvider(DefaultInstanceInjectionProvider.providerFor(new Foo("default"))).addSupplier(supplier).testInstance(this).build();

    @Inject
    private Bar bar;

    @Inject
    private Foo defaultFoo;

    @Inject
    @Named("foo")
    private Foo namedFoo;

    @Test
    public void shouldInject() {
        assertThat(bar.getName(), is("hello"));
        assertThat(namedFoo.getName(), is("named"));
        assertThat(defaultFoo.getName(), is("default"));
    }

}
