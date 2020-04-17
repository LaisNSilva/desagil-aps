package br.pro.hashi.ensino.desagil.aps.model.model;

import br.pro.hashi.ensino.desagil.aps.model.model.Emitter;

public interface Receiver {
    void connect(int inputIndex, Emitter emitter);
}
