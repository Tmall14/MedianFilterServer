package Com.Company;

/**
 * Created by TM on 02-12-2015.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TM on 27-09-2015.
 */
public class ActorGUIVersion extends JFrame implements ActionListener {



    JTextArea messageField = new JTextArea("please select image and kernel size");
    JPanel container = new JPanel();
    JButton okButton = new JButton("Upload Image");





    public static void main(String[] args) {
        String[] choices = new String[]{"cats", "dogs"};
        String choice = askUser(choices);
        System.out.println("selected: " + choice);
    }


    public ActorGUIVersion() {
        JFrame F = new JFrame("ISMall");
        JMenuBar menubar = new JMenuBar();
        add(container);
        messageField.setSize(100, 100);
        messageField.setEnabled(false);
        messageField.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(messageField);
        container.add(okButton, BOTTOM_ALIGNMENT);

        okButton.addActionListener(this);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main() {
        ActorGUIVersion AGUIV = new ActorGUIVersion();
        AGUIV.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Select the image you want");
        EchoClient c = new EchoClient();

    }

    static String askUser(String[] choices) {
        String s = (String) JOptionPane.showInputDialog(
                null,
                "make your choice",
                "Try GUI",
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                choices[0]);
        return s;
    }
}