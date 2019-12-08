package dispositivosip;

import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface IArbolTrie {

    Collection<Dispositivo> buscarDispositivos(String subred);

    void insertar(Dispositivo dispositivo);
    
}
