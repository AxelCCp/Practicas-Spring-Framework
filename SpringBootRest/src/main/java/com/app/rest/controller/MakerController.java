package com.app.rest.controller;

import com.app.rest.controller.dto.MakerDTO;
import com.app.rest.model.entity.Maker;
import com.app.rest.model.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @GetMapping("/find/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Optional<Maker> makerOptional = makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder().id(maker.getId()).name(maker.getName()).productList(maker.getProductList()).build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?>findAll(){
        List<MakerDTO> makerDTOList = makerService.findAll()
                .stream().map(maker ->  MakerDTO.builder()
                            .id(maker.getId())
                            .name(maker.getName())
                            .productList(maker.getProductList())
                            .build())
                    .collect(Collectors.toList());
                return ResponseEntity.ok(makerDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        if(makerDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        makerService.save(Maker.builder()
                .name(makerDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        Optional<Maker>makerOptional = makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado!");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        if(id != null){
            makerService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

    @Autowired
    private MakerService makerService;
}
