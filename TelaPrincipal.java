import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

  public TelaPrincipal() {
    super();
    this.configurarFrame();
    }

  private void configurarFrame(){
    this.setTitle("Poker Game");
    this.setSize(600, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.getContentPane().setBackground(Color.LIGHT_GRAY);
    
  }
  
  public static void main(String[] args) {
      new TelaPrincipal().setVisible(true);
  }
}