import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {
    private int balance = -5000;
    private static String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss"));
    CreditAccount sut = new CreditAccount(balance);

    @BeforeAll
    public static void started() {
        System.out.println("Tests started: " + time);
    }

    @AfterAll
    public static void finished() {
        System.out.println("Tests finished: " + time);
    }

    @BeforeEach
    public void init() {
        System.out.println("Test started: " + time);
    }

    @AfterEach
    public void complete() {
        System.out.println("Test completed: " + time);
    }

    @Test
    public void testPay() {
        int amount = 1000, expected = -6000;
        int result = sut.pay(amount);
        assertEquals(expected, result);
    }

    @Test
    public void testAddMoney() {
        int amount = 6000, expected = -5000;
        int result = sut.addMoney(amount);
        int amount1 = 1000, expected1 = -4000;
        int result1 = sut.addMoney(amount1);

        assertEquals(expected, result);
        assertEquals(expected1, result1);
    }

    @Test
    public void testCheckBalance() {
        int amount = 5000, amount1 = 6000;

        assertTrue(() -> sut.checkBalance(amount));
        assertFalse(() -> sut.checkBalance(amount1));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testNewPay(int amount, int expected){
        int result = sut.pay(amount);
        assertEquals(expected, result);

    }
    private static Stream<Arguments> source(){
        return Stream.of(Arguments.of(2000, -7000), Arguments.of(5000, -10_000), Arguments.of(500, -5500));
    }
}