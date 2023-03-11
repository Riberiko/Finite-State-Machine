import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NFATest {

    @Test
    void test(){
        NFA dfa = new NFA();

        Assertions.assertEquals(true, dfa.isSentenceValid("aabb"));
        Assertions.assertEquals(true, dfa.isSentenceValid("babb"));
        Assertions.assertEquals(true, dfa.isSentenceValid("aaabb"));
        Assertions.assertEquals(true, dfa.isSentenceValid("bbabb"));
        Assertions.assertEquals(true, dfa.isSentenceValid("ababb"));
        Assertions.assertEquals(true, dfa.isSentenceValid("abbbababb"));
        Assertions.assertEquals(true, dfa.isSentenceValid("abb"));

        Assertions.assertEquals(false, dfa.isSentenceValid("aa"));
        Assertions.assertEquals(false, dfa.isSentenceValid("abab"));
        Assertions.assertEquals(false, dfa.isSentenceValid("bababbba"));
    }
}
