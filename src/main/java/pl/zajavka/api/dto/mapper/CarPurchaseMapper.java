package pl.zajavka.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.zajavka.api.dto.CarPurchaseDTO;
import pl.zajavka.domain.CarPurchaseRequest;

@Mapper(componentModel = "spring")
public interface CarPurchaseMapper {

     CarPurchaseRequest map(final CarPurchaseDTO dto);
}
