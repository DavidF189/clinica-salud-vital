package pe.com.utp.estructuras.listas;

import pe.com.utp.modelo.persona.Paciente;
import pe.com.utp.interfaces.TADListaPacientes;

// Implementación de lista enlazada simple para gestionar pacientes dinámicamente
public class ListaPacientes implements TADListaPacientes {

    // Primer nodo de la lista
    private Nodo inicio;
    private int tamanio;

    // Constructor de la lista. Inicialmente la lista está vacía
    public ListaPacientes() {
        inicio = null;
        tamanio = 0;
    }

    // Inserta un nuevo paciente al final de la lista enlazada
    @Override
    public void insertarPaciente(Paciente paciente) {

        // Crea un nuevo nodo con el paciente recibido
        Nodo nuevoNodo = new Nodo(paciente);

        // Si la lista está vacía, el nuevo nodo se convierte en el inicio
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {

            // Nodo auxiliar utilizado para recorrer la lista
            Nodo actual = inicio;

            // Recorre la lista hasta llegar al último nodo
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            // Enlaza el último nodo con el nuevo nodo
            actual.setSiguiente(nuevoNodo);
        }

        System.out.println("Paciente insertado correctamente en la lista");
        tamanio++;
    }

    // Muestra todos los pacientes almacenados en la lista enlazada
    @Override
    public void mostrarPacientes() {

        // Verifica si la lista está vacía
        if (inicio == null) {
            System.out.println("La lista de pacientes está vacía");
            return;
        }
        System.out.println("===== LISTA ENLAZADA DE PACIENTES =====");

        // Nodo auxiliar utilizado para recorrer la lista
        Nodo actual = inicio;

        // Recorre nodo por nodo hasta llegar a null
        while (actual != null) {
            System.out.println();

            // Muestra los datos del paciente actual
            actual.getPaciente().mostrarDatos();

            // Avanza al siguiente nodo
            actual = actual.getSiguiente();
        }
    }

    // Busca un paciente mediante su DNI dentro de la lista enlazada
    @Override
    public Paciente buscarPacientePorDni(String dni) {

        // Nodo auxiliar para recorrer la lista
        Nodo actual = inicio;

        // Recorre nodo por nodo hasta encontrar coincidencia.

        while (actual != null) {

            // Compara el DNI ingresado con el DNI del paciente almacenado en el nodo actual
            if (actual.getPaciente().getDni().equals(dni)) {
                // Retorna el paciente encontrado
                return actual.getPaciente();
            }

            // Avanza al siguiente nodo
            actual = actual.getSiguiente();
        }

        // Retorna null si no existe coincidencia
        return null;
    }

    // Elimina un paciente de la lista enlazada mediante su DNI
    @Override
    public void eliminarPaciente(String dni) {

        // Verifica si la lista está vacía
        if (inicio == null) {
            System.out.println("La lista está vacía");
            return;
        }

        // Caso especial: el paciente a eliminar está en el inicio
        if (inicio.getPaciente().getDni().equals(dni)) {

            inicio = inicio.getSiguiente();
            tamanio--;
            System.out.println("Paciente eliminado correctamente");
            return;
        }

        // Nodos auxiliares para recorrer la lista
        Nodo actual = inicio;
        Nodo anterior = null;

        // Recorre la lista buscando el nodo a eliminar
        while (actual != null &&
                !actual.getPaciente().getDni().equals(dni)) {

            anterior = actual;
            actual = actual.getSiguiente();
        }

        // Verifica si el paciente fue encontrado
        if (actual == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        // Desconecta el nodo encontrado de la lista
        anterior.setSiguiente(actual.getSiguiente());
        tamanio--;
        System.out.println("Paciente eliminado correctamente");
    
    }
    
    @Override
    public int obtenerTamanio() {
        return tamanio;
    }
    
    @Override
    public boolean estaVacia() {
        return inicio == null;
    }
    
    @Override
    public void ordenarPorNombre() {
        if (tamanio < 2) return;
        
        for (int i = 0; i < tamanio - 1; i++) {
            Nodo actual = inicio;
            for (int j = 0; j < tamanio - i - 1; j++) {
                if (actual.getPaciente().getNombre()
                    .compareToIgnoreCase(actual.getSiguiente().getPaciente().getNombre()) > 0) {
                    Paciente temp = actual.getPaciente();
                    actual.setPaciente(actual.getSiguiente().getPaciente());
                    actual.getSiguiente().setPaciente(temp);
                }
                actual = actual.getSiguiente();
            }
        }
        System.out.println("Lista ordenada por nombre");
    }
    
    @Override
    public void insertarAlInicio(Paciente paciente) {
        Nodo nuevoNodo = new Nodo(paciente);
        nuevoNodo.setSiguiente(inicio);
        inicio = nuevoNodo;
        tamanio++;
        System.out.println("Paciente insertado al inicio");
    }
    
    @Override
    public void actualizarTelefono(String dni, String nuevoTelefono) {
        Paciente paciente = buscarPacientePorDni(dni);
        if (paciente != null) {
            paciente.setTelefono(nuevoTelefono);
            System.out.println("Teléfono actualizado correctamente");
        } else {
            System.out.println("Paciente no encontrado");
        }
    }
}
