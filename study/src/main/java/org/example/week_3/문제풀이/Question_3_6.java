package org.example.week_3.문제풀이;

import java.util.LinkedList;
import java.util.Queue;

public class Question_3_6 {

    /**
     * 동물 보호소
     */

    static class Animal <T>{
        private int order;
        protected String name;
        public Animal(String n){
            name = n;
        }

        public void setOrder(int ord){
            order = ord;
        }

        public int getOrder() {
          return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    static class AnimalQueue <T>{
        Queue<T> dogQueue = new LinkedList<>();
        Queue<T> catQueue = new LinkedList<>();
        private static int order = 0;

        public void enqueue(Animal a){
            a.setOrder(order);
            order++;

            if(a instanceof Dog) {
                dogQueue.add((T) a);
            } else if (a instanceof Cat) {
                catQueue.add((T) a);
            }
        }

        public Animal dequeueAny() {
            /* 개와 고앙이 큐의 맨 앞을 살펴본 뒤
             *그중 더 오래전에 들어온 동물을 큐에서 빼낸다. */
            if (dogQueue.size() == 0) {
                return dequeueCats();
            } else if (catQueue.size() == 0) {
                return  dequeueDogs();
            }
            Dog dog = (Dog) dogQueue.peek();
            Cat cat = (Cat) catQueue.peek();

            if (dog.isOlderThan(cat)) {
                return dequeueDogs();
            } else {
                return dequeueCats();
            }
        }

        public Dog dequeueDogs() {
            return (Dog) dogQueue.poll();
        }
        public Cat dequeueCats(){
            return (Cat) catQueue.poll();
        }
    }
    static class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    static class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }
}