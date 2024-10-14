package linkedlistproblems;

import java.util.LinkedList;
// Problem: Animal Shelter -> An animal Shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
// People must adopt either the "oldest" (based on arrival time) of all animals of the shelter, or they can select whether they would
// prefer a dog or cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like.
// Create a data structure to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
// You may use the built-in LinkedList data structure.

public class AnimalQueue {
	public static void main(String args[]) {
		AnimalQ q = new AnimalQ();

		Animal d1 = new Dog("Oscar");
		Animal c1 = new Cat("Sophie");
		Animal c2 = new Cat("Bella");
		Animal d2 = new Dog("Rocky");
		Animal c3 = new Cat("Honju");

		q.enqueue(d1);
		q.enqueue(c1);
		q.enqueue(d2);
		q.enqueue(c2);
		q.enqueue(c3);

		System.out.println(q.dequeuCats().name);
		System.out.println(q.dequeuDogs().name);
		System.out.println(q.dequeueAny().name);

	}

	static class AnimalQ {

		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0;

		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;

			if (a instanceof Dog)
				dogs.addLast((Dog) a);
			else if (a instanceof Cat)
				cats.addLast((Cat) a);

		}

		public Animal dequeueAny() {
			if (dogs.size() == 0) {
				return dequeuCats();

			} else if (cats.size() == 0) {
				return dequeuDogs();
			}
			Dog d = dogs.peek();
			Cat c = cats.peek();

			if (d.isOlderThan(c)) {
				return dequeuDogs();
			} else {
				return dequeuCats();
			}

		}

		public Dog dequeuDogs() {
			return dogs.poll();
		}

		public Cat dequeuCats() {
			return cats.poll();
		}
	}

}

// Output
/*
 * Sophie 
 * Oscar 
 * Rocky
 * 
 */