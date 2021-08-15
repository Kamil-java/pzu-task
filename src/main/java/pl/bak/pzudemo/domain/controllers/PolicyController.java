package pl.bak.pzudemo.domain.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.bak.pzudemo.domain.services.PolicyService;
import pl.bak.pzudemo.model.Policy;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PolicyController {
    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/all")
    public List<Policy> getAll(){
        List<Policy> allData = policyService.getAllData();

        if (allData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return allData;
    }
}
