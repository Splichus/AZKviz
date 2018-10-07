import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AZKviz {

    static int A = 30;
    static double L = (A * Math.sqrt(3.0)) / 2;
    static ArrayList<Integer> BLUEHEXES = new ArrayList<>();
    static ArrayList<Integer> YELLOWHEXES = new ArrayList<>();


    public static void mainDraw(Graphics graphics) {

        drawBoard(graphics, BLUEHEXES, YELLOWHEXES);
        // TODO improve printing for resizing
        // TODO Print all output on the screen, not in command line


    }
    // Compares the answer given by user with the correct answers, if co, adds
    public static boolean rightAnswer(int questionNumber) {
        // TODO Store database in separate file
        // TODO Create methods for working with database in separate file
        // TODO Add number of questions
        // TODO randomize questions for numbers

        Scanner scan = new Scanner(System.in);
        ArrayList<String> questions = new ArrayList<>();
        questions.add("What is the fastest animal in the world?");
        questions.add("What is the current JAVA version");
        questions.add("Which fictional city is the home of Batman?");
        questions.add("Spinach was falsely know for high content of which mineral?");
        questions.add("Who was known as the Maid of Orleans?");
        questions.add("In the film Babe, what type of animal was Babe?");
        questions.add("What was Mohammed Ali’s birth name?");
        questions.add("Which Roman emperor supposedly fiddled while Rome burned?");
        questions.add("What’s the total number of dots on a pair of dice?");
        questions.add("Traditionally, how many Wonders of the World are there?");
        questions.add("Which planet is the closest to Earth?");
        questions.add("According to the old proverb, to which European capital city do all roads lead?");
        questions.add("Which is the tallest mammal?");
        questions.add("What is the name of the fairy in Peter Pan?");
        questions.add("Who directed the movie Jaws?");
        questions.add("How many strings does a violin have?");
        questions.add("What color is the circle on the Japanese national flag?");
        questions.add("What is the chemical symbol for Hydrogen?");
        questions.add("How many sides does an hexagon have?");
        questions.add("What is the name of the city where the cartoon family The Simpsons live?");
        questions.add("The title role of the 1990 movie “Pretty Woman” was played by which actress?");
        questions.add("What is another word for lexicon?");
        questions.add("What is the world's longest river?");
        questions.add("Who played Neo in The Matrix?");
        questions.add("What colour is dress, worn by a leading cyclist during races?");
        questions.add("What does NFL stands for?");
        questions.add("Exact date of the velvet revolution?");
        questions.add("Who sings the song Like a Virgin?");
        questions.add("Who is the wealthiest man in the world?");
        questions.add("What is the fastest animal in the world?");

        ArrayList<String> answers = new ArrayList<>();
        answers.add("Cheetah");
        answers.add("10");
        answers.add("Gotham City");
        answers.add("Iron");
        answers.add("Joan of Arc");
        answers.add("Pig");
        answers.add("Cassius Clay");
        answers.add("Nero");
        answers.add("42");
        answers.add("7");
        answers.add("Venus");
        answers.add("Rome");
        answers.add("Giraffe");
        answers.add("Tinkerbell");
        answers.add("Steven Spielberg");
        answers.add("4");
        answers.add("Red");
        answers.add("H");
        answers.add("6");
        answers.add("Springfield");
        answers.add("Julia Roberts");
        answers.add("Dictionary");
        answers.add("Amazon");
        answers.add("Keanu Reeves");
        answers.add("Yellow");
        answers.add("National Football League");
        answers.add("17.11.1989");
        answers.add("Maddona");
        answers.add("Jeff Bezos");
        answers.add("Cheetah");




        System.out.println(questions.get(questionNumber - 1));
        System.out.println();
        System.out.println(showFirstLetters(answers.get(questionNumber - 1)));
        System.out.println();
        String answer = scan.nextLine();
        if (answer.equals(answers.get(questionNumber-1))) {
            return true;
        } else {
            return false;
        }
    }
    //Returns the first letters of every answer
    public static String showFirstLetters (String string) {
        String toReturn = String.valueOf(string.charAt(0));
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                toReturn+=String.valueOf(string.charAt(i+1));
            }
        }
        return toReturn;
    }
    // main drawing function, prints the board of hexagons, count what is the current hexagon and if that equals blue or
    // yellow prints respective coloured hexagon instead of the blank one.
    public static void drawBoard(Graphics graphics, ArrayList<Integer> blueHexes, ArrayList<Integer> yellowHexes) {
        int startX = WIDTH / 2;
        int startY = 50;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                sum++;
                if (blueHexes.contains(sum)) {
                    graphics.setColor(Color.BLUE);
                    fillHexagon(graphics, (int) (startX + (2*j*L)), startY);
                } else if (yellowHexes.contains(sum)){
                    graphics.setColor(Color.YELLOW);
                    fillHexagon(graphics, (int) (startX + (2*j*L)), startY);
                } else {
                    graphics.setColor(Color.BLACK);
                    drawHexagon(graphics, (int) (startX + (2 * j * L)), startY, 1);
                    graphics.drawString(Integer.toString(sum), (int) (startX + (2 * j * L) - 5), startY + A + 5);
                }
            }
            startX -= (int) (L);
            startY += (int) (1.5 * A);
        }
    }
    // basic function for printing blank hexagons
    public static void drawHexagon(Graphics graphics, int startX, int startY, int boarder) {
        for (int i = 0; i < boarder; i++) {
            int[] x = {startX, (int) (startX - L) + i, (int) (startX - L) + i, startX, (int) (startX + L) - i, (int) (startX + L) - i};
            int[] y = {startY + i, (int) (startY + 0.5 * A), (int) (startY + 1.5 * A), (int) (startY + 2 * A) - i, (int) (startY + 1.5 * A), (int) (startY + 0.5 * A)};
            graphics.drawPolygon(x, y, 6);
        }
    }
    // basic function for printing coloured hexagons
    public static void fillHexagon(Graphics graphics, int startX, int startY) {
        int[] x = {startX, (int) (startX - L), (int) (startX - L), startX, (int) (startX + L), (int) (startX + L)};
        int[] y = {startY, (int) (startY + 0.5 * A), (int) (startY + 1.5 * A), (int) (startY + 2 * A), (int) (startY + 1.5 * A), (int) (startY + 0.5 * A)};
        graphics.fillPolygon(x, y, 6);
        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(x, y, 6);

    }

    // Don't touch the code below - I TOUCHED THE CODE!
    static int WIDTH = 500;
    static int HEIGHT = 500;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel PANEL = new ImagePanel();
        PANEL.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(PANEL);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();

        // TODO create a counter from 30-0 and after that the turn is over
        // TODO make the counter Graphical not numbers
        // TODO CREATE WIN CONDITION!!
        System.out.println("Player one please enter your name: ");
        String player1 = scan.nextLine();
        System.out.println("Player two please enter your name: ");
        String player2 = scan.nextLine();
        for (int i = 0; i < 100; i++) {
            PANEL.repaint();
            if (i % 2 == 0) {
                System.out.println(player1 + " please choose your number: ");
                int number = scan.nextInt();
                if (rightAnswer(number)) {
                    YELLOWHEXES.add(number);
                }
            } else {
                System.out.println(player2 + " please choose your number: ");
                int number = scan.nextInt();
                if (rightAnswer(number)) {
                    BLUEHEXES.add(number);
                }
            }
        }

    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}