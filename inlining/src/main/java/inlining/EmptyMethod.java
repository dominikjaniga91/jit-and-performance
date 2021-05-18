package inlining;

public class EmptyMethod {

    public static void main(String[] args) {

        for (int i = 0; i < 1_000_000; i++) {
            new EmptyMethod().checkIfItsNull();
        }
    }

    public static void isIsNotNull(Object object) {
       if (object == null) {
           System.out.println("Is not null");
       }
    }

    public void checkIfItsNull() {
        isIsNotNull(this);
    }

}
