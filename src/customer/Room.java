package customer;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class Surface extends JPanel {
    Scanner input = new Scanner(System.in);
    Object room = new Object();
    public void Draw(Object object)
    {
        System.out.print("WIDTH : ");
        int width = input.nextInt();
        object.setWidth(width);
        System.out.print("HEIGHT : ");
        int height=input.nextInt();
        object.setHeight(height);
    }
    private void doDrawing(Graphics g, Object room) {
        Draw(room);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLUE);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        if (room.getWidth() != 0 && room.getHeight() != 0) {
            g2d.fillRect(0, 0, room.getWidth(), room.getHeight());
        } else {
            System.out.println("please input size of room !!");
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g,room);
    }
}
public class Room extends JFrame {
    public Room() {
        initUI();
    }
    private void initUI() {
        add(new Surface());
        setTitle("Room");
        setSize(1280, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Room room = new Room();
                room.setVisible(true);
            }
        });
    }
}
