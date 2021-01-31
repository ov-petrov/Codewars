import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void camelCaseTest() {
        assertEquals("Incorrect", "camel Casing", CamelCase.camelCase("camelCasing"));
        assertEquals("Incorrect", "camel Casing Test", CamelCase.camelCase("camelCasingTest"));
        assertEquals("Incorrect", "camelcasingtest", CamelCase.camelCase("camelcasingtest"));
        assertEquals("Incorrect", "", CamelCase.camelCase(""));
        assertEquals("Incorrect", "a", CamelCase.camelCase("a"));
        assertEquals("Incorrect", "AA", CamelCase.camelCase("AA"));
        assertEquals("Incorrect", "c AA", CamelCase.camelCase("cAA"));
    }

    @Test
    public void abbreviatorTest() {
        assertEquals("i18n", Abbreviator.abbreviate("internationalization"));
        assertEquals("l2e!is v2y goo!", Abbreviator.abbreviate("live!is very goo!"));
        assertEquals("hot m2t f5g!", Abbreviator.abbreviate("hot meat fucking!"));
        assertEquals("hot m2t, f5g!!! d7s", Abbreviator.abbreviate("hot meat, fucking!!! delicious"));
        assertEquals("e6t-r3s are r4y fun!", Abbreviator.abbreviate("elephant-rides are really fun!"));
    }
}
