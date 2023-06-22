package com.example.endereco.service;

import com.example.endereco.entitys.Endereco;
import com.example.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarEnderecoId(long id) {
        return enderecoRepository.findById(id).get();

    }

    public List<Endereco> buscarEnderecoPorCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);


    }

    public Endereco buscarEnderecoRua(String rua) {
        return enderecoRepository.findByRua(rua);
    }

    public Endereco buscarEnderecoEstado(String estado) {
        return enderecoRepository.findByEstado(estado);
    }

    public Endereco buscarEnderecoCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }

    public List<Endereco> listaEnderecos() {
        return enderecoRepository.findAll();
    }


    public Endereco atalizarEndereco(Endereco endereco) {

        return enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Long id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        } else {
            throw new RuntimeException("endereco não encontrado");
        }

    }


}

