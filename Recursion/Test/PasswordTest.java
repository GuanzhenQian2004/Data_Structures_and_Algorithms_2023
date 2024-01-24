import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void testToString() {
        Password p = new Password("123abc");
        System.out.println(p.getPassword());
        System.out.println(p.toString());

    }

    @Test
    void testEquals() {
    }

    @Test
    void getPassword() {
//        Password p = new Password("123abc");
//        System.out.println(p.getPassword());
//     assertEquals(p.getPassword(), "123abc");
    }

    @Test
    void setPassword() {

    }

    @Test
    void containsDigit() {
//        Password p = new Password("123abc");
//        System.out.println(p.containsDigit("34tr"));

    }

    @Test
    void samePassword() {
//        Password p = new Password("123abc");
//        System.out.println(p.samePassword("", ""));
    }

    @Test
    void countDifferences() {
//        Password p = new Password("123abc");
//        System.out.println(p.countDifferences("34tr", "34tr"));
    }

    @Test
    void sufficientDifferent() {
//        Password p = new Password("123abc");
//        System.out.println(p.sufficientDifferent("34tr", "34tr232", 3));
    }

    @Test
    void testToString1() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void testGetPassword() {
    }

    @Test
    void testSetPassword() {
    }
}