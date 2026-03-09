package es.fplumara.dam1.alumnos;

import es.fplumara.dam1.alumnos.model.Alumno;
import es.fplumara.dam1.alumnos.repository.AlumnoRepository;
import es.fplumara.dam1.alumnos.repository.AlumnoRepositoryDB;
import es.fplumara.dam1.alumnos.repository.AlumnoRepositoryInMemory;
import es.fplumara.dam1.alumnos.service.AlumnoService;
import es.fplumara.dam1.alumnos.service.AlumnoServiceImpl;

public class Main {

    public static void main(String[] args) {
        String url  = "jdbc:postgresql://localhost:5432/dam1";
        String user = "dam1";
        String pass = "dam1pass";

        AlumnoRepository repo = new AlumnoRepositoryDB(url, user, pass);
        repo.initSchema();
        AlumnoService service = new AlumnoServiceImpl(repo);

        Alumno a1 = new Alumno(null, "John", "Doe", 2015);
        Alumno a2 = new Alumno(null, "Jane", "Doe", 2018);
        Alumno a3 = new Alumno(null, "Tim", "Roe", 2016);

        service.crearAlumno(a1);
        service.crearAlumno(a2);
        service.crearAlumno(a3);

        System.out.println("=== LISTA DE ALUMNOS ===");
        service.getAlumnos().forEach(a ->
                System.out.println(a.getId() + " -> " + a.getNombre() + " " + a.getApellidos() + " (" + a.getAnioNacimiento() + ")")
        );

        System.out.println("\n=== BUSCAR ALUMNO ID 2 ===");
        Alumno buscado = service.getAlumno(2);
        System.out.println(buscado.getId() + " -> " + buscado.getNombre() + " " + buscado.getApellidos());

        System.out.println("\n=== MODIFICAR ALUMNO ID 2 ===");
        Alumno modificado = new Alumno(2, "Jane", "Doe", 2009); // ejemplo: cambia año
        service.modificarAlumno(modificado);

        System.out.println("\n=== LISTA TRAS MODIFICAR ===");
        service.getAlumnos().forEach(a ->
                System.out.println(a.getId() + " -> " + a.getNombre() + " " + a.getApellidos() + " (" + a.getAnioNacimiento() + ")")
        );
    }
}