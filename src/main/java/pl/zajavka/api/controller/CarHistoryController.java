package pl.zajavka.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zajavka.api.dto.CarHistoryDTO;
import pl.zajavka.api.dto.CarToServiceDTO;
import pl.zajavka.api.dto.mapper.CarMapper;
import pl.zajavka.business.CarService;

import java.util.Objects;

@Controller
@AllArgsConstructor
public class CarHistoryController {

    private static final String CAR_HISTORY = "/car/history";

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping(value = CAR_HISTORY)
    public String carHistory(
        @RequestParam(value = "carVin", required = false) String carVin,
        Model model
    ) {
        addAllCarsAttributes(model);
        addCarHistoryAttribute(carVin, model);
        return "car_history";
    }

    private void addAllCarsAttributes(Model model) {
        var allCars = carService.findAllCarsWithHistory()
                .stream()
                .map(carMapper::map)
                .toList();
        var allCarVins = allCars
                .stream()
                .map(CarToServiceDTO::getVin)
                .toList();

        model.addAttribute("allCarDTOs", allCars);
        model.addAttribute("allCarVins", allCarVins);
    }

    private void addCarHistoryAttribute(String carVin, Model model) {
        CarHistoryDTO carHistoryDTO = Objects.nonNull(carVin) ?
                carMapper.map(carService.findCarHistoryByVin(carVin)) :
                CarHistoryDTO.buildDefault();

        model.addAttribute("carHistoryDTO", carHistoryDTO);
    }
}
