package pl.zajavka.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.SalesmanDAO;
import pl.zajavka.domain.Salesman;
import pl.zajavka.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SalesmanService {

    private final SalesmanDAO salesmanDAO;

    @Transactional
    public List<Salesman> findAvailable() {
        List<Salesman> availableSalesmen = salesmanDAO.findAvailable();
        log.info("Available salesmen: [{}]", availableSalesmen.size());
        return availableSalesmen;
    }

    // TODO nicer way
    @Transactional
    public Salesman findSalesman(String pesel) {
        return salesmanDAO.findByPesel(pesel)
                .orElseThrow(() -> new NotFoundException("Could not find salesman by pesel: [%s]".formatted(pesel)));
    }
}
