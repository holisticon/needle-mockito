package de.holisticon.toolbox.needle;


import static de.holisticon.toolbox.needle.provider.InjectionProviderInstancesSupplier.Factory.*;
import java.util.LinkedHashSet;
import java.util.Set;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.junit.testrule.NeedleTestRule;
import de.holisticon.toolbox.needle.provider.InjectionProviderInstancesSupplier;

/**
 * Builder to create {@link NeedleTestRule} with complex setup.
 * @author Jan Galinski, Holisticon AG
 */
public class NeedleTestRuleBuilder implements InjectionProviderInstancesSupplier {

    public static NeedleTestRuleBuilder needleTestRule() {
        return new NeedleTestRuleBuilder();
    }

    public static NeedleTestRuleBuilder needleTestRule(final Object testInstance) {
        return new NeedleTestRuleBuilder(testInstance);
    }

    private Object testInstance;
    private final Set<InjectionProvider<?>> internalProviders = new LinkedHashSet<InjectionProvider<?>>();

    /**
     * Hide.
     */
    private NeedleTestRuleBuilder() {
    }

    /**
     * Hide.
     */
    private NeedleTestRuleBuilder(final Object testInstance) {
        testInstance(testInstance);
    }

    public NeedleTestRuleBuilder testInstance(final Object testInstance) {
        if (testInstance == null) {
            throw new IllegalArgumentException("testInstance must not be null");
        }
        this.testInstance = testInstance;
        return this;
    }

    public NeedleTestRuleBuilder addProvider(final InjectionProvider<?>... providers) {
        internalProviders.addAll(newProviderSet(providers));
        return this;
    }

    public NeedleTestRuleBuilder addSupplier(final InjectionProviderInstancesSupplier... suppliers) {
        internalProviders.addAll(merge(suppliers).get());
        return this;
    }

    public NeedleTestRule build() {

        if (testInstance == null) {
            throw new IllegalStateException("testInstance has not been set!");
        }
        return new NeedleTestRule(testInstance, createProvidersFor(this));
    }

    @Override
    public Set<InjectionProvider<?>> get() {
        return internalProviders;
    }
}
