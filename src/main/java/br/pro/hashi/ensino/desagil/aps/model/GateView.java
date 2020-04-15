package br.pro.hashi.ensino.desagil.aps.model;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

public class GateView extends JPanel implements ItemListener {
    private final Gate gate;
    private final Switch entradaUm;
    private final Switch entradaDois;


    private final JCheckBox entradaUmField;
    private final JCheckBox entradaDoisField;
    private final JCheckBox saidaField;

    public GateView(Gate gate){
        this.gate = gate;


        entradaUmField = new JCheckBox();
        entradaUmField.setMnemonic (KeyEvent.VK_C);
        entradaUmField.setSelected (false);

        entradaDoisField = new JCheckBox();
        entradaDoisField.setMnemonic (KeyEvent.VK_C);
        entradaDoisField.setSelected (false);

        saidaField = new JCheckBox();
        saidaField.setMnemonic (KeyEvent.VK_C);
        saidaField.setSelected (false);

        entradaUm= new Switch();
        entradaDois = new Switch();



        JLabel entradaLabel = new JLabel("Entrada:");
        JLabel saidaLabel = new JLabel("Saída:");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(entradaLabel);
        add(entradaUmField);
        add(entradaDoisField);
        add(saidaLabel);
        add(saidaField);

        gate.connect(0, entradaUm);
        gate.connect(1, entradaDois);

        entradaUmField.addItemListener(this);
        entradaDoisField.addItemListener(this);


        saidaField.setEnabled(false);

        update();

    }

    private void update() {
        boolean eUm;
        boolean eDois;

        eUm = entradaUmField.isSelected();
        eDois = entradaDoisField.isSelected();

        if (eUm == true && eDois == true){
            entradaUm.turnOn();
            entradaDois.turnOn();
        } else if (eUm == true && eDois == false){
            entradaUm.turnOn();
            entradaDois.turnOff();
        } else if (eUm == false && eDois == true){
            entradaUm.turnOff();
            entradaDois.turnOn();

        } else{
            entradaUm.turnOff();
            entradaDois.turnOff();
        }




        saidaField.setSelected(this.gate.read());
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        update();

    }
}
