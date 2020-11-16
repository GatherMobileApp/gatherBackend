package com.gatherProject.GatherBackend.Controllers;

import com.gatherProject.GatherBackend.Models.Ministry;
import com.gatherProject.GatherBackend.Services.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class MinistryController {
    final MinistryService ministryService;

    @Autowired
    public MinistryController(MinistryService ministryService) {
        this.ministryService = ministryService;
    }

    @PostMapping("/ministries")
    public Ministry createMinistry(@RequestBody Ministry ministry) throws ExecutionException, InterruptedException {
        return ministryService.persistMinistry(ministry);
    }

    @GetMapping("/ministries/{id}")
    public Ministry readMinistry(@PathVariable String username) throws ExecutionException, InterruptedException {
        return ministryService.getMinistry(username);
    }

    @PutMapping("/ministries")
    public Ministry updateMinistry(@RequestBody Ministry ministry) throws ExecutionException, InterruptedException {
        return ministryService.persistMinistry(ministry);
    }

    @DeleteMapping("/ministries/{id}")
    public void deleteMinistry(@PathVariable String username) throws ExecutionException, InterruptedException {
        ministryService.deleteMinistry(username);
    }
}
