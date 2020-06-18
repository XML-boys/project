package com.xmlboys.controller;

import com.xmlboys.model.CodeItem;
import com.xmlboys.model.VehicleModel;
import com.xmlboys.service.CodeBookService;
import com.xmlboys.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/codeBook")
public class CodeBookController {

    @Autowired
    CodeBookService codeBookService;

    @Autowired
    VehicleModelService vehicleModelService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CodeItem item) {

        if (item != null) {
            codeBookService.save(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CodeItem item) {
        CodeItem codeItem = codeBookService.findById(id);
        if (codeItem != null) {

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        codeBookService.update(codeItem);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CodeItem>> findAll() {
        return ResponseEntity.ok(codeBookService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CodeItem> findById( @PathVariable("id") Long id) {
        CodeItem codeItem = codeBookService.findById(id);
        if(codeItem != null)
            return ResponseEntity.ok(codeBookService.findById(id));
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        codeBookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/{id}/model")
    public ResponseEntity<?> addModel(@PathVariable("id") Long id, @RequestBody VehicleModel vehicleModel) {

        CodeItem codeItem = codeBookService.findById(id);
            if(codeItem != null) {
                VehicleModel model = new VehicleModel();
                model.setName(vehicleModel.getName());
                model.setGear(vehicleModel.getGear());
                model.setOil(vehicleModel.getOil());
                model.setVendor(codeItem);
                codeItem.getModels().add(vehicleModelService.save(model));
                CodeItem item = codeBookService.update(codeItem);
                if (item != null)
                    return new ResponseEntity<>(HttpStatus.CREATED);
                else
                    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }else
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }

    @DeleteMapping(value = "/{id}/model/{modelId}")
    public ResponseEntity<?> deleteModel(@PathVariable("id") Long id, @PathVariable("modelId") Long modelId) {
        CodeItem codeItem = codeBookService.findById(id);
        if(codeItem != null) {
            for (VehicleModel model : codeItem.getModels()) {
                if (model.getId().equals(modelId)) {
                    codeItem.getModels().remove(model);
                    vehicleModelService.delete(modelId);
                    CodeItem item = codeBookService.update(codeItem);
                    if (item != null)
                        return new ResponseEntity<>(HttpStatus.OK);
                    else
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }

}
