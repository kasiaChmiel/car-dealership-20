package pl.zajavka.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPurchaseDTO {

    @Email
    private String existingCustomerEmail;
    private String customerName;
    private String customerSurname;
    @Size(min = 7, max = 15)
    @Pattern(regexp = "^[+]\\d{2}\\s\\d{3}\\s\\d{3}\\s\\d{3}$")
    private String customerPhone;
    @Email
    private String customerEmail;
    private String customerAddressCountry;
    private String customerAddressCity;
    private String customerAddressPostalCode;
    private String customerAddressStreet;

    private String carVin;
    private String salesmanPesel;

    public static CarPurchaseDTO buildDefaultData() {
        return CarPurchaseDTO.builder()
            .customerName("Alfred")
            .customerSurname("Samochodowy")
            .customerPhone("+48 754 552 234")
            .customerEmail("alf.samoch@gmail.com")
            .customerAddressCountry("Polska")
            .customerAddressCity("Wrocław")
            .customerAddressPostalCode("50-001")
            .customerAddressStreet("Bokserska 15")
            .build();
    }

    public Map<String, String> asMap() {
        Map<String ,String> result = new HashMap<>();
        Optional.ofNullable(customerName).ifPresent(value-> result.put("customerName", value));
        Optional.ofNullable(customerSurname).ifPresent(value-> result.put("customerSurname", value));
        Optional.ofNullable(customerPhone).ifPresent(value-> result.put("customerPhone", value));
        Optional.ofNullable(customerEmail).ifPresent(value-> result.put("customerEmail", value));
        Optional.ofNullable(customerAddressCountry).ifPresent(value-> result.put("customerAddressCountry", value));
        Optional.ofNullable(customerAddressCity).ifPresent(value-> result.put("customerAddressCity", value));
        Optional.ofNullable(customerAddressPostalCode).ifPresent(value-> result.put("customerAddressPostalCode", value));
        Optional.ofNullable(customerAddressStreet).ifPresent(value-> result.put("customerAddressStreet", value));
        Optional.ofNullable(carVin).ifPresent(value-> result.put("carVin", value));
        Optional.ofNullable(salesmanPesel).ifPresent(value-> result.put("salesmanPesel", value));
        return result;
    }
}
