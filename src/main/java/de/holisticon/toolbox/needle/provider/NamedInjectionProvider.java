package de.holisticon.toolbox.needle.provider;


import javax.inject.Named;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.injection.InjectionTargetInformation;

/**
 * Needle Injection Provider for Instance with {@link Named} Annotation
 * @author Jan Galinski, Holisticon AG
 * @param <T>
 *        target type.
 */
public class NamedInjectionProvider<T> implements InjectionProvider<T> {

    /**
     * name of the interest.
     */
    private final String name;
    /**
     * value to return.
     */
    private final T value;

    /**
     * Factory method for creating the provider.
     * @param name
     *        name of interest
     * @param value
     *        value to encapsulate.
     * @return provider encapsulating the value.
     */
    public static <T> NamedInjectionProvider<T> forNamedValue(final String name, final T value) {
        return new NamedInjectionProvider<T>(name, value);
    }

    /**
     * Constructs a provider for given @Named element encapsulating the value.
     * @param name
     *        name of the interest.
     * @param value
     *        value to return.
     */
    protected NamedInjectionProvider(final String name, final T value) {
        this.name = name;
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getInjectedObject(final Class<?> type) {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getKey(final InjectionTargetInformation injectionTargetInformation) {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean verify(final InjectionTargetInformation injectionTargetInformation) {
        return injectionTargetInformation.isAnnotationPresent(Named.class)
                && ((Named)injectionTargetInformation.getAnnotation(Named.class)).value().equals(name)
                && value.getClass().isAssignableFrom(injectionTargetInformation.getType());
    }
}
