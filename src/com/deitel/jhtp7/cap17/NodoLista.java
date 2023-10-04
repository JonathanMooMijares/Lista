
// Fig. 17.3: Lista.java
// Definiciones de las clases NodoLista y Lista.
package com.deitel.jhtp7.cap17;
// clase para representar un nodo en una lista
public class NodoLista {
    // miembros de acceso del paquete; Lista puede acceder a ellos directamente
    public Object datos; // los datos para este nodo
    public NodoLista siguienteNodo; // referencia al siguiente nodo en la lista

    // el constructor crea un objeto NodoLista que hace referencia al objeto
    public NodoLista(Object objeto)
    {
        this( objeto, null );
    } // fin del constructor de NodoLista con un argumento

    // el constructor crea un objeto NodoLista que hace referencia a
    // un objeto Object y al siguiente objeto NodoLista
    public NodoLista(Object objeto, NodoLista nodo)
    {
        datos = objeto;
        siguienteNodo = nodo;
    } // fin del constructor de NodoLista con dos argumentos

    // devuelve la referencia a datos en el nodo
    Object obtenerObject() {

        return datos; // devuelve el objeto Object en este nodo
    } // fin del método obtenerObject

    // devuelve la referencia al siguiente nodo en la lista
    NodoLista obtenerSiguiente()


    {
        return siguienteNodo; // obtiene el siguiente nodo


    }
}

