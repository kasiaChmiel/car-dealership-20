package pl.zajavka.util;

import lombok.experimental.UtilityClass;
import pl.zajavka.infrastructure.database.entity.CarToBuyEntity;

import java.math.BigDecimal;

@UtilityClass
public class EntityFixtures {

    public static CarToBuyEntity somaCar1(){
        return CarToBuyEntity.builder()
                .vin("vin1")
                .brand("brand1")
                .model("model1")
                .year(2000)
                .color("color1")
                .price(new BigDecimal("2222200.59"))
                .build();
    }
    public static CarToBuyEntity somaCar2(){
        return CarToBuyEntity.builder()
                .vin("vin2")
                .brand("brand2")
                .model("model2")
                .year(2002)
                .color("color2")
                .price(new BigDecimal("6622200.59"))
                .build();
    }
    public static CarToBuyEntity somaCar3(){
        return CarToBuyEntity.builder()
                .vin("vin3")
                .brand("brand3")
                .model("model3")
                .year(2003)
                .color("color3")
                .price(new BigDecimal("3322200.59"))
                .build();
    }
}
