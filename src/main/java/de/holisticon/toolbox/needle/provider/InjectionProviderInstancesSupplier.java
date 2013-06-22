package de.holisticon.toolbox.needle.provider;

import java.util.LinkedHashSet;
import java.util.Set;

import de.akquinet.jbosscc.needle.NeedleTestcase;
import de.akquinet.jbosscc.needle.injection.InjectionProvider;

/**
 * <a href="http://javadocs.techempower.com/jdk18/api/java/util/function/Supplier.html">Supplies</a> a Set of
 * InjectionProvider instances.
 * @author Jan Galinski, Holisticon AG
 */
public interface InjectionProviderInstancesSupplier {

    /**
     * Factory to create Supplier from array of providers.
     */
    public static class Factory {

        /**
         * Hide.
         */
        private Factory() {
            // empty
        }

        public static InjectionProviderInstancesSupplier createSupplierFor(final InjectionProvider<?>... providers) {
            final Set<InjectionProvider<?>> result = new LinkedHashSet<InjectionProvider<?>>();

            if (providers != null && providers.length > 0) {

                for (final InjectionProvider<?> provider : providers) {
                    result.add(provider);
                }

            }

            // create supplier from build set
            return new InjectionProviderInstancesSupplier() {

                @Override
                public Set<InjectionProvider<?>> get() {
                    return result;
                }
            };
        }
    }

    /**
     * <a href="http://javadocs.techempower.com/jdk18/api/java/util/function/Supplier.html">Supplies</a> a Set of
     * InjectionProvider instances.
     * @return InjectionProviders that can be added to {@link NeedleTestcase}
     */
    Set<InjectionProvider<?>> get();
}
