// definición de la clase Lista
import com.deitel.jhtp7.cap17.ExcepcionListaVacia;
import com.deitel.jhtp7.cap17.NodoLista;

import java.io.ObjectStreamException;

public class Lista{

    private NodoLista primerNodo;
    private NodoLista ultimoNodo;
    private String nombre; // cadena como "lista", utilizada para imprimir

    // el constructor crea una Lista vacía con el nombre "lista"
    public Lista() {
        this( "lista" );
    }
    // fin del constructor de Lista sin argumentos
    // el constructor crea una Lista vacía con un nombre



    public Lista( String nombreLista )
    {
        nombre = nombreLista;
        primerNodo = ultimoNodo = null;
    } // fin del constructor de Lista con un argumento

    // inserta objeto Object al frente de la Lista
    public void insertarAlFrente( Object elementoInsertar )
    {
        if ( estaVacia() ) // primerNodo y ultimoNodo hacen referencia al mismo objeto
            primerNodo = ultimoNodo = new NodoLista( elementoInsertar );
        else // primerNodo hace referencia al nuevo nodo
            primerNodo = new NodoLista( elementoInsertar, primerNodo );
    } // fin del método insertarAlFrente

    // inserta objeto Object al final del la Lista
    public void insertarAlFinal( Object elementoInsertar )
    {
        if ( estaVacia() ) // primerNodo y ultimoNodo hacen referencia al mismo objeto
            primerNodo = ultimoNodo = new NodoLista( elementoInsertar );
        else // el siguienteNodo de ultimoNodo hace referencia al nuevo nodo
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoLista( elementoInsertar );
    } // fin del método insertarAlFinal

    // elimina el primer nodo de la Lista
    public Object eliminarDelFrente() throws ExcepcionListaVacia
    {
        if ( estaVacia() ) // lanza excepción si la Lista está vacía
            throw new ExcepcionListaVacia( nombre );

        Object elementoEliminado = primerNodo.datos; // obtiene los datos que se van a eliminar
        // actualiza las referencias primerNodo y ultimoNodo
        if ( primerNodo == ultimoNodo )
            primerNodo = ultimoNodo = null;
        else
            primerNodo = primerNodo.siguienteNodo;

        return elementoEliminado; // devuelve los datos del nodo eliminado
    } // fin del método eliminarDelFrente
    // elimina el último nodo de la Lista
    public Object eliminarDelFinal() throws ExcepcionListaVacia
    {
        if ( estaVacia() ) // lanza excepción si la Lista está vacía
            throw new ExcepcionListaVacia( nombre );

        Object elementoEliminado = ultimoNodo.datos; // obtiene los datos que se van  aeliminar

        // actualiza las referencias primerNodo y ultimoNodo
        if ( primerNodo == ultimoNodo )
            primerNodo = ultimoNodo = null;
        else // localiza el nuevo último nodo
        {
            NodoLista actual = primerNodo;

            // itera mientras el nodo actual no haga referencia a ultimoNodo
            while ( actual.siguienteNodo != ultimoNodo )
                actual = actual.siguienteNodo;

            ultimoNodo = actual; // actual el nuevo ultimoNodo
            actual.siguienteNodo = null;
        } // fin de else

        return elementoEliminado; // devuelve los datos del nodo eliminado
    } // fin del método eliminarDelFinal
    // determina si la lista está vacía

    //NUEVO MÉTODO
    public Object nodoIntermedio(Object datorAEliminar) throws ExcepcionListaVacia {
        if (estaVacia()) {
            throw new ExcepcionListaVacia(nombre);
        }

        NodoLista actual = primerNodo;
        NodoLista anterior = null;

        while (actual != null) {
            if (actual.datos.equals(datorAEliminar)) {
                if (anterior != null) {
                    anterior.siguienteNodo = actual.siguienteNodo;
                    if (actual == ultimoNodo) {
                        ultimoNodo = anterior;
                    }
                } else {
                    primerNodo = actual.siguienteNodo;
                    if (actual == ultimoNodo) {
                        ultimoNodo = primerNodo;
                    }
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguienteNodo;
        }

        return datorAEliminar;
    }

    public void insertarEnPosicion(Object datoInsertar, int posicion) throws ExcepcionListaVacia {
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa.");
        }

        if (estaVacia() && posicion > 0) {
            throw new ExcepcionListaVacia(nombre);
        }

        NodoLista nuevoNodo = new NodoLista(datoInsertar);

        if (posicion == 0) {
            nuevoNodo.siguienteNodo = primerNodo;
            primerNodo = nuevoNodo;
            if (ultimoNodo == null) {
                ultimoNodo = primerNodo;
            }
        } else {
            NodoLista actual = primerNodo;
            NodoLista anterior = null;
            int contador = 0;

            while (actual != null && contador < posicion) {
                anterior = actual;
                actual = actual.siguienteNodo;
                contador++;
            }

            if (contador == posicion) {
                anterior.siguienteNodo = nuevoNodo;
                nuevoNodo.siguienteNodo = actual;

                if (actual == null) {
                    ultimoNodo = nuevoNodo;
                }
            } else {
                throw new IndexOutOfBoundsException("La posición está fuera de rango.");
            }
        }
    }


    public boolean estaVacia()
    {
        return primerNodo == null; // devuelve true si la lista está vacía
    } // fin del método estaVacia

    // imprime el contenido de la lista
    public void imprimir()
    {
        if ( estaVacia() )
        {
            System.out.printf( "%s vacia\n", nombre );
            return;
        } // fin de if

        System.out.printf( "La %s es: ", nombre );
        NodoLista actual = primerNodo;

        // mientras no esté al final de la lista, imprime los datos del nodo actual
        while ( actual != null )
        {
            System.out.printf( "%s ", actual.datos );
            actual = actual.siguienteNodo;
        } // fin de while

        System.out.println( "\n" );
    } // fin del método imprimir


} // fin de la clase Lista  