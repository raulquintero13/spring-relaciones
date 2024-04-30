package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.dto.DepartamentoDto;
import com.example.entity.Departamento;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>{


    @Query(value = "SELECT *, " 
            +"(SELECT COUNT(*) AS cuantos FROM empleados WHERE departamentos.id_departamento = empleados.id_departamento)"  
            + "AS cuantos FROM  departamentos"
        , nativeQuery = true)
    List<?> totalEmpleadosByID(Long id);

}
