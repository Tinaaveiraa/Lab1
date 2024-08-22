package presentacion;

import javax.swing.JInternalFrame;
import excepciones.ClienteNoExisteException;
import logica.DataCliente;
import logica.ISistema;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class InfoCliente extends JInternalFrame {

    private ISistema sistema;

    private JTextField textFieldNickname;
    private JTextField textFieldEmail;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldFechaNac; // Campo de texto para mostrar la fecha

    private JLabel lblNickname;
    private JButton btnBuscar;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblFechaNac;

    private JButton btnCerrar;
    private JLabel lblInfoCliente;
    private JDateChooser dateChooser;

    public InfoCliente(ISistema isis) {
        sistema = isis;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar Info Cliente");
        setBounds(30, 30, 400, 300);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 120, 200, 0 };
        gridBagLayout.rowHeights = new int[] { 25, 30, 30, 30, 30, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);

        lblNickname = new JLabel("Ingrese Nickname:");
        GridBagConstraints gbc_lblNickname = new GridBagConstraints();
        gbc_lblNickname.insets = new Insets(10, 10, 5, 5);
        gbc_lblNickname.anchor = GridBagConstraints.EAST;
        gbc_lblNickname.gridx = 0;
        gbc_lblNickname.gridy = 0;
        getContentPane().add(lblNickname, gbc_lblNickname);

        textFieldNickname = new JTextField();
        GridBagConstraints gbc_textFieldNickname = new GridBagConstraints();
        gbc_textFieldNickname.insets = new Insets(10, 0, 5, 10);
        gbc_textFieldNickname.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNickname.gridx = 1;
        gbc_textFieldNickname.gridy = 0;
        getContentPane().add(textFieldNickname, gbc_textFieldNickname);
        textFieldNickname.setColumns(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmdBuscarClienteActionPerformed(e);
            }
        });
        GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
        gbc_btnBuscar.insets = new Insets(10, 0, 5, 10);
        gbc_btnBuscar.gridx = 2;
        gbc_btnBuscar.gridy = 0;
        getContentPane().add(btnBuscar, gbc_btnBuscar);

        lblInfoCliente = new JLabel("Información de Cliente");
        GridBagConstraints gbc_lblInfoCliente = new GridBagConstraints();
        gbc_lblInfoCliente.insets = new Insets(10, 10, 5, 5);
        gbc_lblInfoCliente.gridwidth = 3;
        gbc_lblInfoCliente.gridx = 0;
        gbc_lblInfoCliente.gridy = 1;
        getContentPane().add(lblInfoCliente, gbc_lblInfoCliente);

        lblNombre = new JLabel("Nombre:");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(5, 10, 5, 5);
        gbc_lblNombre.anchor = GridBagConstraints.EAST;
        gbc_lblNombre.gridx = 0;
        gbc_lblNombre.gridy = 2;
        getContentPane().add(lblNombre, gbc_lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setEditable(false);
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.insets = new Insets(5, 0, 5, 10);
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 2;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);

        lblApellido = new JLabel("Apellido:");
        GridBagConstraints gbc_lblApellido = new GridBagConstraints();
        gbc_lblApellido.insets = new Insets(5, 10, 5, 5);
        gbc_lblApellido.anchor = GridBagConstraints.EAST;
        gbc_lblApellido.gridx = 0;
        gbc_lblApellido.gridy = 3;
        getContentPane().add(lblApellido, gbc_lblApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setEditable(false);
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.insets = new Insets(5, 0, 5, 10);
        gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 3;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);

        lblFechaNac = new JLabel("Fecha Nacimiento:");
        GridBagConstraints gbc_lblFechaNac = new GridBagConstraints();
        gbc_lblFechaNac.insets = new Insets(5, 10, 5, 5);
        gbc_lblFechaNac.anchor = GridBagConstraints.EAST;
        gbc_lblFechaNac.gridx = 0;
        gbc_lblFechaNac.gridy = 4;
        getContentPane().add(lblFechaNac, gbc_lblFechaNac);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.gridwidth = 2;
        gbc_dateChooser.insets = new Insets(5, 0, 5, 10);
        gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateChooser.gridx = 1;
        gbc_dateChooser.gridy = 4;
        getContentPane().add(dateChooser, gbc_dateChooser);

        textFieldFechaNac = new JTextField();
        textFieldFechaNac.setEditable(false);
        GridBagConstraints gbc_textFieldFechaNac = new GridBagConstraints();
        gbc_textFieldFechaNac.insets = new Insets(5, 0, 5, 10);
        gbc_textFieldFechaNac.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldFechaNac.gridx = 1;
        gbc_textFieldFechaNac.gridy = 5;
        getContentPane().add(textFieldFechaNac, gbc_textFieldFechaNac);
        textFieldFechaNac.setColumns(10);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
        gbc_btnCerrar.insets = new Insets(10, 0, 10, 10);
        gbc_btnCerrar.gridx = 2;
        gbc_btnCerrar.gridy = 6;
        getContentPane().add(btnCerrar, gbc_btnCerrar);
    }

    protected void cmdBuscarClienteActionPerformed(ActionEvent e) {
        DataCliente dc;
        try {
            dc = sistema.verInfoCliente(textFieldNickname.getText());
            textFieldNickname.setText(dc.getNickname());
            textFieldEmail.setText(dc.getEmail());
            textFieldNombre.setText(dc.getNombre());
            textFieldApellido.setText(dc.getApellido());
            
            // Convierte la fecha de nacimiento de DataCliente a String
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(dc.getfNacimiento());
            dateChooser.setDate(fecha);
            
            // Establece la fecha formateada en el textFieldFechaNac
            String fechaFormateada = sdf.format(fecha);
            textFieldFechaNac.setText(fechaFormateada);
        } catch (ClienteNoExisteException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Cliente", JOptionPane.ERROR_MESSAGE);
            limpiarFormulario();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar la fecha", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void limpiarFormulario() {
        textFieldNickname.setText("");
        textFieldEmail.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        dateChooser.setDate(null);
        textFieldFechaNac.setText("");
    }
}
