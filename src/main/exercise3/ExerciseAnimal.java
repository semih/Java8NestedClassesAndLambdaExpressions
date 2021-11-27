package exercise3;

import exercise3.model.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciseAnimal {

    private static final List<Animal> animals = Arrays.asList(new Cat("Tekir"), new Fish("Benekli"), new Spider());
    private static final Predicate<Animal> isPet = (p) -> p instanceof Pet;
    private static final Predicate<Animal> isWild = isPet.negate();

    public static void main(String[] args) {

        // Q.1) Take a list of wild animals
        List<Animal> wildAnimals = animals.stream().filter(isWild).collect(Collectors.toList());
        wildAnimals.forEach(p-> System.out.println(p.getClass().getSimpleName()));

        // Q.2) Take a list of pets
        List<Animal> pets = animals.stream().filter(isPet).collect(Collectors.toList());
        pets.forEach(p-> System.out.println(p.getClass().getSimpleName()));

        // (Q.3) Find the animal with the highest number of legs
        System.out.println(animals.stream().sorted(new Comparator<Animal>() {
                                    @Override
                                    public int compare(Animal o1, Animal o2) {
                                         if (o1.getLegs() < o2.getLegs()) {
                                             return 1;
                                         } else if (o1.getLegs() == o2.getLegs()) {
                                             return 0;
                                         } else {
                                             return -1;
                                         }
                                    }
                                }).findFirst());

        // Q.4) Find the total number of legs -- reduce function can be used.
        int totalNumberOfLegs = animals.stream().mapToInt(Animal::getLegs).sum();
        System.out.println(totalNumberOfLegs);


        // Q.5) Group the animals by their number of legs
        Map<Integer, List<Animal>> animalMap = animals.stream().collect(Collectors.groupingBy(Animal::getLegs));
        System.out.println(animalMap);

        // Q.6) Count the number of animals in each specie
        List<Animal> animalList = new ArrayList<>(animals); // handles UnsupportedOperationException
        animalList.add(new Cat());
        animalList.add(new Spider());
        animalList.add(new Fish("Jaws"));

        Map<? extends Class<? extends Animal>, Long> groupedAnimalsInEachSpecie = animalList.stream().collect(Collectors.groupingBy((animal) -> animal.getClass(), Collectors.counting()));
        System.out.println(groupedAnimalsInEachSpecie);

        // Q.7) Count the number of species
        long totalNumberOfSpecies = animals.stream().map(Animal::getClass).map((animal) -> animal.getSimpleName()).distinct().count();
        System.out.println(totalNumberOfSpecies);

    }
}
