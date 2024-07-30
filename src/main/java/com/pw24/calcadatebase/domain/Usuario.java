package com.pw24.calcadatebase.domain;

import org.hibernate.validator.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "usuario_tbl")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Size(min = 2, max = 50, message = "Houve um erro no cadastro do campo nome.")
    @NotBlank(message = "O nome deve ser preenchido, não pode fica em branco!")
    String usename;

    @Size(min = 8, message = "A senha deve conter pelomenos 8 caractere.")
    @NotBlank(message = "O campo (Senha) não pode estar em branco.")
    String password;

   // @NotBlank(message = "O campo não pode ser Nulo")
    Boolean isAdmin;

    String dateNascimento;
    String email;
    String adminIs;

    public void upperCaseUsuarioName(){
        usename.toUpperCase();
    }

    public void usuarioAdmin(){
        if (isAdmin != null) {
            if (isAdmin==true) {
                adminIs ="sim";
            }else{
                adminIs="não";
            }
            
        }
    }

    
}
