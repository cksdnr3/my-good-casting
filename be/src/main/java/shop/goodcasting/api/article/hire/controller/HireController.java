package shop.goodcasting.api.article.hire.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.goodcasting.api.article.hire.domain.HireDTO;
import shop.goodcasting.api.article.hire.domain.HireListDTO;
import shop.goodcasting.api.article.hire.service.HireServiceImpl;
import shop.goodcasting.api.common.domain.PageRequestDTO;
import shop.goodcasting.api.common.domain.PageResultDTO;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/hires")
public class HireController {
    private final HireServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody HireDTO hireDTO) {
        System.out.println("Hire DTO: " + hireDTO);
        service.register(hireDTO);
        return ResponseEntity.ok(1L);
    }

    @GetMapping("/detail")
    public ResponseEntity<HireDTO> hireDetail(Long hireId) {
        return ResponseEntity.ok(service.readHire(hireId));
    }

    @PostMapping("/list")
    public ResponseEntity<PageResultDTO<HireListDTO, Object[]>> hireList(@RequestBody PageRequestDTO pageRequest) {
        log.info("------------------" + pageRequest + "----------------------------------");

        log.info("==================================" + service.getHireList(pageRequest));

        return new ResponseEntity<>(service.getHireList(pageRequest), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody HireDTO hireDTO) {
        service.update(hireDTO);

        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

    @DeleteMapping("/{hireId}")
    public ResponseEntity<Long> delete(@PathVariable Long hireId) {

        service.deleteHire(hireId);

        return new ResponseEntity<>(1L, HttpStatus.OK);
    }

}