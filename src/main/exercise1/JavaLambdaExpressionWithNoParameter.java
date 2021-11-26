package exercise1;

@FunctionalInterface
interface WithNoParameter {
    String sayHello(String name, String surname);
}

public class JavaLambdaExpressionWithNoParameter {


    public static void main(String[] args) {
        WithNoParameter msg = (name, surname) -> {
            return "Hello " + name +" "+  surname;
        };

        System.out.println(msg.sayHello("Yiğit", "Avcı"));

    }

}
