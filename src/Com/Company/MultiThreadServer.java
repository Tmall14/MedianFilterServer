package Com.Company;

/**
 * Created by Thomas on 18-11-2015.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class MultiThreadServer  {
    ServerSocket ss;
    public MultiThreadServer() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Listening");
            while (true) {
                Socket s;

                s = ss.accept();
                Client c = new Client(s);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        new MultiThreadServer();
    }

    public class Client extends Thread implements Runnable {
        Socket s;

        public Client(Socket s) {
            this.s = s;
            this.start();
        }

        @Override
        public void run() {
            try {
                OutputStream out = s.getOutputStream();
                InputStream in = s.getInputStream();
                System.out.println("Got image IO connections to client");

                //Reading the bytes from client
                byte[] sizeAr = new byte[4];

                in.read(sizeAr);
                int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

                System.out.println("Getting image from client!");

                byte[] imageAr = new byte[size];
                in.read(imageAr);
                System.out.println("Read image data, converting to image.");

                //Converting bytes to the image
                BufferedImage bi = null;
                try {
                    bi = ImageIO.read(new ByteArrayInputStream(imageAr));
                }
                catch(EOFException e) {
                    System.out.println("Finished reading the image.");
                }

                System.out.println("Starting converting program.");
                //Converting the image
                BufferedImage converted = Converter.convert(bi);

                System.out.println("Done, sending image back to client.");

                //Sending converted image back to client

                //Creating byte array that represent the converted image
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                ImageIO.write(converted, "jpg", byteOut);

                byte[] cSize = ByteBuffer.allocate(4).putInt(byteOut.size()).array();

                //Sends the image
                out.write(cSize);
                out.write(byteOut.toByteArray());
                out.flush();

                in.close();
                out.close();
                s.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}