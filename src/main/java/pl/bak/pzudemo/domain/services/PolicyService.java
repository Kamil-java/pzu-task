package pl.bak.pzudemo.domain.services;

import org.springframework.stereotype.Service;
import pl.bak.pzudemo.domain.dao.PolicyRepository;
import pl.bak.pzudemo.model.Policy;
import pl.bak.pzudemo.util.MonitoringXlsxDirectory;

import java.util.List;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository, MonitoringXlsxDirectory monitoringXlsxDirectory) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getAllData(){
        return policyRepository.findAll();
    }
}
