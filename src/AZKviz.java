import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AZKviz {

    static int A = 30;
    static double L = (A * Math.sqrt(3.0)) / 2;
    static Scanner SCAN = new Scanner(System.in);

    public static void mainDraw(Graphics graphics) {
        System.out.println("Player one please enter your name: ");
        String player1 = SCAN.nextLine();
        System.out.println("Player two please enter your name: ");
        String player2 = SCAN.nextLine();
        drawBoard(graphics);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(player1 + " please choose your number: ");
                int number = SCAN.nextInt();
                if (checkForAnswer(number)) {
                    graphics.setColor(Color.BLUE);
                    changeBoardState(graphics, number);
                }
            } else {
                System.out.println(player2 + " please choose your number: ");
                int number = SCAN.nextInt();
                if (checkForAnswer(number)) {
                    graphics.setColor(Color.YELLOW);
                    changeBoardState(graphics, number);
                }
            }
        }
    }
    public static void changeBoardState (Graphics graphics, int number) {
        int startX = WIDTH / 2;
        int startY = 50;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                sum++;
                if (sum == number) {
                    fillHexagon(graphics, (int) (startX + (2 * j * L)), startY);
                }
            }
            startX -= (int) (L);
            startY += (int) (1.5 * A);
        }
    }

    public static boolean checkForAnswer (int questionNumber) {
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            questions.add(i, "What is the current field?");
            answers.add(i, Integer.toString(i + 1));
        }
        System.out.println(questions.get(questionNumber - 1));
        String answer = SCAN.next();
        if (answer.equals(answers.get(questionNumber-1))) {
            return true;
        } else {
            return false;
        }
    }

    public static void drawBoard(Graphics graphics) {
        int startX = WIDTH / 2;
        int startY = 50;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                sum++;
                drawHexagon(graphics, (int) (startX + (2 * j * L)), startY, 2);
                graphics.drawString(Integer.toString(sum), (int) (startX + (2 * j * L) - 5), startY + A + 5);
            }
            startX -= (int) (L);
            startY += (int) (1.5 * A);
        }
    }

    public static void drawHexagon(Graphics graphics, int startX, int startY, int boarder) {
        for (int i = 0; i < boarder; i++) {
            int[] x = {startX, (int) (startX - L) + i, (int) (startX - L) + i, startX, (int) (startX + L) - i, (int) (startX + L) - i};
            int[] y = {startY + i, (int) (startY + 0.5 * A), (int) (startY + 1.5 * A), (int) (startY + 2 * A) - i, (int) (startY + 1.5 * A), (int) (startY + 0.5 * A)};
            graphics.drawPolygon(x, y, 6);
        }
    }
    public static void fillHexagon(Graphics graphics, int startX, int startY) {
        int[] x = {startX, (int) (startX - L), (int) (startX - L), startX, (int) (startX + L), (int) (startX + L)};
        int[] y = {startY, (int) (startY + 0.5 * A), (int) (startY + 1.5 * A), (int) (startY + 2 * A), (int) (startY + 1.5 * A), (int) (startY + 0.5 * A)};
        graphics.fillPolygon(x, y, 6);

    }

    // Don't touch the code below
    static int WIDTH = 500;
    static int HEIGHT = 500;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}