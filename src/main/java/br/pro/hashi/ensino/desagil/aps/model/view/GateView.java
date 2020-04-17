package br.pro.hashi.ensino.desagil.aps.model.view;

import br.pro.hashi.ensino.desagil.aps.model.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.model.Switch;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class GateView extends JPanel implements ItemListener {
    private final Gate gate;
    private final Switch[] switches;

    private final JCheckBox[] entradas;
    private final JCheckBox saidaField;

    public GateView(Gate gate) {
        this.gate = gate;

        int a= 0;
        switches = new Switch[gate.getInputSize()];
        while (a < gate.getInputSize()){
            switches[a]=new Switch();
            a++;
        }

        entradas = new JCheckBox[gate.getInputSize()];
        int i = 0;
        while (i < gate.getInputSize()){
            entradas[i]=new JCheckBox();
            entradas[i].setMnemonic(KeyEvent.VK_C);
            entradas[i].setSelected(false);
            i++;

        }


        saidaField = new JCheckBox();
        saidaField.setMnemonic(KeyEvent.VK_C);
        saidaField.setSelected(false);


        JLabel entradaLabel = new JLabel("Entrada:");
        JLabel saidaLabel = new JLabel("Saída:");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(entradaLabel);
        int b= 0;
        while (b< gate.getInputSize()){
            add(entradas[b]);
            b++;
        }

        add(saidaLabel);
        add(saidaField);

        int c=0;
        while (c<gate.getInputSize()){
            gate.connect(c, switches[c]);
            c++;
        }

        saidaField.setEnabled(false);

        int d = 0;
        while (d<gate.getInputSize() ){
            entradas[d].addItemListener(this);
            d++;
        }

        update();


    }

    private void update() {

        int e =0;
        while (e< entradas.length){
            if (entradas[e].isSelected()) {
                switches[e].turnOn();
            } else{
                switches[e].turnOff();
            }
            e++;
        }


        saidaField.setSelected(this.gate.read());
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        update();

    }
}
