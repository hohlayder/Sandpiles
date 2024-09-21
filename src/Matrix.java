import static java.lang.Math.min;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Matrix {
    int[][] M;
    int H, W;
    Color[] colors;
    Paint paint;

    public Matrix(int h, int w, Color[] colors, int first_value, int start_x, int start_y) {
        H = h;
        W = w;
        this.colors = colors;
        M = new int[H][W];
        M[start_y][start_x] = first_value;
    }

    public void spill_four() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 4) {
                    kf[x][y] -= 4;
                    kf[x - 1][y]++;
                    kf[x + 1][y]++;
                    kf[x][y - 1]++;
                    kf[x][y + 1]++;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }

    public void spill_eight() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 8) {
                    kf[x][y] -= 8;
                    kf[x - 1][y]++;
                    kf[x + 1][y]++;
                    kf[x][y - 1]++;
                    kf[x][y + 1]++;
                    kf[x - 1][y - 1]++;
                    kf[x + 1][y + 1]++;
                    kf[x + 1][y - 1]++;
                    kf[x - 1][y + 1]++;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }

    public void spill_twelve() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 12) {
                    kf[x][y] -= 12;
                    kf[x - 1][y] += 2;
                    kf[x + 1][y] += 2;
                    kf[x][y - 1] += 2;
                    kf[x][y + 1] += 2;
                    kf[x - 1][y - 1]++;
                    kf[x + 1][y + 1]++;
                    kf[x + 1][y - 1]++;
                    kf[x - 1][y + 1]++;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }

    public void spill_twelve_v2() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 12) {
                    kf[x][y] -= 12;
                    kf[x - 1][y] += 1;
                    kf[x + 1][y] += 1;
                    kf[x][y - 1] += 1;
                    kf[x][y + 1] += 1;
                    kf[x - 1][y - 1] += 2;
                    kf[x + 1][y + 1] += 2;
                    kf[x + 1][y - 1] += 2;
                    kf[x - 1][y + 1] += 2;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }

    public void spill_four_up() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 4) {
                    kf[x][y] -= 4;
                    kf[x - 1][y]++;
                    kf[x + 1][y]++;
                    kf[x][y - 1] += 2;
                    kf[x][y + 1] += 0;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }

    public void spill_three() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 3) {
                    kf[x][y] -= 3;
                    kf[x - 1][y + 1]++;
                    kf[x + 1][y + 1]++;
                    kf[x][y - 1]++;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }


    public void spill_three_v2() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[x][y] >= 3) {
                    kf[x][y] -= 3;
                    kf[x - 1][y - 1]++;
                    kf[x + 1][y]++;
                    kf[x][y + 1]++;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[x][y] += kf[x][y];
            }
        }
    }

    public void spill_three_v3() {
        int[][] kf = new int[H][W];
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                if (M[y][x] >= 3) {
                    kf[y][x] -= 3;
                    kf[y - 1][x - 1]++;
                    kf[y - 1][x]++;
                    kf[y - 1][x + 1]++;
                }
            }
        }
        for (int y = 1; y < H - 1; y++) {
            for (int x = 1; x < W - 1; x++) {
                M[y][x] += kf[y][x];
            }
        }
    }

    public void draw(Graphics g) {
        int mx = Paint.width / 2, my = Paint.height / 2;
        int wid, heg;
        if ((float)H/W > (float)Paint.height/Paint.width){
            heg = Paint.height;
            wid = heg*W/H;
        }
        else{
            wid = Paint.width;
            heg = wid*H/W;
        }
        int startx = mx - wid / 2, starty = my - heg / 2;
        BufferedImage image = new BufferedImage(Paint.M, Paint.N, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < Paint.N; y++) {
            for (int x = 0; x < Paint.M; x++) {
                image.setRGB(x, y, colors[min(M[y][x], colors.length - 1)].getRGB());
            }
        }
        g.drawImage(image, startx, starty, wid, heg, null);
    }
}
