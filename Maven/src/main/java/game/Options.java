package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options implements ActionListener {

    JFrame frame;
    JLabel label = new JLabel();
    JButton returnBack = new JButton("return");
    JButton showGuide = new JButton("show Guide");
    JButton restart = new JButton("restart");
    JButton end = new JButton("exit");

    public Options() {
        frame = new JFrame();
        frame.setTitle("Options"); //setTitle of frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 650);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setIconImage(Main.icon.getImage());
        frame.setLocationRelativeTo(null);

        setButton(returnBack,200);
        setButton(showGuide,300);
        setButton(restart,400);
        setButton(end,500);

        frame.add(returnBack);
        frame.add(showGuide);
        frame.add(restart);
        frame.add(end);

        Image img = Main.background.getImage();
        Image temp = img.getScaledInstance(485, 650, Image.SCALE_SMOOTH);
        ImageIcon back = new ImageIcon(temp);
        label.setIcon(back);
        label.setBounds(0, 0, 500, 650);
        frame.add(label);
    }


    public void setButton(JButton button,int y) {
        button.setBounds(200,y,150,50);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setFont(new Font("Calibri", Font.ITALIC,20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == returnBack ){
            frame.dispose();
        }else if(e.getSource() == showGuide){
            SwingUtilities.invokeLater(Guide::new);
        }else if( e.getSource() == restart){
            LabyrinthFrame.closeFrame();
            new LabyrinthFrame();
            frame.dispose();
        }else {
            System.exit(1);
        }
        //Για να μην κολλήσει το progressBar
        LabyrinthFrame.updateBar(0);

    }
}