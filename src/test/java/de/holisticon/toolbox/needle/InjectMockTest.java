package de.holisticon.toolbox.needle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.annotation.Mock;
import de.akquinet.jbosscc.needle.junit.testrule.NeedleTestRule;
import de.holisticon.toolbox.needle.test.Bar;
import de.holisticon.toolbox.needle.test.Foo;

/**
 * Verifies that mockito.Mock behaves like akquinet.Mock annotation. See needle.properties for configuration details.
 * @author Jan Galinski, Holisticon AG
 */
public class InjectMockTest {

    private static final String FOO = "foo";
    private static final String BAR = "bar";

    @Rule
    public final NeedleTestRule needle = NeedleTestRuleBuilder.needleTestRule(this).build();

    @Mock
    private Bar bar;

    @org.mockito.Mock
    private Foo foo;

    @Test
    public void shouldInjectMockForAkquinetAnnotation() {
        when(bar.getName()).thenReturn(BAR);
        assertThat(bar.getName(), is(BAR));
    }

    @Test
    public void shouldInjectMockForMockitoAnnotation() {
        when(foo.getName()).thenReturn(FOO);
        assertThat(foo.getName(), is(FOO));
    }

}
