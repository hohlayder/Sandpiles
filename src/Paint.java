import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import static java.lang.Math.*;


public class Paint extends JPanel implements Runnable, MouseListener, KeyListener {

    public static int width, height, diagonal;
    public static int N = 751, M = 101;

    private int count_types = 3;
    private Color[] colors;
    Matrix matrix;
    private int start_x = M / 2, start_y = N - 2;
    boolean first_launch = true;

    public Thread thread;
    public static boolean running = false;
    private int delay = 500;

    public Paint() {
        setDoubleBuffered(true);
        addMouseListener(this);
        this.addKeyListener(this);
    }

    public void startTread() {
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (first_launch) {
            width = this.getWidth();
            height = this.getHeight();
            first_launch = false;
            colors = new Color[count_types];
            int value;
            for (int i = 0; i < count_types; i++) {
                value = 255 - 255 * i / (count_types - 1);
                colors[i] = new Color(value, value, value);
            }
            matrix = new Matrix(N, M, colors, 100000, start_x, start_y);
        }
        for (int i = 0; i < 100; i++) {
            matrix.spill_three_v3(); // функции тут менять можно!!!
        }
        //g.setColor(new Color(255, 255, 200));
        //g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        matrix.draw(g);
        g.setFont(new Font(null, Font.PLAIN, 20));
        g.drawString(Integer.toString(matrix.M[start_y][start_x]), 0, 20);
    }

    public void updateView() {
        width = getWidth();
        height = getHeight();
        diagonal = (int) Math.hypot(height, width);
    }

    @Override
    public void run() {
        while (running) {
            updateView();
            this.repaint();
//            try {
//                thread.sleep(delay);
//            } catch (InterruptedException e) {
//                running = false;
//                throw new RuntimeException(e);
//            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}