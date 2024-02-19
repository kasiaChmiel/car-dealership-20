package pl.zajavka.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.zajavka.api.dto.CarServiceCustomerRequestDTO;
import pl.zajavka.api.dto.CarServiceMechanicProcessingUnitDTO;
import pl.zajavka.api.dto.CarServiceRequestDTO;
import pl.zajavka.domain.Address;
import pl.zajavka.domain.CarServiceProcessingRequest;
import pl.zajavka.domain.CarServiceRequest;
import pl.zajavka.domain.CarToService;
import pl.zajavka.domain.Customer;

@Mapper(componentModel = "spring")
public interface CarServiceRequestMapper extends OffsetDateTimeMapper {

    default CarServiceRequest map(CarServiceCustomerRequestDTO dto) {
        if (dto.isNewCarCandidate()) {
            return CarServiceRequest.builder()
                .customer(Customer.builder()
                    .name(dto.getCustomerName())
                    .surname(dto.getCustomerSurname())
                    .phone(dto.getCustomerPhone())
                    .email(dto.getCustomerEmail())
                    .address(Address.builder() // TODO create a separate address mapper instead of this builder
                        .country(dto.getCustomerAddressCountry())
                        .city(dto.getCustomerAddressCity())
                        .postalCode(dto.getCustomerAddressPostalCode())
                        .address(dto.getCustomerAddressStreet())
                        .build())
                    .build())
                .car(CarToService.builder() // TODO create a separate car to service mapper instead of this builder
                    .vin(dto.getCarVin())
                    .brand(dto.getCarBrand())
                    .model(dto.getCarModel())
                    .year(dto.getCarYear())
                    .build())
                .customerComment(dto.getCustomerComment())
                .build();
        } else {
            return CarServiceRequest.builder()
                .customer(Customer.builder() // TODO create a separate customer mapper instead of this builder
                    .email(dto.getExistingCustomerEmail())
                    .build())
                .car(CarToService.builder()  // TODO create a separate car to service to service mapper instead of this builder
                    .vin(dto.getExistingCarVin())
                    .build())
                .customerComment(dto.getCustomerComment())
                .build();
        }
    }

    @Mapping(source = "car.vin", target = "carVin")
    @Mapping(source = "receivedDateTime", target = "receivedDateTime", qualifiedByName = "mapOffsetDateTimeToString")
    @Mapping(source = "completedDateTime", target = "completedDateTime", qualifiedByName = "mapOffsetDateTimeToString")
    CarServiceRequestDTO map(CarServiceRequest request);

    @Mapping(source = "mechanicComment", target = "comment")
    CarServiceProcessingRequest map(CarServiceMechanicProcessingUnitDTO dto);
}
