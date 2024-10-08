package prog.unidad05.gui.ejercicio07;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AlumnosConNotaSwingApp {

  Random random = new Random();

  private JFrame frame;
  private JList<String> list;
  private JComboBox cbCalificacion;
  private JLabel lblSalida;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AlumnosConNotaSwingApp window = new AlumnosConNotaSwingApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public AlumnosConNotaSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 11, 414, 149);
    frame.getContentPane().add(scrollPane);

    list = new JList<String>();
    list.setModel(new DefaultListModel<String>());
    rellenaLista(list);
    scrollPane.setViewportView(list);

    cbCalificacion = new JComboBox();
    cbCalificacion.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        contarNotas();
      }
    });
    cbCalificacion.setModel(new DefaultComboBoxModel<> (new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
    cbCalificacion.setBounds(10, 171, 58, 34);
    frame.getContentPane().add(cbCalificacion);
    
    
    lblSalida = new JLabel("  ");
    lblSalida.setBounds(78, 177, 313, 22);
    frame.getContentPane().add(lblSalida);
     
  }

  private void rellenaLista(JList<String> lstLista) {
    // Creamos un nuevo modelo para la lita
    DefaultListModel<String> modelo = new DefaultListModel<>();
    // Generador de números aleatorios
    Random random = new Random();
    // Para el número de calificaciones a generar
    for (int i = 0; i < 30; i++) {
      // La genera (en número)
      int calificacionEntera = random.nextInt(0, 10 + 1);
      // Y la añade al modelo (debe ser una cadena)
      modelo.addElement(String.valueOf(calificacionEntera));
    }
    // Asignamos el modelo a la lista
    lstLista.setModel(modelo);
}

  private void contarNotas() {
   String calificacion = (String) cbCalificacion.getSelectedItem();
   
   DefaultListModel<String> modelo = (DefaultListModel<String>)list.getModel();
   int contadorAparaciones = 0;
   
   for (int i = 0; i < modelo.size(); i++) {
    if (modelo.get(i).equals(calificacion)) {
      contadorAparaciones++;
    }
  }
   lblSalida.setText(String.format("Hay %d alumnos con una calificacion %s", contadorAparaciones, calificacion));
   
  }
}
