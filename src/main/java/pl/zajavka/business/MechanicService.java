package pl.zajavka.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.MechanicDAO;
import pl.zajavka.domain.Mechanic;
import pl.zajavka.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MechanicService {

    private final MechanicDAO mechanicDAO;

    @Transactional
    public List<Mechanic> findAvailable() {
        List<Mechanic> availableMechanics = mechanicDAO.findAvailable();
        log.info("Available salesmen: [{}]", availableMechanics.size());
        return availableMechanics;
    }

    // TODO nicer way
    @Transactional
    public Mechanic findMechanic(String pesel) {
        return mechanicDAO.findByPesel(pesel)
                .orElseThrow(() -> new NotFoundException("Could not find mechanic by pesel: [%s]".formatted(pesel)));
    }
}
