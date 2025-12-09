package org.example.kapsejladse24a.controller;

import org.example.kapsejladse24a.model.Sailboat;
import org.example.kapsejladse24a.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sailboats")
public class SailboatRestController {

    @Autowired
    SailboatRepository sailboatRepository;

    @GetMapping
    public List<Sailboat> findAll(){
        return sailboatRepository.findAll();
    }

    @GetMapping("/x/{id}")
    public ResponseEntity<Sailboat> getSailboatx(@PathVariable int id) {
        Optional<Sailboat> orgSailboat = sailboatRepository.findById(id);
        if (orgSailboat.isPresent()) {
            Sailboat sailboat = orgSailboat.get();
            return new ResponseEntity<>(sailboat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Sailboat(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sailboat> getSailboat(@PathVariable int id) {
        return sailboatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sailboat> updateSailboat(@PathVariable int id, @RequestBody Sailboat sailboat) {
        return sailboatRepository.findById(id)
                .map(existingSailboat -> {
                    sailboat.setBoatID(existingSailboat.getBoatID()); // Ensure ID is preserved
                    Sailboat updatedSailboat = sailboatRepository.save(sailboat);
                    return ResponseEntity.ok(updatedSailboat);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sailboat> createSailboat(@RequestBody Sailboat sailboat) {
        Sailboat saved = sailboatRepository.save(sailboat);
        URI location = URI.create("/sailboats/" + saved.getBoatID());
        return ResponseEntity.created(location).body(saved);
    }


}
