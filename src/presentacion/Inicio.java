package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import logica.Fabrica;
import logica.ISistema;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class Inicio {

    private JFrame frmInicio;
    private ISistema ISis;
    private CrearCliente creCliInternalFrame;
    //private CrearProveedor creProvInternalFrame;
    private InfoCliente infoCliInternalFrame;
    private ListarClientes lisCliInternalFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inicio window = new Inicio();
                    window.frmInicio.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Inicio() {
        initialize();

        // Inicialización
        Fabrica fabrica = Fabrica.getInstance();
        ISis = fabrica.getISistema();
        
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        creCliInternalFrame = new CrearCliente(ISis);
        GridBagLayout gridBagLayout = (GridBagLayout) creCliInternalFrame.getContentPane().getLayout();
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
        creCliInternalFrame.setVisible(false);

        /*creProvInternalFrame = new CrearProveedor(ISis);
        GridBagLayout gridBagLayoutProv = (GridBagLayout) creProvInternalFrame.getContentPane().getLayout();
        gridBagLayoutProv.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
        gridBagLayoutProv.columnWeights = new double[]{0.0, 1.0, 0.0};
        creProvInternalFrame.setVisible(false);*/

        infoCliInternalFrame = new InfoCliente(ISis);
        infoCliInternalFrame.setVisible(false);

        lisCliInternalFrame = new ListarClientes(ISis);
        lisCliInternalFrame.setVisible(false);
        frmInicio.getContentPane().setLayout(null);

        frmInicio.getContentPane().add(creCliInternalFrame);
        //frmInicio.getContentPane().add(creProvInternalFrame);
        frmInicio.getContentPane().add(lisCliInternalFrame);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
        frmInicio = new JFrame();
        frmInicio.setTitle("Market");
        frmInicio.setBounds(100, 100, 450, 400);
        frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
        // Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un 
        // evento asociado que permite realizar una acción una vez se seleccionan. 
        JMenuBar menuBar = new JMenuBar();
        frmInicio.setJMenuBar(menuBar);

        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
                frmInicio.setVisible(false);
                frmInicio.dispose();
            }
        });
        menuSistema.add(menuSalir);

        JMenu menuUsuarios = new JMenu("Gestión de Usuarios");
        menuBar.add(menuUsuarios);

        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Cliente");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creCliInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemCrearProveedor = new JMenuItem("Registrar Proveedor");
        menuItemCrearProveedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para crear un proveedor
                //creProvInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemCrearProveedor);

        JMenuItem menuItemVerInfo = new JMenuItem("Ver Información Cliente");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
                infoCliInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem mntmListaClientes = new JMenuItem("Listar Clientes");
        mntmListaClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista
                lisCliInternalFrame.cargarClientes();
                lisCliInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmListaClientes);
    }
}

