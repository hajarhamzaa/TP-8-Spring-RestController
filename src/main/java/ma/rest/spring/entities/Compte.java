package ma.rest.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "comptes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private double solde;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_creation")
    private Date dateCreation;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TypeCompte type;
}
