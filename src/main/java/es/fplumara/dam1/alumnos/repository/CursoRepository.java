package es.fplumara.dam1.alumnos.repository;

import es.fplumara.dam1.alumnos.model.Curso;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    void initSchema();

    Curso insert(Curso curso) throws SQLException;

    Curso update(Curso curso);

    List<Curso> findAll();

    Optional<Curso> findById(Integer id);



    boolean activo(boolean estado);

    void eliminarSiNombreContiene();

    List<Curso> listarPorEstado(Boolean estado);

List<Curso> listarOrdenadorPor(String nombre); //pendient

}
