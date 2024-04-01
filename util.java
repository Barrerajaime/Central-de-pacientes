import java.util.*;

class Persona {
    private String nombre;
    private String id;
    private String telefono;
    private String direccion;
    private String email;

    // Constructor, getters y setters
}

class Paciente extends Persona {
    private String historiaClinicaNumero;
    private List<HistorialMedico> historialMedico;
    private List<CitaMedica> citasMedicas;
    private SeguroMedico seguro;

    // Constructor, getters y setters
    // Métodos para manejar el historial médico y las citas
}

class Empleado extends Persona {
    private String numeroEmpleado;
    private Departamento departamento;

    // Constructor, getters y setters
}

class Doctor extends Empleado {
    private Especialidad especialidad;
    private List<Paciente> pacientes;
    private Horario laboral;

    // Constructor, getters y setters
    // Métodos para diagnosticar, prescribir tratamiento, etc.
}

class Enfermero extends Empleado {
    private List<Turno> turnos;

    // Constructor, getters y setters
    // Métodos para manejar las tareas de enfermería
}

class Administrativo extends Empleado {
    private Rol rolAdministrativo;

    // Constructor, getters y setters
    // Métodos para manejar tareas administrativas
}

class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    // Constructor, getters y setters
    // Métodos para manejar las operaciones del departamento
}

class Clinica {
    private String nombre;
    private List<Departamento> departamentos;
    private List<Sala> salas;
    private List<EquipoMedico> equiposMedicos;

    // Constructor, getters y setters
    // Métodos para manejar las operaciones de la clínica
}

class HistorialMedico {
    private Date fecha;
    private String descripcion;
    private Doctor doctor;

    // Constructor, getters y setters
    // Métodos para actualizar el historial médico
}

class SeguroMedico {
    private String empresa;
    private String numeroPoliza;
    private Paciente asegurado;

    // Constructor, getters y setters
    // Métodos para gestionar la cobertura del seguro
}

class CitaMedica {
    private Doctor doctor;
    private Paciente paciente;
    private Date fechaHora;
    private Sala sala;

    // Constructor, getters y setters
    // Métodos para confirmar o cancelar citas
}

class Sala {
    private String numero;
    private List<Cama> camas;

    // Constructor, getters y setters
    // Métodos para gestionar el estado de las salas y camas
}

class Cama {
    private String identificador;
    private boolean ocupada;

    // Constructor, getters y setters
    // Métodos para asignar o liberar la cama
}

class EquipoMedico {
    private String nombre;
    private String codigoInventario;
    private EstadoEquipo estado;

    // Constructor, getters y setters
    // Métodos para manejar el mantenimiento del equipo
}

class Especialidad {
    private String nombre;
    private List<Doctor> doctores;

    // Constructor, getters y setters
    // Métodos para añadir o eliminar doctores de la especialidad
}

class Rol {
    private String descripcion;

    // Constructor, getters y setters
    // Métodos específicos para cada rol
}

class Turno {
    private Date inicio;
    private Date fin;
    private Enfermero enfermeroAsignado;

    // Constructor, getters y setters
}

class Horario {
    private Date inicioJornada;
    private Date finJornada;
    private List<Turno> turnos;

    // Constructor, getters y setters
    // Métodos para gestionar los horarios de trabajo
}

enum EstadoEquipo {
    DISPONIBLE, EN_USO, EN_MANTENIMIENTO
}

class GestorPacientes {
    private Map<String, Paciente> registroPacientes;

    public GestorPacientes() {
        this.registroPacientes = new HashMap<>();
    }

    public void registrarPaciente(Paciente paciente) {
        if (!registroPacientes.containsKey(paciente.getId())) {
            registroPacientes.put(paciente.getId(), paciente);
            System.out.println("Paciente registrado con éxito: " + paciente.getNombre());
        } else {
            System.out.println("El paciente ya está registrado.");
        }
    }

    public Paciente buscarPacientePorId(String id) {
        return registroPacientes.get(id);
    }

    public void actualizarDatosPaciente(String id, Paciente nuevosDatos) {
        if (registroPacientes.containsKey(id)) {
            registroPacientes.put(id, nuevosDatos);
            System.out.println("Datos del paciente actualizados con éxito.");
        } else {
            System.out.println("No se encontró el paciente con ID: " + id);
        }
    }

    public void darDeAltaPaciente(String id) {
        if (registroPacientes.containsKey(id)) {
            registroPacientes.remove(id);
            System.out.println("Paciente dado de alta y eliminado del sistema.");
        } else {
            System.out.println("No se encontró el paciente con ID: " + id);
        }
    }
}

class GestorCitas {
    private List<CitaMedica> agendaCitas;

    public GestorCitas() {
        this.agendaCitas = new LinkedList<>();
    }

    public void programarCita(CitaMedica cita) {
        agendaCitas.add(cita);
        System.out.println("Cita programada para el paciente: " + cita.getPaciente().getNombre());
    }

    public List<CitaMedica> obtenerCitasDelDia(Date fecha) {
        List<CitaMedica> citasDelDia = new ArrayList<>();
        for (CitaMedica cita : agendaCitas) {
            if (mismoDia(cita.getFechaHora(), fecha)) {
                citasDelDia.add(cita);
            }
        }
        return citasDelDia;
    }

    private boolean mismoDia(Date fecha1, Date fecha2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(fecha1);
        cal2.setTime(fecha2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public void cancelarCita(CitaMedica cita) {
        if (agendaCitas.remove(cita)) {
            System.out.println("Cita cancelada para el paciente: " + cita.getPaciente().getNombre());
        } else {
            System.out.println("La cita no se encontró en el sistema.");
        }
    }
}

public class SistemaGestionHospitalaria {
    private List<Clinica> clinicas;
    private Map<String, Paciente> registroPacientes;
    private Map<String, Empleado> registroEmpleados;
    private GestorPacientes gestorPacientes;
    private GestorCitas gestorCitas;

    public SistemaGestionHospitalaria() {
        this.clinicas = new ArrayList<>();
        this.registroPacientes = new HashMap<>();
        this.registroEmpleados = new HashMap<>();
        this.gestorPacientes = new GestorPacientes();
        this.gestorCitas = new GestorCitas();
    }

    // Métodos para manejar el sistema: agregar clínicas, registrar pacientes, etc.
    // Métodos para interfaz de usuario para permitir la interacción con el sistema

    public static void main(String[] args) {
        SistemaGestionHospitalaria sistema = new SistemaGestionHospitalaria();
        // Código para interactuar con el sistema
    }
}
