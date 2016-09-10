package net.TheDarkray.CC;

import net.TheDarkray.CC.Geometry.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

/**
 * Created by Dani on 10.09.2016.
 */
public class CCFrame extends JFrame implements KeyListener, ItemListener {

    private ButtonGroup bGroup;
    private JRadioButton [] radioButton;
    private JTextField input;
    private JLabel [] label;
    private JPanel panel;
    private Circle circle = new Circle();
    private boolean printStackTrace;
    private String selected;

    public CCFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.printStackTrace = false;
        this.setSize(300, 200);
        this.setTitle("Circle Calculator");
        selected = "radius";
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        bGroup = new ButtonGroup();

        radioButton = new JRadioButton[5];
        radioButton[0] = new JRadioButton("Center Angle: ");
        radioButton[1] = new JRadioButton("Radius: ", true);
        radioButton[2] = new JRadioButton("Diameter: ");
        radioButton[3] = new JRadioButton("Perimeter: ");
        radioButton[4] = new JRadioButton("Area: ");
        for (JRadioButton rb : radioButton) {
            rb.addItemListener(this);
            bGroup.add(rb);
            panel.add(rb);
        }


        input = new JTextField("", 6);
        input.setForeground(Color.BLACK);
        input.setBackground(Color.WHITE);
        input.setSize(300, 16);
        input.addKeyListener(this);
        panel.add(input);

        label = new JLabel[8];
        label[0] = new JLabel("Center Angle: NaN");
        label[1] = new JLabel("Radius:       NaN");
        label[2] = new JLabel("Diameter:     NaN");
        label[3] = new JLabel("Perimeter:    NaN");
        label[4] = new JLabel("Area:         NaN");
        label[5] = new JLabel("Sin:          NaN");
        label[6] = new JLabel("Cos:          NaN");
        label[7] = new JLabel("Tan:          NaN");
        for (JLabel l : label) {
            panel.add(l);
        }
        this.add(panel);
    }

    public CCFrame(int x, int y, boolean printStackTrace) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.printStackTrace = printStackTrace;
        this.setSize(x, y);
        this.setTitle("Circle Calculator");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        input = new JTextField("", 6);
        input.setForeground(Color.BLACK);
        input.setBackground(Color.WHITE);
        input.setSize(300, 16);
        input.addKeyListener(this);
        panel.add(input, BorderLayout.PAGE_START);

        label = new JLabel[4];
        label[0] = new JLabel("Radius:    NaN");
        label[1] = new JLabel("Diameter:  NaN");
        label[2] = new JLabel("Perimeter: NaN");
        label[3] = new JLabel("Area:      NaN");
        for (JLabel l : label) {
            panel.add(l);
        }
        this.add(panel);
    }

    public CCFrame(int x, int y) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.printStackTrace = false;
        this.setSize(x, y);
        this.setTitle("Circle Calculator");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        input = new JTextField("", 6);
        input.setForeground(Color.BLACK);
        input.setBackground(Color.WHITE);
        input.setSize(300, 16);
        input.addKeyListener(this);
        panel.add(input, BorderLayout.PAGE_START);

        label = new JLabel[4];
        label[0] = new JLabel("Radius:    NaN");
        label[1] = new JLabel("Diameter:  NaN");
        label[2] = new JLabel("Perimeter: NaN");
        label[3] = new JLabel("Area:      NaN");
        for (JLabel l : label) {
            panel.add(l);
        }
        this.add(panel);
    }

    public CCFrame(int x, int y, String title, boolean printStackTrace) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.printStackTrace = printStackTrace;
        this.setSize(x, y);
        this.setTitle(title);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        input = new JTextField("", 6);
        input.setForeground(Color.BLACK);
        input.setBackground(Color.WHITE);
        input.setSize(300, 16);
        input.addKeyListener(this);
        panel.add(input, BorderLayout.PAGE_START);

        label = new JLabel[4];
        label[0] = new JLabel("Radius:    NaN");
        label[1] = new JLabel("Diameter:  NaN");
        label[2] = new JLabel("Perimeter: NaN");
        label[3] = new JLabel("Area:      NaN");
        for (JLabel l : label) {
            panel.add(l);
        }
        this.add(panel);
    }

    public CCFrame(int x, int y, String title) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.printStackTrace = false;
        this.setSize(x, y);
        this.setTitle(title);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        input = new JTextField("", 6);
        input.setForeground(Color.BLACK);
        input.setBackground(Color.WHITE);
        input.setSize(300, 16);
        input.addKeyListener(this);
        panel.add(input, BorderLayout.PAGE_START);

        label = new JLabel[5];
        label[0] = new JLabel("Center Angle: NaN");
        label[1] = new JLabel("Radius:       NaN");
        label[2] = new JLabel("Diameter:     NaN");
        label[3] = new JLabel("Perimeter:    NaN");
        label[4] = new JLabel("Area:         NaN");
        for (JLabel l : label) {
            panel.add(l);
        }
        this.add(panel);
    }

    public void keyTyped(KeyEvent ke) {

    }

    public void keyPressed(KeyEvent ke) {
        System.out.println("Key Code: "+ke.getKeyCode());
    }

    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode()==10) {
            input.setText("");
        }
        if (Objects.equals(input.getText(), "-printStackTrace true")) {
            this.printStackTrace = true;
            input.setText("");
        } else if (Objects.equals(input.getText(), "-printStackTrace false")) {
            this.printStackTrace = false;
            input.setText("");
        }
        try {
            circle.set(selected, Double.parseDouble( input.getText() ));
            label[0].setText("Center Angle: "+ Double.toString( circle.getCenterAngle() ));
            label[1].setText("Radius:      " + Double.toString( circle.getRadius() ));
            label[2].setText("Diameter:    " + Double.toString( circle.getDiameter() ));
            label[3].setText("Perimeter:   " + Double.toString( circle.getPerimeter() ));
            label[4].setText("Area:        " + Double.toString( circle.getArea() ));
            label[5].setText("Sin:         " + Double.toString( circle.getSin() ));
            label[6].setText("Cos:         " + Double.toString( circle.getCos() ));
            label[7].setText("Tan:         " + Double.toString( circle.getTan() ));
        } catch (NumberFormatException nfe) {
            if (this.printStackTrace) {
                nfe.printStackTrace();
            }
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == this.radioButton[0]) {
            this.selected = "centerAngle";
        } else if (ie.getSource() == this.radioButton[1]) {
            this.selected = "radius";
        } else if (ie.getSource() == this.radioButton[2]) {
            this.selected = "diameter";
        } else if (ie.getSource() == this.radioButton[3]) {
            this.selected = "perimeter";
        } else if (ie.getSource() == this.radioButton[4]) {
            this.selected = "area";
        }
        input.setText("");
    }

}
