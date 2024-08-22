package presentacion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import excepciones.ProveedorRepetidoException;
import logica.ISistema;

@SuppressWarnings("serial")
public class CrearProveedor extends JInternalFrame {

    private ISistema Sis;

    private JTextField textFieldNickname;
    private JTextField textFieldEmail;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldNombreEmpresa;
    private JTextField textFieldUrlEmpresa;
    private JDateChooser dateChooser;
    
    private JLabel lblIngreseNickname;
    private JLabel lblIngreseEmail;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseFechaNac;
    private JLabel lblIngreseNombreEmpresa;
    private JLabel lblIngreseUrlEmpresa;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public CrearProveedor(ISistema isis) {
        Sis = isis;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Proveedor");
        setBounds(10, 40, 360, 300);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 150, 150, 0 };
        gridBagLayout.rowHeights = new int[] { 25, 25, 25, 25, 25, 25, 25, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

        lblIngreseNombreEmpresa = new JLabel("Nombre Empresa:");
        lblIngreseNombreEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNombreEmpresa = new GridBagConstraints();
        gbc_lblIngreseNombreEmpresa.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseNombreEmpresa.gridx = 0;
        gbc_lblIngreseNombreEmpresa.gridy = 5;
        getContentPane().add(lblIngreseNombreEmpresa, gbc_lblIngreseNombreEmpresa);

        textFieldNombreEmpresa = new JTextField();
        GridBagConstraints gbc_textFieldNombreEmpresa = new GridBagConstraints();
        gbc_textFieldNombreEmpresa.gridwidth = 2;
        gbc_textFieldNombreEmpresa.insets = new Insets(2, 2, 2, 5);
        gbc_textFieldNombreEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombreEmpresa.gridx = 1;
        gbc_textFieldNombreEmpresa.gridy = 5;
        getContentPane().add(textFieldNombreEmpresa, gbc_textFieldNombreEmpresa);
        textFieldNombreEmpresa.setColumns(10);

        lblIngreseUrlEmpresa = new JLabel("URL Empresa:");
        lblIngreseUrlEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseUrlEmpresa = new GridBagConstraints();
        gbc_lblIngreseUrlEmpresa.insets = new Insets(2, 2, 2, 5);
        gbc_lblIngreseUrlEmpresa.gridx = 0;
        gbc_lblIngreseUrlEmpresa.gridy = 6;
        getContentPane().add(lblIngreseUrlEmpresa, gbc_lblIngreseUrlEmpresa);

        textFieldUrlEmpresa = new JTextField();
        GridBagConstraints gbc_textFieldUrlEmpresa = new GridBagConstraints();
        gbc_textFieldUrlEmpresa.gridwidth = 2;
        gbc_textFieldUrlEmpresa.insets = new Insets(2, 2, 2, 5);
        gbc_textFieldUrlEmpresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldUrlEmpresa.gridx = 1;
        gbc_textFieldUrlEmpresa.gridy = 6;
        getContentPane().add(textFieldUrlEmpresa, gbc_textFieldUrlEmpresa);
        textFieldUrlEmpresa.setColumns(10);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cmdRegistroProveedorActionPerformed(arg0);
            }
        });
        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.insets = new Insets(2, 2, 2, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 7;
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
        gbc_btnCancelar.gridy = 7;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
    }

    protected void cmdRegistroProveedorActionPerformed(ActionEvent arg0) {
        String nicknameP = textFieldNickname.getText();
        String emailP = textFieldEmail.getText();
        String nombreP = textFieldNombre.getText();
        String apellidoP = textFieldApellido.getText();
        String nombreEmpresaP = textFieldNombreEmpresa.getText();
        String urlEmpresaP = textFieldUrlEmpresa.getText();
        Date fechaNacimientoP = dateChooser.getDate(); // Obtiene la fecha como Date

        if (checkFormulario()) {
            try {
                Sis.registrarProveedor(nicknameP, emailP, nombreP, apellidoP, nombreEmpresaP, urlEmpresaP, fechaNacimientoP); // Se pasan todos los datos

                JOptionPane.showMessageDialog(this, "El Proveedor se ha creado con éxito", "Registrar Proveedor",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (ProveedorRepetidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Proveedor", JOptionPane.ERROR_MESSAGE);
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
        String nombreEmpresa = textFieldNombreEmpresa.getText();
        String urlEmpresa = textFieldUrlEmpresa.getText();
        Date fechaNac = dateChooser.getDate(); // Obtiene la fecha como Date

        if (nickname.isEmpty() || email.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || nombreEmpresa.isEmpty() || urlEmpresa.isEmpty() || fechaNac == null) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Proveedor",
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
        textFieldNombreEmpresa.setText("");
        textFieldUrlEmpresa.setText("");
        dateChooser.setDate(null);
    }
}
