package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class InitializeGame implements ActionListener {

    public Board board = new Board();

    public JFrame frame = new JFrame();

    public void initialize() {
        //Creates frame
        frame.setTitle("Chesster: Collegiate Chess Game");
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setLocationRelativeTo(null);

        //Creates menu bar and items
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options:");
        JMenuItem resetGame = new JMenuItem("Reset Game");
        JMenuItem changeView = new JMenuItem("Change Color");
        menu.add(resetGame);
        menu.add(changeView);
        menuBar.add(menu);
        resetGame.addActionListener(this);
        changeView.addActionListener(this);

        //Adds board and menu to frame
        frame.add(board);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JMenuItem) {
            JMenuItem item = (JMenuItem) e.getSource();
            String text = item.getText();
            if(text.equals("Reset Game")) {
                board.resetGame();
                board.repaint();
            } else if(text.equals("Change Color")) {
                board.colorIndex++;
                board.repaint();
            }
        }
    }
}
