package inlining;

public class Inlining {

    public static void main(String[] args) {

        new Inlining().checkIfItsNull();
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
