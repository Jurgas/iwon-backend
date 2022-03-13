package iwon.iwonbackend.controller;

import iwon.iwonbackend.model.Facility;
import iwon.iwonbackend.service.FacilityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FacilityController {

    private final FacilityService service;

    public FacilityController(FacilityService service) {
        this.service = service;
    }

    @GetMapping("/facilities")
    public List<Facility> getAllFacilities() {
        return this.service.findAll();
    }

    @PostMapping("/facilities")
    public List<Facility> addFacilities(@Valid @RequestBody List<Facility> facilities) {
        return this.service.addFacilities(facilities);
    }

    @GetMapping("/facility/{id}")
    public Facility getFacility(@PathVariable Long id) {
        return this.service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Nie znaleziono instytucji o id: " + id
                ));
    }

    @PutMapping("/facility/{id}")
    public Facility updateFacility(@PathVariable Long id, @Valid @RequestBody Facility newFacility) {
        return service.findById(id)
                .map(facility -> {
                    if (newFacility.getVoivodeship() != null && newFacility.getVoivodeship().trim().length() > 0)
                        facility.setVoivodeship(newFacility.getVoivodeship());
                    if (newFacility.getDistrict() != null && newFacility.getDistrict().trim().length() > 0)
                        facility.setDistrict(newFacility.getDistrict());
                    if (newFacility.getName() != null && newFacility.getName().trim().length() > 0)
                        facility.setName(newFacility.getName());
                    if (newFacility.getCategory() != null && newFacility.getCategory().length() > 0)
                        facility.setCategory(newFacility.getCategory());
                    facility.setAddress(newFacility.getAddress());
                    facility.setPhone(newFacility.getPhone());
                    facility.setEmail(newFacility.getEmail());
                    facility.setWebsite(newFacility.getWebsite());
                    return service.updateFacility(facility);
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Nie znaleziono instytucji o id: " + id
                ));
    }

    @DeleteMapping("/facility/{id}")
    public Facility removeFacility(@PathVariable Long id) {
        return service.findById(id)
                .map(facility -> {
                    service.removeFacility(id);
                    return facility;
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Nie znaleziono instytucji o id: " + id
                ));
    }
}
