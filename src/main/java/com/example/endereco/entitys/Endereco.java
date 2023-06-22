package com.example.endereco.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Endereco {
    @Id
    private Long id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
}
