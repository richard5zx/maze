import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Constructor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class View extends JFrame {
    /**
     * Use 2d Array to represent the maze (graph)
     * 
     * maze[row][col]
     * 
     * Values: 0 = not visited
     *         1 = wall (blocked)
     *         2 = visited node
     *         3 = start node
     *         9 = target node
     *         
     * 
     */
    // Fields
    private int [][] maze = 
    { 
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,3,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    // Constructor
    public View() {
        this.setTitle("Maze");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 420);
        this.setVisible(true);
        
        // ICON
        ImageIcon image = new ImageIcon("resources/maze.png");
        this.setIconImage(image.getImage());
    }

    @Override
    public void paint(Graphics g) {

        g.translate(50, 50);
        for(int row = 0; row < maze.length; row++) {
            for(int col = 0; col < maze[row].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                       color = Color.BLACK;
                       break;
                    case 3:
                        color = Color.GREEN;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                
                // Border color
                g.setColor(Color.MAGENTA);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }
    }
}