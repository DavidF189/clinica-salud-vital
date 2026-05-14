package pe.com.utp.app;

import pe.com.utp.estructuras.matrices.MatrizHorarios;
import pe.com.utp.modelo.persona.Paciente;
import pe.com.utp.servicios.PacienteService;
import pe.com.utp.estructuras.listas.ListaPacientes;
import pe.com.utp.modelo.persona.Paciente;

/*
 * Clase principal del sistema.
 * Ejecuta pruebas iniciales del módulo de pacientes y matriz de citas.
 */
public class Main {

    public static void main(String[] args) {

        PacienteService pacienteService = new PacienteService();

        pacienteService.cargarPacientesIniciales();

        System.out.println("===== PACIENTES REGISTRADOS =====");
        pacienteService.mostrarPacientes();

        System.out.println("\n===== BÚSQUEDA DE PACIENTE =====");

        Paciente pacienteEncontrado = pacienteService.buscarPacientePorDni("45879632");

        if (pacienteEncontrado != null) {
            pacienteEncontrado.mostrarDatos();
        } else {
            System.out.println("Paciente no encontrado.");
        }

        System.out.println("\n===== ACTUALIZACIÓN DE PACIENTE =====");

        pacienteService.actualizarPaciente("73748381", "900111222", "nuevo_correo@correo.com");

        pacienteService.mostrarPacientes();

        System.out.println("\n===== ELIMINACIÓN DE PACIENTE =====");

        pacienteService.eliminarPaciente("74125896");

        pacienteService.mostrarPacientes();

        System.out.println("\n===== MATRIZ DE CITAS MÉDICAS =====");

        MatrizHorarios matrizHorarios = new MatrizHorarios();

        matrizHorarios.cargarDatosIniciales();
        matrizHorarios.mostrarMatriz();
        matrizHorarios.mostrarTotalPorDoctor();
        matrizHorarios.mostrarTotalPorDia();

        System.out.println("\n===== LISTA ENLAZADA =====");

        // Creación de la lista enlazada
        ListaPacientes listaPacientes = new ListaPacientes();

        // Inserción dinámica de pacientes en la lista
        listaPacientes.insertarPaciente(new Paciente(
                "P010",
                "12345678",
                "Luis",
                "Ramirez",
                "999111222",
                "luis@correo.com",
                28,
                "Fiebre"
        ));

        listaPacientes.insertarPaciente(new Paciente(
                "P011",
                "87654321",
                "Andrea",
                "Torres",
                "988777666",
                "andrea@correo.com",
                35,
                "Migraña"
        ));

        listaPacientes.insertarPaciente(new Paciente(
                "P012",
                "74185296",
                "Carlos",
                "Lopez",
                "955444333",
                "carlos@correo.com",
                40,
                "Diabetes"
        ));

        /*
         * Muestra la lista enlazada completa.
         */
        listaPacientes.mostrarPacientes();

        System.out.println("\n===== BÚSQUEDA EN LISTA ENLAZADA =====");

        Paciente pacienteLista =
                listaPacientes.buscarPacientePorDni("87654321");

        if (pacienteLista != null) {

            pacienteLista.mostrarDatos();

        } else {

            System.out.println("Paciente no encontrado.");
        }

        System.out.println("\n===== ELIMINACIÓN EN LISTA ENLAZADA =====");

        listaPacientes.eliminarPaciente("12345678");

        listaPacientes.mostrarPacientes();

        System.out.println("\n===== TAMAÑO FINAL DE LA LISTA =====");
        
        System.out.println("Total pacientes: " + listaPacientes.obtenerTamanio());

    }
}
