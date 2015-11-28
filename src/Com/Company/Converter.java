package Com.Company;
/**
 * Created by Thomas on 18-11-2015.
 */
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Converter {
    public static BufferedImage convert(BufferedImage image) {

        for (int y = 1; y < image.getHeight() - 1; y++) {
            for (int x = 1; x < image.getWidth() - 1; x++) {

                int mixedNumbersRed[] = new int[9];
                int mixedNumbersGreen[] = new int[9];
                int mixedNumbersBlue[] = new int[9];

                int c = image.getRGB(x, y);
                Color color = new Color(c);
                int c2 = image.getRGB(x - 1, y - 1);
                Color color2 = new Color(c2);
                int c3 = image.getRGB(x, y - 1);
                Color color3 = new Color(c3);
                int c4 = image.getRGB(x + 1, y - 1);
                Color color4 = new Color(c4);
                int c5 = image.getRGB(x - 1, y);
                Color color5 = new Color(c5);
                int c6 = image.getRGB(x + 1, y);
                Color color6 = new Color(c6);
                int c7 = image.getRGB(x - 1, y + 1);
                Color color7 = new Color(c7);
                int c8 = image.getRGB(x, y + 1);
                Color color8 = new Color(c8);
                int c9 = image.getRGB(x + 1, y + 1);
                Color color9 = new Color(c9);

                mixedNumbersRed[0] = color.getRed();
                mixedNumbersRed[1] = color2.getRed();
                mixedNumbersRed[2] = color3.getRed();
                mixedNumbersRed[3] = color4.getRed();
                mixedNumbersRed[4] = color5.getRed();
                mixedNumbersRed[5] = color6.getRed();
                mixedNumbersRed[6] = color7.getRed();
                mixedNumbersRed[7] = color8.getRed();
                mixedNumbersRed[8] = color9.getRed();

                mixedNumbersGreen[0] = color.getGreen();
                mixedNumbersGreen[1] = color2.getGreen();
                mixedNumbersGreen[2] = color3.getGreen();
                mixedNumbersGreen[3] = color4.getGreen();
                mixedNumbersGreen[4] = color5.getGreen();
                mixedNumbersGreen[5] = color6.getGreen();
                mixedNumbersGreen[6] = color7.getGreen();
                mixedNumbersGreen[7] = color8.getGreen();
                mixedNumbersGreen[8] = color9.getGreen();

                mixedNumbersBlue[0] = color.getBlue();
                mixedNumbersBlue[1] = color2.getBlue();
                mixedNumbersBlue[2] = color3.getBlue();
                mixedNumbersBlue[3] = color4.getBlue();
                mixedNumbersBlue[4] = color5.getBlue();
                mixedNumbersBlue[5] = color6.getBlue();
                mixedNumbersBlue[6] = color7.getBlue();
                mixedNumbersBlue[7] = color8.getBlue();
                mixedNumbersBlue[8] = color9.getBlue();

                for(int k = 0; k <7; k++) {
                    for (int j = 1; j < 9; j++) {
                        if (mixedNumbersRed[j] < mixedNumbersRed[j - 1]) {
                            int number = mixedNumbersRed[j];
                            mixedNumbersRed[j] = mixedNumbersRed[j - 1];
                            mixedNumbersRed[j - 1] = number;
                        }
                        if (mixedNumbersGreen[j] < mixedNumbersGreen[j - 1]) {
                            int number = mixedNumbersGreen[j];
                            mixedNumbersGreen[j] = mixedNumbersGreen[j - 1];
                            mixedNumbersGreen[j - 1] = number;
                        }
                        if (mixedNumbersBlue[j] < mixedNumbersBlue[j - 1]) {
                            int number = mixedNumbersBlue[j];
                            mixedNumbersBlue[j] = mixedNumbersBlue[j - 1];
                            mixedNumbersBlue[j - 1] = number;
                        }
                    }
                }

                int red = mixedNumbersRed[4];
                int green = mixedNumbersGreen[4];
                int blue = mixedNumbersBlue[4];

                if (red > 255) {
                    red = 255;
                } else if (red < 0) {
                    red = 0;
                }
                if (green > 255) {
                    green = 255;
                } else if (green < 0) {
                    green = 0;
                }
                if (blue > 255) {
                    blue = 255;
                } else if (blue < 0) {
                    blue = 0;
                }

                image.setRGB(x, y, new Color(red, green, blue).getRGB());

            }
        }
        return image;
    }
}