/*
    (Simulation: self-avoiding random walk) Write a simulation program to show
    that the chance of getting dead-end paths increases as the grid size increases.
    Your program simulates lattices with size from 10 to 80. For each lattice size,
    simulate a self-avoiding random walk 10,000 times and display the probability
    of the dead-end paths, as shown in the following sample output:
 */
package ex15_36;

public class Ex15_36 {

    public static void main(String[] args) {
        for (int i = 10; i <= 80; i++) {
            WalkPane pane = new WalkPane(i);
            for (int j = 0; j < 10000; j++) {
                pane.createWalk();
                System.out.println(pane.isDeadEnd());

            }
        }
    }
    
}
