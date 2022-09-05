package javaspringpatika.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

@Column(name = "user_first_name")
    private String userFirstName;

@Column(name = "user_last_name")
    private String userLastName;

@NotNull(message = "eposta adresi boş geçilmez")
@NotBlank(message = "eposta adresi boş geçilmez")
@Column(name = "email")
    private String email;

@Column(name = "user_phone", length = 11)
    private int userPhone;

}
