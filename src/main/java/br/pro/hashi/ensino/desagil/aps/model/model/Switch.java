package br.pro.hashi.ensino.desagil.aps.model.model;

import br.pro.hashi.ensino.desagil.aps.model.model.Emitter;

public class Switch implements Emitter {
    private boolean signal;

    public Switch() {
        signal = false;
    }

    public void turnOn() {
        signal = true;
    }

    public void turnOff() {
        signal = false;
    }

    @Override
    public boolean read() {
        return signal;
    }
}
