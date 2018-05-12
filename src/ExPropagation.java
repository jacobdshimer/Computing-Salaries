public class ExPropagation {
    static void methodOne() {
        System.out.println(5 / 0);
    }

    static void methodTwo() {
        methodOne();
    }

    static void methodThree() {
        try {
            methodTwo();
        } catch (Exception e) {
            System.out.println("Whoops, can't divide by 0");
        }
    }

    public static void main(String[] args) {
        methodThree();
    }
}
