package ma.rest.spring.controllers;

import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.TypeCompte;
import ma.rest.spring.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/banque")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    // Récupérer tous les comptes
    @GetMapping("/comptes")
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    // Récupérer un compte par son ID
    @GetMapping("/comptes/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
        return compteRepository.findById(id)
                .map(compte -> ResponseEntity.ok().body(compte))
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouveau compte
    @PostMapping("/comptes")
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        Compte savedCompte = compteRepository.save(compte);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCompte.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedCompte);
    }

    // Mettre à jour un compte existant
    @PutMapping("/comptes/{id}")
    public ResponseEntity<Compte> updateCompte(@PathVariable Long id, @RequestBody Compte compteDetails) {
        return compteRepository.findById(id)
                .map(compte -> {
                    compte.setSolde(compteDetails.getSolde());
                    compte.setDateCreation(compteDetails.getDateCreation());
                    compte.setType(compteDetails.getType());
                    Compte updatedCompte = compteRepository.save(compte);
                    return ResponseEntity.ok().body(updatedCompte);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un compte
    @DeleteMapping("/comptes/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        return compteRepository.findById(id)
                .map(compte -> {
                    compteRepository.delete(compte);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
