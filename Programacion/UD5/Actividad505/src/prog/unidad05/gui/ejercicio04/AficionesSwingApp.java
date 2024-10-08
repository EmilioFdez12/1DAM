package prog.unidad05.gui.ejercicio04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AficionesSwingApp {

  private JFrame frame;
  private JLabel lblAficiones;
  private JCheckBox chckbxLectura;
  private JCheckBox chckbxSerie;
  private JCheckBox chckbxComic;
  private JCheckBox chckbxAnime;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AficionesSwingApp window = new AficionesSwingApp();
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
  public AficionesSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Aficiones", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
    
    JLabel lblTusAficionesSon = new JLabel("Tus Aficiones son:");
    
    lblAficiones = new JLabel(" ");
    
    chckbxLectura = new JCheckBox("Lectura");
    chckbxLectura.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizarAficiones();
      }
    });
    
    chckbxSerie = new JCheckBox("Serie");
    chckbxSerie.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
      }
    });
    
    chckbxComic = new JCheckBox("Comic");
    chckbxComic.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizarAficiones();
      }
    });
    
    chckbxAnime = new JCheckBox("Anime");
    chckbxAnime.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizarAficiones();
      }
    });
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(6)
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbxLectura)
            .addComponent(chckbxSerie)
            .addComponent(chckbxComic)
            .addComponent(chckbxAnime)))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(4)
          .addComponent(chckbxLectura)
          .addGap(3)
          .addComponent(chckbxSerie)
          .addGap(3)
          .addComponent(chckbxComic)
          .addGap(3)
          .addComponent(chckbxAnime))
    );
    panel.setLayout(gl_panel);
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(10)
              .addComponent(panel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(20)
              .addComponent(lblAficiones))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(20)
              .addComponent(lblTusAficionesSon, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(10, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(26)
          .addComponent(panel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
          .addGap(8)
          .addComponent(lblTusAficionesSon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
          .addGap(11)
          .addComponent(lblAficiones))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
  
  protected void actualizarAficiones() {
    String aficiones = "";
    
    if (chckbxLectura.isSelected()) {
      aficiones += "Lectura ";
    }
    if (chckbxSerie.isSelected()) {
      aficiones += "Series ";
    }
    if (chckbxComic.isSelected()) {
      aficiones += "Comic ";
    }
    if (chckbxAnime.isSelected()) {
      aficiones += "Anime ";
    }
    
    lblAficiones.setText(aficiones);
  }
}
