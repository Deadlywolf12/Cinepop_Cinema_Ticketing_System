import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import static java.awt.Font.BOLD;

public class Frameworkfunc {

    Font medF = new Font("Nexa Bold", BOLD, 20);


    public void colourBtn(JButton btn) {
        btn.setBackground(Color.darkGray);
        btn.setBorderPainted(false);
        btn.setForeground(Color.white);
        btn.setFont(medF);
        btn.addMouseListener(new MouseListener() {
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
                btn.setBackground(Color.LIGHT_GRAY);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.DARK_GRAY);

            }
        });
    }

    // colour jmenu items

    public void colourJMenu(JMenuItem menu) {
        menu.setFont(medF);
        menu.setForeground(Color.white);
        menu.setBackground(Color.black);
        menu.setBorderPainted(false);
    }



// created a method to turn textfeild colour to black on adding or clicking @ (attherate) button

    void atTheRate(JTextField anyTF) {

        anyTF.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyChar() == '@') {
                    anyTF.setForeground(Color.black);


                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    void checkPassStatus (String pass,JLabel jl){

        if(pass.length()>=7&&pass.length()<=9){
            jl.setText("Poor");
            jl.setForeground(Color.orange);
        }
        else if (pass.length()>9&&pass.length()<=11){
            jl.setText("Good");
            jl.setForeground(Color.YELLOW);
        }
        else if (pass.length()>11&&pass.length()<=15){
            jl.setText("Excellent");
            jl.setForeground(Color.GREEN);
        }

    }

    void textToNullOnClick (JTextField tf){
        tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf.setText("");
            }
        });
    }
}
