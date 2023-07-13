import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registro {
    private JPanel registro;
    private JTextField nombre;
    private JLabel labelNombre;
    private JLabel labelEdad;
    private JLabel labelSexo;
    private JTextField edad;
    private JTextField sexo;
    private JButton registrateButton;

    public registro() {
        registrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreIngreso = nombre.getText();
                int edadIngreso = Integer.parseInt(edad.getText());
                String sexoIngreso = sexo.getText();

                String filePath = "datos.txt";
                Datos ingreso = new Datos(nombreIngreso,edadIngreso, sexoIngreso);
                try(
                        FileOutputStream fileOut=new FileOutputStream(filePath);
                        ObjectOutputStream obOut=new ObjectOutputStream(fileOut);
                ){
                    obOut.writeObject(ingreso);
                    System.out.println("archivo escrito correctamente");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("registro");
        frame.setContentPane(new registro().registro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

