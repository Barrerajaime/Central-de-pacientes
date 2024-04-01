import java.util.*;

class Persona {
    private String nombre;
    private String DNI;
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

public class SistemaGestionHospitalaria {
    private List<Clinica> clinicas;
    private Map<String, Paciente> registroPacientes;
    private Map<String, Empleado> registroEmpleados;

    // Constructor y métodos para manejar el sistema
    // ...

    public static void main(String[] args) {
        // Inicializar y gestionar el sistema
    }
}
