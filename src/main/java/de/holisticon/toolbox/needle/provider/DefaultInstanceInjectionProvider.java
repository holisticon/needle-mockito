package de.holisticon.toolbox.needle.provider;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.injection.InjectionTargetInformation;

/**
 * InjectionProvider that provides a singleton instance of type T whenever injection is required.
 * @author Jan Galinski, Holisticon AG (jan.galinski@holisticon.de)
 * @param <T> target type
 */
public class DefaultInstanceInjectionProvider<T> implements InjectionProvider<T> {

    /**
     * Factory method.
     * @param instance
     *        returns a provider for given instance.
     * @return injection provider.
     */
    public static <T> DefaultInstanceInjectionProvider<T> providerFor(final T instance) {
        return new DefaultInstanceInjectionProvider<T>(instance);
    }

    /**
     * always return this instance
     */
    private final T instance;

    /**
     * Constructs an injection provider responsible for returning the same instance.
     * @param instance
     *        instance to return.
     */
    public DefaultInstanceInjectionProvider(final T instance) {
        if (instance == null) {
            throw new IllegalArgumentException("instance must not be null!");
        }
        this.instance = instance;
    }

    @Override
    public boolean verify(final InjectionTargetInformation injectionTargetInformation) {
        return injectionTargetInformation.getType().isAssignableFrom(instance.getClass());
    }

    @Override
    public T getInjectedObject(final Class<?> injectionPointType) {
        return instance;
    }

    @Override
    public Object getKey(final InjectionTargetInformation injectionTargetInformation) {
        return injectionTargetInformation.getType();
    }

}
