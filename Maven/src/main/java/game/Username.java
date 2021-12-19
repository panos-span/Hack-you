package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Εισαγωγή username χρήστη και έλεγχος εγκυρότητας αυτού
 *
 * @author Team Hack-You
 */
public final class Username implements ActionListener {

    private final JFrame frame;
    private final JButton submit = new JButton("Submit");
    private final JTextField textField = new JTextField();
    //-------test changes------//
    private final JLabel label = new JLabel();

    private final ImageIcon icon2 = new ImageIcon("src/main/resources/buttons/wood1.png");

    /**
     * Θέλουμε να γνωρίζουν όλες οι κλάσεις το username του παίκτη ώστε να μπορεί να αποθηκευτεί πιο εύκολα
     */
    private static String username;

    public static String getUsername() {
        return username;
    }

    public Username() {
        // Εξατομίκευση παραθύρου
        frame = new JFrame();
        FrameSetter.setFrame(frame, "Set Username", 970, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonSetter.setButton(submit, 400, 350, 150, 45, "Calibri", 25, this, 1);
        submit.setIcon(icon2);

        textField.setBounds(325, 280, 300, 50);
        textField.setPreferredSize(new Dimension(300, 50));
        textField.setFont(new Font("Calibri", Font.BOLD, 25));
        textField.setSelectedTextColor(Color.green);

        GraphicPane graphicPane = new GraphicPane("Enter your username!",970,100,new Color(112, 96, 61),45,1);
        graphicPane.setBounds(0,100,970,150);
        frame.add(graphicPane);

        frame.add(submit);
        frame.add(textField);
        // Για να λειτουργεί το κουμπί enter
        frame.getRootPane().setDefaultButton(submit);
        FrameSetter.scaleBackground(label, 970, 850);
        frame.add(label);
    }

    /**
     * Ενέργεια όταν κάνουμε κλικ στο κουμπί ή όταν πατάμε enter
     * +! Γίνεται έλεγχος για την ύπαρξη κενών ώστε να μην κολλήσει μετά η καταχώρηση HighScore
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonSetter.playSE();
        if (e.getSource() == submit) {
            username = textField.getText();
            if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "You must enter your username!", "Reminder", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (username.toLowerCase(Locale.ROOT).equals("spanakis") || username.toLowerCase(Locale.ROOT).equals("panos") ||  username.toLowerCase(Locale.ROOT).equals("marios-spanakis")) {
                JOptionPane.showMessageDialog(null, "Congrats you won already on everything!", "Reminder", JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            } else if (username.toLowerCase(Locale.ROOT).equals("artopoulos")) {
                JOptionPane.showMessageDialog(null, "You lost already, good paradise", "Announcement", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            } else if (username.contains(" ")) {
                textField.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Your username cannot have whitespace", "Reminder", JOptionPane.ERROR_MESSAGE);
                textField.setForeground(Color.black);
                return;
            } else if (username.toLowerCase(Locale.ROOT).equals("athanasia")) {
                JOptionPane.showMessageDialog(null, "What are you doing here, why are you not with natassa (CRINGEEEEEEEEEEEEEEEEEEEEEEEEEEEEE)", "Announcement", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            }
            SwingUtilities.invokeLater(Menu::new);
        }
        frame.dispose();
    }


}
