package exercise1;

@FunctionalInterface
interface WithMultipleParameter {
    String sayHello(String name, String surname);
}

public class JavaLambdaExpressionWithMultipleParameter {


    public static void main(String[] args) {
        WithMultipleParameter msg = (name, surname) -> {
            return "Hello " + name +" "+  surname;
        };

        System.out.println(msg.sayHello("Harold", "Finch"));

    }

}
