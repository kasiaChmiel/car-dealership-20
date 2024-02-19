package pl.zajavka.domain;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.Set;

@With
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "carServiceRequestNumber")
@ToString(of = {"carServiceRequestId", "carServiceRequestNumber", "receivedDateTime", "completedDateTime", "customerComment"})
public class CarServiceRequest {

    Integer carServiceRequestId;
    String carServiceRequestNumber;
    OffsetDateTime receivedDateTime;
    OffsetDateTime completedDateTime;
    String customerComment;
    Customer customer;
    CarToService car;
    Set<ServiceMechanic> serviceMechanics;
    Set<ServicePart> serviceParts;
}
