package com.gatherProject.GatherBackend.Controllers;

import com.gatherProject.GatherBackend.Models.Ministry;
import com.gatherProject.GatherBackend.Services.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/ministries")
public class MinistryController {
    final MinistryService ministryService;

    @Autowired
    public MinistryController(MinistryService ministryService) {
        this.ministryService = ministryService;
    }

    @PostMapping
    public ResponseEntity<Ministry> createMinistry(@RequestBody Ministry ministry) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(ministryService.persistMinistry(ministry));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Ministry> readMinistry(@PathVariable String username) throws ExecutionException, InterruptedException {
        Ministry ministry = ministryService.getMinistry(username);

        if (ministry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(ministry);
    }

    @PutMapping
    public ResponseEntity<Ministry> updateMinistry(@RequestBody Ministry ministry) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(ministryService.persistMinistry(ministry));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Ministry> deleteMinistry(@PathVariable String username) throws ExecutionException, InterruptedException {
        Ministry ministry = ministryService.getMinistry(username);

        if (ministry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ministryService.deleteMinistry(username);

        return ResponseEntity.ok(ministry);
    }
}
