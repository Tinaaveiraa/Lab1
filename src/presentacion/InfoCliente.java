package presentacion;

import javax.swing.JInternalFrame;
import excepciones.ClienteNoExisteException;
import logica.DataCliente;
import logica.ISistema;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class InfoCliente extends JInternalFrame {

    private ISistema sistema;
    private JTextField textFieldNickname;
    private JTextField textFieldEmail;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JDateChooser dateChooser;
    private JLabel lblNickname;
    private JButton btnBuscar;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblFechaNac;
    private JButton btnCerrar;
    private JLabel lblInfoCliente;

    public InfoCliente(ISistema isis) {
        sistema = isis;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar Información de Cliente");
        setBounds(30, 30, 400, 320);

        getContentPane().setLayout(null);

        lblNickname = new JLabel("Ingrese Nickname:");
        lblNickname.setBounds(10, 24, 150, 14);
        getContentPane().add(lblNickname);

        textFieldNickname = new JTextField();
        textFieldNickname.setBounds(170, 20, 140, 30);
        getContentPane().add(textFieldNickname);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmdBuscarClienteActionPerformed(e);
            }
        });
        btnBuscar.setBounds(320, 20, 80, 30);
        getContentPane().add(btnBuscar);

        lblInfoCliente = new JLabel("Información de Cliente");
        lblInfoCliente.setBounds(10, 70, 200, 14);
        getContentPane().add(lblInfoCliente);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 100, 65, 14);
        getContentPane().add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setEditable(false);
        textFieldNombre.setBounds(80, 93, 260, 30);
        getContentPane().add(textFieldNombre);

        lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 140, 65, 14);
        getContentPane().add(lblApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setEditable(false);
        textFieldApellido.setBounds(80, 133, 260, 30);
        getContentPane().add(textFieldApellido);

        lblFechaNac = new JLabel("Fecha Nacimiento:");
        lblFechaNac.setBounds(10, 180, 120, 14);
        getContentPane().add(lblFechaNac);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBounds(140, 173, 200, 30);
        getContentPane().add(dateChooser);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
        btnCerrar.setBounds(290, 220, 80, 30);
        getContentPane().add(btnCerrar);
    }

    protected void cmdBuscarClienteActionPerformed(ActionEvent e) {
        DataCliente dc;
        try {
            dc = sistema.verInfoCliente(textFieldNickname.getText());
            textFieldNickname.setText(dc.getNickname());
            textFieldEmail.setText(dc.getEmail());
            textFieldNombre.setText(dc.getNombre());
            textFieldApellido.setText(dc.getApellido());

            // Convierte la fecha de nacimiento de DataCliente a Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(dc.getfNacimiento()); // `dc.getfNacimiento()` es el String de fecha
            dateChooser.setDate(fecha);

        } catch (ClienteNoExisteException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Cliente", JOptionPane.ERROR_MESSAGE);
            limpiarFormulario();
        } catch (ParseException ex) {
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
    }

    private String obtenerFechaString() {
        Date fecha = dateChooser.getDate();
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(fecha);
        } else {
            return null;
        }
    }
}

