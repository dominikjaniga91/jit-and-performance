package test;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getInt());
        System.out.println(test.getDouble());
        System.out.println(test.getString());
    }

    private int getInt() {
        return 6;
    }

    final double getDouble() {
        return 4d;
    }

    public String getString() {
        return "Test";
    }

}
