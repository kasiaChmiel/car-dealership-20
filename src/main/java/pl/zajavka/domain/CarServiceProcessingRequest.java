package pl.zajavka.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Objects;

@With
@Value
@Builder
public class CarServiceProcessingRequest {

    String mechanicPesel;
    String carVin;
    String partSerialNumber;
    Integer partQuantity;
    String serviceCode;
    Integer hours;
    String comment;
    boolean done;

    public boolean partNotIncluded() {
        return Objects.isNull(getPartSerialNumber())
            || Objects.isNull(getPartQuantity())
            || Part.NONE.equals(getPartSerialNumber());
    }
}
