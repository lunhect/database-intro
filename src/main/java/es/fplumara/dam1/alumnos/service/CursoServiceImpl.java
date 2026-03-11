package es.fplumara.dam1.alumnos.service;

import es.fplumara.dam1.alumnos.model.Curso;
import es.fplumara.dam1.alumnos.repository.CursoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService {

    private CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository)  {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Optional<Curso> findById(Integer idCurso) {
        if (idCurso == null || idCurso <= 0) {
            return Optional.empty();
        }
        return cursoRepository.findById(idCurso);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> getCursos(String campo, String tipoOrden) {
        if (campo == null || campo.trim().isEmpty()) {
            campo = "id";
        }
        if (tipoOrden == null || (!tipoOrden.equalsIgnoreCase("ASC") && !tipoOrden.equalsIgnoreCase("DESC"))) {
            tipoOrden = "ASC";
        }
        return cursoRepository.listarOrdenadorPor(campo, tipoOrden);
    }

    @Override
    public List<Curso> getCursos(Boolean estado) {
        if (estado == null) {
            return cursoRepository.findAll();
        }
        return cursoRepository.listarPorEstado(estado);
    }

    @Override
    public Curso crearCurso(Curso curso) throws SQLException {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser null");
        }
        if (curso.getNombre() == null || curso.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío");
        }
        return cursoRepository.insert(curso);
    }

    @Override
    public Curso modificarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser null");
        }
        if (curso.getId() == null || curso.getId() <= 0) {
            throw new IllegalArgumentException("ID de curso no válido");
        }
        return cursoRepository.update(curso);
    }

    @Override
    public int eliminarCursosPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        cursoRepository.eliminarSiNombreContiene(nombre);
        return 0;
    }
}