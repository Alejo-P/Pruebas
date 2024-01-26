import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

public class Formulario extends JFrame {
    public Formulario() {
        // Configuración del JFrame
        setTitle("Formulario de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        // Creación de JRadioButtons
        JRadioButton radioButtonMasculino = new JRadioButton("Masculino");
        JRadioButton radioButtonFemenino = new JRadioButton("Femenino");

        // Agrupación de JRadioButtons
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonMasculino);
        group.add(radioButtonFemenino);

        // Creación de JFormattedTextField con formato de fecha
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField formattedTextField = new JFormattedTextField(mask);

        // Manejo de eventos para JRadioButtons
        radioButtonMasculino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Formulario.this, "Seleccionaste: Masculino");
            }
        });

        radioButtonFemenino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Formulario.this, "Seleccionaste: Femenino");
            }
        });

        // Manejo de eventos para JFormattedTextField
        formattedTextField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                //JOptionPane.showMessageDialog(Formulario.this, "El campo de fecha de nacimiento obtuvo el foco");
            }

            public void focusLost(FocusEvent e) {
                //JOptionPane.showMessageDialog(Formulario.this, "El campo de fecha de nacimiento perdió el foco");
            }
        });

        // Agregar componentes al JFrame
        add(new JLabel("Género:"));
        add(new JLabel(""));

        add(radioButtonMasculino);
        add(radioButtonFemenino);

        add(new JLabel("Fecha de Nacimiento:"));
        add(formattedTextField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
}
