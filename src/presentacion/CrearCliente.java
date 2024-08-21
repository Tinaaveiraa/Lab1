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
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class CrearCliente extends JInternalFrame {

    // Interface sistema
    private ISistema Sis;
    
    // Los componentes gráficos se agregan como atributos de la clase
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
   
    /**
     * Create the frame.
     */
    public CrearCliente(ISistema isis) {
        // Se inicializa con el Sistema
        Sis = isis;

        // Propiedades del JInternalFrame
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Cliente");
        setBounds(10, 40, 360, 220);

        // Configuración del layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 120, 120, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);
        
        // Etiqueta y campo para el nickname
        lblIngreseNickname = new JLabel("Nickname:");
        lblIngreseNickname.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNickname = new GridBagConstraints();
        gbc_lblIngreseNickname.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNickname.gridx = 0;
        gbc_lblIngreseNickname.gridy = 0;
        getContentPane().add(lblIngreseNickname, gbc_lblIngreseNickname);
        
        textFieldNickname = new JTextField();
        GridBagConstraints gbc_textFieldNickname = new GridBagConstraints();
        gbc_textFieldNickname.gridwidth = 2;
        gbc_textFieldNickname.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNickname.gridx = 1;
        gbc_textFieldNickname.gridy = 0;
        getContentPane().add(textFieldNickname, gbc_textFieldNickname);
        textFieldNickname.setColumns(10);
        
        // Etiqueta y campo para el email
        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseEmail = new GridBagConstraints();
        gbc_lblIngreseEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseEmail.gridx = 0;
        gbc_lblIngreseEmail.gridy = 1;
        getContentPane().add(lblIngreseEmail, gbc_lblIngreseEmail);
        
        textFieldEmail = new JTextField();
        GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
        gbc_textFieldEmail.gridwidth = 2;
        gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldEmail.gridx = 1;
        gbc_textFieldEmail.gridy = 1;
        getContentPane().add(textFieldEmail, gbc_textFieldEmail);
        textFieldEmail.setColumns(10);

        // Etiqueta y campo para el nombre
        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
        gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNombre.gridx = 0;
        gbc_lblIngreseNombre.gridy = 2;
        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);

        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.gridwidth = 2;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 2;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);

        // Etiqueta y campo para el apellido
        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
        gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseApellido.gridx = 0;
        gbc_lblIngreseApellido.gridy = 3;
        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.gridwidth = 2;
        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 3;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);

        // Etiqueta y campo para la fecha de nacimiento
        lblIngreseFechaNac = new JLabel("Fecha de Nacimiento:");
        lblIngreseFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseFechaNac = new GridBagConstraints();
        gbc_lblIngreseFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseFechaNac.gridx = 0;
        gbc_lblIngreseFechaNac.gridy = 4;
        getContentPane().add(lblIngreseFechaNac, gbc_lblIngreseFechaNac);

        dateChooser = new JDateChooser();
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.gridwidth = 2;
        gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateChooser.gridx = 1;
        gbc_dateChooser.gridy = 4;
        getContentPane().add(dateChooser, gbc_dateChooser);

        // Botón Aceptar
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cmdRegistroClienteActionPerformed(arg0);
            }
        });

        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 5;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        // Botón Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 5;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
    }

    // Método para registrar un cliente
    protected void cmdRegistroClienteActionPerformed(ActionEvent arg0) {

        String nicknameC = this.textFieldNickname.getText();
        String emailC = this.textFieldEmail.getText();
        String nombreC = this.textFieldNombre.getText();
        String apellidoC = this.textFieldApellido.getText();
        Date fNacimientoC = this.dateChooser.getDate();

        if (checkFormulario()) {
            try {
                Sis.registrarCliente(nicknameC, emailC, nombreC, apellidoC, fNacimientoC);

                // Mostrar éxito de la operación
                JOptionPane.showMessageDialog(this, "El Cliente se ha creado con éxito", "Registrar Cliente",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (ClienteRepetidoException e) {
                // Mostrar error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Cliente", JOptionPane.ERROR_MESSAGE);
            }

            limpiarFormulario();
            setVisible(false);
        }
    }

    // Validación del formulario
    private boolean checkFormulario() {
        String nickname = this.textFieldNickname.getText();
        String email = this.textFieldEmail.getText();
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        Date fechaNac = this.dateChooser.getDate();

        if (nickname.isEmpty() || email.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNac == null) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Cliente",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Limpieza del formulario
    private void limpiarFormulario() {
        this.textFieldNickname.setText("");
        this.textFieldEmail.setText("");
        this.textFieldNombre.setText("");
        this.textFieldApellido.setText("");
        this.dateChooser.setDate(null);
    }
}

