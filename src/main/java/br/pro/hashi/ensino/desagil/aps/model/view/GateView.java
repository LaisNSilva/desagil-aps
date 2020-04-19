package br.pro.hashi.ensino.desagil.aps.model.view;

import br.pro.hashi.ensino.desagil.aps.model.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.model.Switch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GateView extends FixedPanel implements ItemListener, MouseListener {
    private final Gate gate;
    private final Switch[] switches;

    private final JCheckBox[] entradas;
    private final JCheckBox saidaField;
    private final Image image;
    private Color color;

    public GateView(Gate gate) {
        super(245, 250);

        this.gate = gate;



        int a = 0;
        switches = new Switch[gate.getInputSize()];
        while (a < gate.getInputSize()) {
            switches[a] = new Switch();
            a++;
        }

        entradas = new JCheckBox[gate.getInputSize()];
        int i = 0;
        while (i < gate.getInputSize()) {
            entradas[i] = new JCheckBox();
            entradas[i].setMnemonic(KeyEvent.VK_C);
            entradas[i].setSelected(false);
            if (gate.getInputSize()>1) {
                if (i == 0) {
                    add(entradas[i], 10, 87, 30, 25);
                }
                else if (i == 1) {
                    add(entradas[i], 10, 127, 30, 25);
                }
            }
            else if (gate.getInputSize()==1) {
                    add(entradas[i], 10, 107, 30, 25);
            }
            i++;

        }


        saidaField = new JCheckBox();
        saidaField.setMnemonic(KeyEvent.VK_C);
        saidaField.setSelected(false);



        /*
        JLabel entradaLabel = new JLabel("Entrada:");
        JLabel saidaLabel = new JLabel("Saída:");
        */

        color = Color.BLACK;


        String name = gate.toString() + ".png";
        URL url = getClass().getClassLoader().getResource(name);
        image = getToolkit().getImage(url);

        /*
        add(entradaLabel);
        int b = 0;
        while (b < gate.getInputSize()) {
            add(entradas[b]);
            b++;
        }

        add(saidaLabel);
        add(saidaField);
        */
        int c = 0;
        while (c < gate.getInputSize()) {
            gate.connect(c, switches[c]);
            c++;
        }

        saidaField.setEnabled(false);

        int d = 0;
        while (d < gate.getInputSize()) {
            entradas[d].addItemListener(this);
            d++;
        }

        addMouseListener(this);

        update();


    }

    private void update() {

        int e = 0;
        while (e < entradas.length) {
            if (entradas[e].isSelected()) {
                switches[e].turnOn();
            } else {
                switches[e].turnOff();
            }
            e++;
        }


        saidaField.setSelected(this.gate.read());
        if (gate.read() == true){
            color = Color.RED;
        }
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        update();

    }

    @Override
    public void mouseClicked(MouseEvent event) {


        int x = event.getX();
        int y = event.getY();

        // Se o clique foi dentro do quadrado colorido...
        if (x >= 210 && x < 235 && y >= 150 && y < 170) {

            // ...então abrimos a janela seletora de cor...
            color = JColorChooser.showDialog(this, null, color);

            // ...e chamamos repaint para atualizar a tela.
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        g.drawImage(image, 30, 70, 180, 100, this);

        g.setColor(color);
        g.fillRect(210, 108, 25, 25);

        getToolkit().sync();
    }
}
// 0-235  0-345