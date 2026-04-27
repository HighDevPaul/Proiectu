package ro.ulbs.proiectaresoftware.lab7.util;

public class PasswordMaker {

    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    // a) b)
    private static final PasswordMaker instance;

    //  c)
    private static int callingCount = 0;

    // Bloc static
    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        instance = new PasswordMaker(); // b) inițializare în bloc static
    }


    private PasswordMaker() {
    }


    public static PasswordMaker getInstance() {
        callingCount++;
        return instance;
    }


    public static int getCallingCounts() {
        return callingCount;
    }


    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = "" + MAGIC_STRING.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER)
                + srand.randomString(10, MAGIC_STRING)
                + ln;
    }
}