import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DFATest {

    @Test
    void test(){
        DFA dfa = new DFA();

        Assertions.assertEquals(true, dfa.isSentenceValid("ac"));
        Assertions.assertEquals(true, dfa.isSentenceValid("bc"));
        Assertions.assertEquals(true, dfa.isSentenceValid("acc"));
        Assertions.assertEquals(true, dfa.isSentenceValid("bcc"));
        Assertions.assertEquals(true, dfa.isSentenceValid("accc"));
        Assertions.assertEquals(true, dfa.isSentenceValid("bccc"));

        Assertions.assertEquals(false, dfa.isSentenceValid("aca"));
        Assertions.assertEquals(false, dfa.isSentenceValid("acbb"));
        Assertions.assertEquals(false, dfa.isSentenceValid("cc"));
    }
}
