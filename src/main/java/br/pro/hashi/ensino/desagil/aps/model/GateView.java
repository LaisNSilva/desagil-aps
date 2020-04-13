package br.pro.hashi.ensino.desagil.aps.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

public class GateView extends JPanel implements ActionListener{
    private final Gate gate;

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



        JLabel entradaLabel = new JLabel("Entrada:");
        JLabel saidaLabel = new JLabel("Saída:");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(entradaLabel);
        add(entradaUmField);
        add(entradaDoisField);
        add(saidaLabel);
        add(saidaField);

        entradaUmField.addActionListener(this);
        entradaDoisField.addActionListener(this);


        saidaField.setEnabled(false);

        update();

    }

    private void update() {
        int entradaUm;
        int entradaDois;



        int saida = gate.getInputSize(entradaUm);
    }

    public void verificaValor(int entradaUm){
        if(entradaUm == 1){
            entradaUmField.turnOn();
        }
        else{
            entradaUmField.turnOff();
        }

    }


    @Override
    public void actionPerformed(ActionEvent event) {

        update();
    }




}
