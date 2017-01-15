package hackerearth.java.com.vaquar.udacity.human.superhuman;

/*
 * Java is the primary programming language used when building for Android,
 * and this quiz is designed to warm-up your Java programming skills:
 *
 * There are some missing elements from Human.java and Superhero.java
 * (see tabs above this window for details) that we could use your help to complete!
 *
 * --TASK OVERVIEW--
 * In Human.java:
 * - Implement the Comparable Interface using the age field as the differentiator.
 * In Superhero.java:
 * - Extend the class Superhero as a subclass of Human.
 * - Add a String field that stores the hero's alter ego.
 * - Modify the given constructor by adding the alter ego as an additional parameter
 *   and setting it.
 * - Override the introduce() method to ALSO return the alter ego.
 *
 * Feel free to this use space as a sandbox to get started:
 * - Create some Humans and Superheroes.
 * - Have them introduce themselves.
 * - Sort Them!
 *
 * We recommend testing your code via the "Test Run" button, and
 * submit your completed code with the "Submit" button when you're ready!
 *
 * You can submit as many times as you'd like. There is no penalty
 * for multiple submissions; the quiz will only retain your most
 * recent submission.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AndroidReadiness
{
    public static void main(String[] args) throws IOException
    {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	String intro = sc.nextLine();
	List<Human> humanSet = new ArrayList<Human>();
	for (int t = 0; t < T; t++) {

	    intro = sc.nextLine();
	    String[] introArray = intro.split(" ");
	    // Some sample instances
	    if (introArray[0].equals("Superhero")) {
		Superhero batman = new Superhero(introArray[1], Integer.parseInt(introArray[2]), introArray[3]);
		System.out.println(batman.introduce());
		humanSet.add(batman);
	    } else {
		Human pepper = new Human(introArray[1], Integer.parseInt(introArray[2]));
		System.out.println(pepper.introduce());
		humanSet.add(pepper);

	    }
	    // Create some more characters!

	    // Make some introductions
	    // Note: Superheroes should also share their alter ego! For example,
	    // System.out.println(batman.introduce());
	    // should print to std out:

	    // Hey! I'm Bruce and I'm 26 years old. I'm also known as Batman!

	    // Testing your Comparable Interface:
	    // Create multiple Humans/Superheros and add them to an ArrayList
	    // Example:
	    // Superhero ironman = new Superhero("Tony", 35, "Ironman");
	    // Human rachel = new Human("Rachel", 22);

	    // List<Human> people = new ArrayList<Human>();
	    // people.add(batman);
	    // people.add(rachel);
	    // people.add(ironman);
	    // people.add(pepper);

	    // Then sort your list (which uses your interface implementation)
	    // Collections.sort(people);
	    // Print the age in sorted order (ascending order)
	}
	Collections.sort(humanSet);
	for (Human human : humanSet) {
	    System.out.println(human.getAge());
	}

    }
}

class Human implements Comparable<Human> {
    private final int age;
    private final String name;

    public Human(String givenName, int age) {
	this.name = givenName;
	this.age = age;
    }

    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
    }

    public String introduce() {
	return "Hey! I'm " + name + " and I'm " + age + " years old.";
    }

    public int compareTo(Human o) {
	if (this.age < o.getAge()) {
	    return -1;
	} else if (this.age > o.getAge()) {
	    return 1;
	} else {
	    return 0;
	}
    }

    // Hint: Implement the method required by the Comparable Interface
    // using age as the differentiator
}

/*
 * - TASK: Extend the class Superhero as a subclass of Human. - TASK: Add a
 * String field that stores the hero's alter ego! - TASK: Modify the given
 * constructor by adding the alter ego as an additional parameter and setting
 * it. - TASK: Override the introduce() method to ALSO include the alter ego!
 * (In other words, you should call the superclass introduce method when you
 * override the method.)
 */

class Superhero extends Human {

    private String alterEgo;

    public Superhero(String givenName, int age) {
	super(givenName, age);
    }

    public Superhero(String givenName, int age, String alterEgo) {
	super(givenName, age);
	this.alterEgo = alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
	this.alterEgo = alterEgo;
    }

    public String getAlterEgo() {
	return alterEgo;
    }

    @Override
    public String introduce() {
	return "Hey! I'm " + this.getName() + " and I'm " + this.getAge() + " years old. I'm also known as " + alterEgo + "!";
    }
}
