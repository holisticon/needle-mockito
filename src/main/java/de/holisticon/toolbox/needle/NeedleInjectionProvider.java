package de.holisticon.toolbox.needle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.holisticon.toolbox.needle.provider.InjectionProviderInstancesSupplier;

/**
 * Annotation to mark InjectionProviders or InjectionProviderInstancesSupplier. <br/>
 * Should be placed on fields of type {@link InjectionProvider}, an array of
 * those, or an {@link InjectionProviderInstancesSupplier}.
 * 
 * @author Jan Galinski, Holisticon AG (jan.galinski@holisticon.de)
 * @author Simon Zambrovski, Holisticon AG (simon.zambrovski@holisticon.de)
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedleInjectionProvider {
	// Nothing here
}
