package pl.bak.pzudemo.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.bak.pzudemo.model.Policy;

@Transactional(readOnly = true)
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
