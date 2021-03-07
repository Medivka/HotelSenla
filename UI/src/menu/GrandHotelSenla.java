package menu;

import javax.swing.*;
import java.awt.event.ContainerAdapter;

public class GrandHotelSenla extends  JFrame {
    private JPanel panel1;
    private JButton createOrderButton;
    private JButton createGuestButton;
    private JButton createRoomButton;
    private JButton createServiceButton;
    private JLabel grandHotelSenlaLabel;

    public GrandHotelSenla(){
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GrandHotelSenla();
    }



}
