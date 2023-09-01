import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaApplication2 extends JFrame {
    
    public static void main(String[] args) {
        new JavaApplication2();

    }
    JTextField numMascotasField;
    JTextField horasPaseoField;
    JLabel resultadoLabel;

    public JavaApplication2() {
        // Configurar la ventana
        setTitle("Calculadora de Paseo de Perros");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel numMascotasLabel = new JLabel("Número de mascotas:");
        JLabel horasPaseoLabel = new JLabel("Horas de paseo:");
        JButton calcularButton = new JButton("Calcular Precio");
        resultadoLabel = new JLabel("");

        numMascotasField = new JTextField(10);
        horasPaseoField = new JTextField(10);

        // Configurar el botón para realizar el cálculo
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numMascota = Integer.parseInt(numMascotasField.getText());
                int horasPaseo = Integer.parseInt(horasPaseoField.getText());

                // Lógica de cálculo similar al código original
                String GRANDE = "grande";
                String MEDIANO = "mediano";
                String CHICO = "chico";
                int valorHora = 0;
                int valorTotal = 0;
                int valorDescuento = 0;
                int sumaTotal = 0;
                String[] tipoPerros;
                tipoPerros = new String[numMascota];

                for (int i = 0; i < numMascota; i++) {
                    tipoPerros[i] = JOptionPane.showInputDialog(null, "tamaño de su mascota ");

                    if (tipoPerros[i].equals(GRANDE)) {
                        valorHora = 10000 * horasPaseo;
                    } else if (tipoPerros[i].equals(MEDIANO)) {
                        valorHora = 5000 * horasPaseo;
                    } else if (tipoPerros[i].equals(CHICO)) {
                        valorHora = 2500 * horasPaseo;
                        System.out.print(valorHora + "\n");
                    }

                    sumaTotal += valorHora; // No es necesario convertir a int aquí
                    System.out.print(sumaTotal + "\n");

                    if (numMascota > 1) {
                        valorDescuento = (int) (sumaTotal * 0.10);
                        valorTotal = (int) (sumaTotal - valorDescuento);
                    } else {
                        valorTotal = sumaTotal;
                    }
                }

                String resultadoTexto = "Valor del Paseo: " + sumaTotal + "<br>"
                        + "El valor de Descuento es: " + valorDescuento + "<br>"
                        + "Valor total: " + valorTotal;
                resultadoLabel.setText("<html>" + resultadoTexto + "</html>");
            }
        });

        // Configurar el diseño
        
        add(numMascotasLabel);
        add(numMascotasField);
        add(horasPaseoLabel);
        add(horasPaseoField);
        add(calcularButton);
        add(new JLabel()); // Espacio en blanco
        add(resultadoLabel);

        // Mostrar la ventana
        setVisible(true);
    }

}
