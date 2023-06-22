package com.example.endereco.repository;

import com.example.endereco.entitys.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco,Long> {


       List<Endereco> findByCidade(String cidade);
       Endereco findByCep(String cep);
       Endereco findByRua(String rua);
       Endereco findByEstado(String estado);


}
