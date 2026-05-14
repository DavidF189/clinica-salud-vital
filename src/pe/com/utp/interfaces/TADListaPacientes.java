package pe.com.utp.interfaces;

import pe.com.utp.modelo.persona.Paciente;

/*
 * TAD para la gestión dinámica de pacientes.
 * Define las operaciones principales de una lista enlazada de pacientes.
 */
public interface TADListaPacientes {

    // Inserta un paciente en la estructura
    void insertarPaciente(Paciente paciente);

    //Muestra todos los pacientes registrados
    void mostrarPacientes();

    // Busca un paciente mediante su DNI
    Paciente buscarPacientePorDni(String dni);

    // Elimina un paciente mediante su DNI
    void eliminarPaciente(String dni);

    int obtenerTamanio();
    boolean estaVacia();
    void ordenarPorNombre();
    void insertarAlInicio(Paciente paciente);
    void actualizarTelefono(String dni, String nuevoTelefono);

}
