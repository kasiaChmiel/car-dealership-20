package pl.zajavka.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.PartDAO;
import pl.zajavka.domain.Part;
import pl.zajavka.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PartCatalogService {

    private final PartDAO partDAO;

    // TODO nicer way
    @Transactional
    public Part findPart(String partSerialNumber) {
        return partDAO.findBySerialNumber(partSerialNumber)
                .orElseThrow(() -> new NotFoundException("Could not find part by part serial number: [%s]".formatted(partSerialNumber)));
    }

    public List<Part> findAll() {
        List<Part> parts = partDAO.findAll();
        log.info("Available parts: [{}]", parts);
        return parts;
    }
}
