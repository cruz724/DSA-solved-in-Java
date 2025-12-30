import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student (String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        // Create a PriorityQueue to hold integers
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Add elements to the PriorityQueue
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(2);

        // Add students
        pq.add(new Student("A", 2));
        pq.add(new Student("B", 21));
        pq.add(new Student("C", 12));
        pq.add(new Student("D", 5));

        // Print and remove elements from the PriorityQueue in order of priority
        System.out.println("Elements in priority order:");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek()); // View the head of the queue
            priorityQueue.remove();
        }

        //printing Student
        System.out.println("students");

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "-> " + pq.peek().rank);
            pq.remove();            
        }
    }
}