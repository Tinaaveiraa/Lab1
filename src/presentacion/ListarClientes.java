package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import excepciones.ClienteNoExisteException;
import logica.DataCliente;
import logica.ISistema;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ListarClientes extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private ISistema sistema;
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JComboBox<DataCliente> comboBoxClientes;
    private JLabel lblClientes;
    private JButton btnCerrar;

    /**
     * Create the frame.
     */
    public ListarClientes(ISistema isis) {
        // Se inicializa con el controlador de usuarios
        sistema = isis;
        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar un Cliente");
        setBounds(30, 30, 300, 100);
        
        // En este caso se utiliza un BorderLayout en donde los componentes se ubican según una orientación.
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Una etiqueta (JLabel) muestra el título de la lista que vendrá después.
        // Se ubica al norte del layout y el texto se centra horizontalmente.
        lblClientes = new JLabel("Clientes Registrados");
        lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblClientes, BorderLayout.NORTH);

        // Un combo (JComboBox) muestra la lista de usuarios registrados en el sistema.
        // Es posible utilizar otros componentes gráficos, esta es sólo una opción.
        // Se ubica al centro del layout.
        comboBoxClientes = new JComboBox<DataCliente>();
        getContentPane().add(comboBoxClientes, BorderLayout.CENTER);

        // Un botón (JButton) con un evento asociado que permite limpiar la lista 
        // de usuarios y cerrar la ventana (sólo la oculta).
        // Se ubica al sur del layout.
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxClientes.removeAllItems();
                setVisible(false);
            }
        });
        getContentPane().add(btnCerrar, BorderLayout.SOUTH);
    }

    // Método que permite cargar un nuevo modelo para el combo con la información
    // actualizada de usuarios, provista por la operación del sistema getUsuarios(). 
    // Se invoca el método antes de hacer visible el JInternalFrame
    public void cargarClientes() {
        DefaultComboBoxModel<DataCliente> model;
        try {
            model = new DefaultComboBoxModel<DataCliente>(sistema.getClientes());
            comboBoxClientes.setModel(model);
        } catch (ClienteNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }

    }

}