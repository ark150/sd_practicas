package algoritmosextra;

import java.awt.*;
import java.awt.event.*;

/**
 * Recurso
 * 
 * @author BaezCrdrm
 */
public class Recurso extends Frame implements ActionListener
{
    private String title;
    private Label lblTitle;

    public Recurso()
    {
        setTitle("Recurso compartido");
        setSize(600, 600);
        title = "Lorem ipsum";
        lblTitle = new Label(title);
        lblTitle.setAlignment(Label.CENTER);
        add(lblTitle);
        setLayout(new FlowLayout());
        setBackground(Color.BLUE);

        setVisible(true);
    }

    public void accesoRecurso(Color color)
    {
        setBackground(color);
        setVisible(true);
    }
    
    // public static void main(String[] args) {
    //     Recurso app = new Recurso();
    // }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}