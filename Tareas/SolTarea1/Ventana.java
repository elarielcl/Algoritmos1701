import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ventana {

    private Canvas frame;
    private int size;

    private class Canvas extends JFrame{

        private Graphics2D canvas;
        private Image img;
        private Color[] colores;

        Canvas(String title) {
            super(title);
        }

        void config(int s){
            img = this.createImage(s, s);
            canvas = (Graphics2D) img.getGraphics();
            /*colores = new Color[]{Color.decode("#ffffff"), Color.decode("#f1e782"),
                    Color.decode("#dab143"), Color.decode("#a37e2a")};*/
            colores = new Color[]{Color.decode("#ffffff"), Color.YELLOW,
                    Color.RED, Color.BLACK};
        }

        @Override
        public void paint(Graphics g) {
            g.drawImage(img,0,0,this);
        }

        void drawRect(int val, double x, double y, double w, double h) {
            if(val == 0) return;
            canvas.setColor(colores[val]);
            canvas.fill(new Rectangle2D.Double(x,y,w,h));
            this.repaint();
        }
    }

    public Ventana(int size, String title) {
        this.size = size;
        frame = new Canvas(title);
        frame.setMinimumSize(new Dimension(size, size));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.config(size);
    }

    public Ventana(int size){
        this(size,"Ventana");
    }

    public void mostrarMatriz(int[][] M){
        double dim = (double) size / M.length;
        for (int i = 0; i < M.length; i++) {
            int[] fila = M[i];
            for (int j = 0; j < fila.length; j++) {
                int celda = fila[j];
                frame.drawRect(celda, dim*j,dim*i, dim, dim);
            }
        }
    }
}
