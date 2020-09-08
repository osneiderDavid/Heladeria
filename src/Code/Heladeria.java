/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.List;

/**
 *
 * @author Parra
 */
interface Heladeria {
    public List Listado();
    public int Ingresar(Object []  obj);
    public int Modificar(Object [] obj);
    public List ListarAgotados();
    public int ModificarAgotados(Object [] obj);
}
