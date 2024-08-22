package presentacion;

import javax.swing.JInternalFrame;
import excepciones.ClienteRepetidoException;
import logica.ISistema;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class CrearCliente extends JInternalFrame {

    private ISistema Sis;

    private JTextField textFieldNickname;
    private JTextField textFieldEmail;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JDateChooser dateChooser;
    
    private JLabel lblIngreseNickname;
    private JLabel lblIngreseEmail;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseFechaNac;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public CrearCliente(ISistema isis) {
        Sis = isis;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Cliente");
        setBounds(10, 40, 360, 250);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 150, 150, 0 };
        gridBagLayout.rowHeights = new int[] { 25, 25, 25, 25, 25, 25, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);
        
        lblIngreseNickname = new JLabel("Nickname:");
        lblIngreseNickname.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNickname = new GridBagConstraints();
        gbc_lblIngreseNickname.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseNickname.gridx = 0;
        gbc_lblIngreseNickname.gridy = 0;
        getContentPane().add(lblIngreseNickname, gbc_lblIngreseNickname);
        
        textFieldNickname = new JTextField();
        GridBagConstraints gbc_textFieldNickname = new GridBagConstraints();
        gbc_textFieldNickname.gridwidth = 2;
        gbc_textFieldNickname.insets = new Insets(2, 2, 2, 5);
        gbc_textFieldNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNickname.gridx = 1;
        gbc_textFieldNickname.gridy = 0;
        getContentPane().add(textFieldNickname, gbc_textFieldNickname);
        textFieldNickname.setColumns(10);
        
        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseEmail = new GridBagConstraints();
        gbc_lblIngreseEmail.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseEmail.gridx = 0;
        gbc_lblIngreseEmail.gridy = 1;
        getContentPane().add(lblIngreseEmail, gbc_lblIngreseEmail);
        
        textFieldEmail = new JTextField();
        GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
        gbc_textFieldEmail.gridwidth = 2;
        gbc_textFieldEmail.insets = new Insets(2, 2, 2, 5);
        gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldEmail.gridx = 1;
        gbc_textFieldEmail.gridy = 1;
        getContentPane().add(textFieldEmail, gbc_textFieldEmail);
        textFieldEmail.setColumns(10);

        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
        gbc_lblIngreseNombre.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseNombre.gridx = 0;
        gbc_lblIngreseNombre.gridy = 2;
        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);

        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.gridwidth = 2;
        gbc_textFieldNombre.insets = new Insets(2, 2, 2, 5);
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 2;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);

        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
        gbc_lblIngreseApellido.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseApellido.gridx = 0;
        gbc_lblIngreseApellido.gridy = 3;
        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.gridwidth = 2;
        gbc_textFieldApellido.insets = new Insets(2, 2, 2, 5);
        gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 3;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);

        lblIngreseFechaNac = new JLabel("Fecha de Nacimiento:");
        lblIngreseFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseFechaNac = new GridBagConstraints();
        gbc_lblIngreseFechaNac.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseFechaNac.gridx = 0;
        gbc_lblIngreseFechaNac.gridy = 4;
        getContentPane().add(lblIngreseFechaNac, gbc_lblIngreseFechaNac);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy"); // Configura el formato de la fecha
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.gridwidth = 2;
        gbc_dateChooser.insets = new Insets(2, 2, 2, 5);
        gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateChooser.gridx = 1;
        gbc_dateChooser.gridy = 4;
        getContentPane().add(dateChooser, gbc_dateChooser);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cmdRegistroClienteActionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.insets = new Insets(2, 2, 2, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 5;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.insets = new Insets(2, 2, 2, 5);
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 5;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
    }

    protected void cmdRegistroClienteActionPerformed(ActionEvent arg0) {
        String nicknameP = textFieldNickname.getText();
        String emailP = textFieldEmail.getText();
        String nombreP = textFieldNombre.getText();
        String apellidoP = textFieldApellido.getText();
        String fNacimientoP = obtenerFechaString(); // Convierte la fecha a String

        if (checkFormulario()) {
            try {
                Sis.registrarCliente(nicknameP, emailP, nombreP, apellidoP, fNacimientoP); // Se pasa la fecha como String

                JOptionPane.showMessageDialog(this, "El Cliente se ha creado con éxito", "Registrar Cliente",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (ClienteRepetidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
            }

            limpiarFormulario();
            setVisible(false);
        }
    }

    private boolean checkFormulario() {
        String nickname = textFieldNickname.getText();
        String email = textFieldEmail.getText();
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String fechaNac = obtenerFechaString(); // Obtiene la fecha como String

        if (nickname.isEmpty() || email.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNac == null) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Cliente",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void limpiarFormulario() {
        textFieldNickname.setText("");
        textFieldEmail.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        dateChooser.setDate(null);
    }

    private String obtenerFechaString() {
        Date fecha = dateChooser.getDate();
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(fecha);
        } else {
            return null; // O cualquier valor que indique que la fecha no está disponible
        }
    }
}


