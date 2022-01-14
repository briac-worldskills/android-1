package tests;

public class apiTest {
	
    public void testBarPositive() {
    	apiTest foo = new apiTest();
        System.out.println(7);
    }

    public void testBarNegative() {
    	apiTest foo = new apiTest();
        System.out.println(-7);
    }

    public static void main(String[] args) {
    	apiTest t = new apiTest();
        t.testBarPositive();
        t.testBarNegative();
    }

}
