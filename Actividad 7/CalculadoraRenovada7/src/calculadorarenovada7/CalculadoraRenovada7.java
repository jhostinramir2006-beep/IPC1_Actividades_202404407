package calculadorarenovada7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Usuario {
    private String nombre;
    public Usuario(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
}

class CalculadoraModel {
    public int suma(int a, int b) { return a + b; }
    public int resta(int a, int b) { return a - b; }
    public int multiplicacion(int a, int b) { return a * b; }
    public double division(double a, double b) {
        if (b == 0) throw new ArithmeticException("No se puede dividir entre 0");
        return a / b;
    }
    public double potencia(double base, double exponente) { return Math.pow(base, exponente); }
    public double raiz(double indice, double radicando) { return Math.pow(radicando, 1.0 / indice); }
}

class CalculadoraView extends JFrame {
    JTextField campoUno = new JTextField(10);
    JTextField campoDos = new JTextField(10);
    JTextField campoResultado = new JTextField(15);
    JLabel usuarioLabel = new JLabel();
    JButton sumaBtn = new JButton("Suma");
    JButton restaBtn = new JButton("Resta");
    JButton multBtn = new JButton("Multiplicación");
    JButton divBtn = new JButton("División");
    JButton potBtn = new JButton("Potencia");
    JButton raizBtn = new JButton("Raíz");
    JButton salirBtn = new JButton("Salir");

    public CalculadoraView() {
        setTitle("Calculadora MVC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
        panel.add(new JLabel("Primer número / Base / Índice:"));
        panel.add(campoUno);
        panel.add(new JLabel("Segundo número / Exponente / Radicando:"));
        panel.add(campoDos);
        panel.add(new JLabel("Resultado:"));
        campoResultado.setEditable(false);
        panel.add(campoResultado);

        panel.add(sumaBtn);
        panel.add(restaBtn);
        panel.add(multBtn);
        panel.add(divBtn);
        panel.add(potBtn);
        panel.add(raizBtn);
        panel.add(salirBtn);

        JPanel usuarioPanel = new JPanel();
        usuarioPanel.add(usuarioLabel);

        getContentPane().add(usuarioPanel, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void setUsuario(String nombre) {
        usuarioLabel.setText("Usuario: " + nombre);
    }

    public void setResultado(String resultado) {
        campoResultado.setText(resultado);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void addOperacionListener(ActionListener listener) {
        sumaBtn.addActionListener(listener);
        restaBtn.addActionListener(listener);
        multBtn.addActionListener(listener);
        divBtn.addActionListener(listener);
        potBtn.addActionListener(listener);
        raizBtn.addActionListener(listener);
        salirBtn.addActionListener(listener);
    }
}

class CalculadoraController implements ActionListener {
    private CalculadoraModel modelo;
    private CalculadoraView vista;
    private Usuario usuario;

    public CalculadoraController(CalculadoraModel modelo, CalculadoraView vista, Usuario usuario) {
        this.modelo = modelo;
        this.vista = vista;
        this.usuario = usuario;
        vista.setUsuario(usuario.getNombre());
        vista.addOperacionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aStr = vista.campoUno.getText();
        String bStr = vista.campoDos.getText();
        double a, b;
        String resultado = "";
        try {
            if (e.getSource() == vista.sumaBtn) {
                int x = Integer.parseInt(aStr);
                int y = Integer.parseInt(bStr);
                resultado = String.valueOf(modelo.suma(x, y));
            } else if (e.getSource() == vista.restaBtn) {
                int x = Integer.parseInt(aStr);
                int y = Integer.parseInt(bStr);
                resultado = String.valueOf(modelo.resta(x, y));
            } else if (e.getSource() == vista.multBtn) {
                int x = Integer.parseInt(aStr);
                int y = Integer.parseInt(bStr);
                resultado = String.valueOf(modelo.multiplicacion(x, y));
            } else if (e.getSource() == vista.divBtn) {
                a = Double.parseDouble(aStr);
                b = Double.parseDouble(bStr);
                resultado = String.valueOf(modelo.division(a, b));
            } else if (e.getSource() == vista.potBtn) {
                a = Double.parseDouble(aStr);
                b = Double.parseDouble(bStr);
                resultado = String.valueOf(modelo.potencia(a, b));
            } else if (e.getSource() == vista.raizBtn) {
                a = Double.parseDouble(aStr);
                b = Double.parseDouble(bStr);
                resultado = String.valueOf(modelo.raiz(a, b));
            } else if (e.getSource() == vista.salirBtn) {
                System.exit(0);
            }
            vista.setResultado(resultado);
        } catch (NumberFormatException ex) {
            vista.mostrarError("Ingrese números válidos.");
        } catch (ArithmeticException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}

public class CalculadoraRenovada7 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String nombreUsuario = JOptionPane.showInputDialog(null, "Ingresa tu nombre de usuario:");
            if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) nombreUsuario = "Invitado";
            Usuario usuario = new Usuario(nombreUsuario);
            CalculadoraModel modelo = new CalculadoraModel();
            CalculadoraView vista = new CalculadoraView();
            new CalculadoraController(modelo, vista, usuario);
            vista.setVisible(true);
        });
    }
}