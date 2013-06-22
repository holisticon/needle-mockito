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

    public static class Factory {

        /**
         * Hide.
         */
        private Factory() {
            // empty
        }

        public static Set<InjectionProvider<?>> newProviderSet(final InjectionProvider<?>... providers) {
            final Set<InjectionProvider<?>> result = new LinkedHashSet<InjectionProvider<?>>();

            if (providers != null && providers.length > 0) {

                for (final InjectionProvider<?> provider : providers) {
                    result.add(provider);
                }

            }
            return result;
        }

        public static InjectionProviderInstancesSupplier createSupplierFor(final InjectionProvider<?>... providers) {
            return new InjectionProviderInstancesSupplier() {

                @Override
                public Set<InjectionProvider<?>> get() {
                    return newProviderSet(providers);
                }
            };
        }

        public static InjectionProviderInstancesSupplier merge(final InjectionProviderInstancesSupplier... suppliers) {
            final Set<InjectionProvider<?>> result = new LinkedHashSet<InjectionProvider<?>>();

            if (suppliers != null && suppliers.length > 0) {

                for (final InjectionProviderInstancesSupplier supplier : suppliers) {
                    result.addAll(supplier.get());
                }

            }

            return new InjectionProviderInstancesSupplier() {

                @Override
                public Set<InjectionProvider<?>> get() {
                    return result;
                }
            };
        }

        public static InjectionProvider<?>[] createProvidersFor(final InjectionProviderInstancesSupplier... suppliers) {
            final InjectionProviderInstancesSupplier supplier = merge(suppliers);
            return supplier.get().toArray(new InjectionProvider<?>[supplier.get().size()]);
        }
    }

    /**
     * <a href="http://javadocs.techempower.com/jdk18/api/java/util/function/Supplier.html">Supplies</a> a Set of
     * InjectionProvider instances.
     * @return InjectionProviders that can be added to {@link NeedleTestcase}
     */
    Set<InjectionProvider<?>> get();
}
