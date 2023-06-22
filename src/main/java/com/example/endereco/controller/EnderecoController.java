package com.example.endereco.controller;

import com.example.endereco.entitys.Endereco;
import com.example.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("endereco")
    public ResponseEntity<Endereco> salvarTime(@RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(endereco));
    }
    @GetMapping("endereco/{id}")
    public ResponseEntity<Endereco> buscarEnderecoId(@PathVariable Long id){
       Endereco endereco= enderecoService.buscarEnderecoId(id);
        if(endereco==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }

    @GetMapping("enderecos")
    public ResponseEntity<List<Endereco>> buscarEnderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listaEnderecos());
    }

    @DeleteMapping("endereco/{id}")
    public ResponseEntity<String> apagarEndereco(@PathVariable Long id) {
        try {
            enderecoService.deletarEndereco(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereco com id " + id + " excluído com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping("endereco")
    public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atalizarEndereco(endereco));
    }
    @GetMapping("cidade/{cidade}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorCidade(@PathVariable String cidade) {
        List<Endereco> endereco = enderecoService.buscarEnderecoPorCidade(cidade);
        if (endereco == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }


    }    @GetMapping("rua/{rua}")
    public ResponseEntity<Endereco> buscarEnderecoPorRua(@PathVariable String rua) {
        Endereco endereco = enderecoService.buscarEnderecoRua(rua);
        if (endereco == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }
    @GetMapping("estado/{estado}")
    public ResponseEntity<Endereco> buscarEnderecoPorEstado(@PathVariable String estado) {
        Endereco endereco = enderecoService.buscarEnderecoEstado(estado);
        if (endereco == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }
    @GetMapping("cep/{cep}")
    public ResponseEntity<Endereco> buscarEnderecoPorCep(@PathVariable String cep) {
        Endereco endereco = enderecoService.buscarEnderecoCep(cep);
        if (endereco == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }

}



