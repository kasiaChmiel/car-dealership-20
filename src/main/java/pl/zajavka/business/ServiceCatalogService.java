package pl.zajavka.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.ServiceDAO;
import pl.zajavka.domain.Service;
import pl.zajavka.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceCatalogService {

    private final ServiceDAO serviceDAO;

    // TODO nicer way
    @Transactional
    public Service findService(String serviceCode) {
        return serviceDAO.findByServiceCode(serviceCode)
                .orElseThrow(() -> new NotFoundException("Could not find service by service code: [%s]".formatted(serviceCode)));
    }

    public List<Service> findAll() {
        List<Service> services = serviceDAO.findAll();
        log.info("Available services: [{}]", services);
        return services;
    }
}
