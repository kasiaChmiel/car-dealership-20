package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.CustomerDAO;
import pl.zajavka.domain.Customer;
import pl.zajavka.domain.exception.NotFoundException;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Transactional
    public void issueInvoice(Customer customer) {
        customerDAO.issueInvoice(customer);
    }

    // TODO nicer way
    @Transactional
    public Customer findCustomer(String email) {
        return customerDAO.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Could not find customer by email: [%s]".formatted(email)));
    }

    @Transactional
    public void saveServiceRequest(Customer customer) {
        customerDAO.saveServiceRequest(customer);
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }
}
