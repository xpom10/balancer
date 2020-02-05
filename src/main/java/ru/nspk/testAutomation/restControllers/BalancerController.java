package ru.nspk.testAutomation.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nspk.testAutomation.exception.ErrorResponse;
import ru.nspk.testAutomation.exception.NotFoundException;
import ru.nspk.testAutomation.model.HostConfiguration;
import ru.nspk.testAutomation.services.BalancerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class BalancerController {

    private final BalancerService service;

    @GetMapping(value = "/api/hosts", produces = "application/json")
    public List<HostConfiguration> getAllHosts() {
        return service.getAll();
    }

    @GetMapping(value = "/api/hosts/available", produces = "application/json")
    public HostConfiguration getAvailableHost() {
        return service.getAvailableHost();
    }

    @PutMapping(value = "/api/hosts/{host}", produces = "application/json")
    public ResponseEntity<HostConfiguration> setProgress(@PathVariable String host, @RequestParam boolean progress) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.changeHostProgress(host, progress));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder().message(e.getMessage()).build());
    }

}
