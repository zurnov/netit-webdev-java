package com.trelloclone.trelloclone.controllers;

import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.translate.TranslateMessage;
import com.trelloclone.trelloclone.wrappers.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @GetMapping("/workspace/test")
    public String getTestMessage(){
        return "Hello World Testis";
    }

    @GetMapping("/")
    public ResponseEntity getAllWorkspace(){
        List<Workspace> httpResult = this.workspaceRepository.findAll();
        return ResponseMessage.success(httpResult);
    }
    @GetMapping("/{id}")
    public ResponseEntity getSingleWorkspace(@PathVariable("id") int id){

        Optional<Workspace> httpResult = this.workspaceRepository.findById(id);
        if (httpResult.isPresent()){
            return ResponseMessage.success(httpResult.get());
        }
        return  ResponseMessage.notFound();
    }
    @PostMapping("/")
    public ResponseEntity createWorkspace(@RequestBody Workspace entity){
       var httpResult = this.workspaceRepository.save(entity);
       return ResponseMessage.success(TranslateMessage.WORKFLOW_CREATE_SUCCSESS, httpResult);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateWorkspace(@RequestBody Workspace entity, @PathVariable("id") int id){

       Optional<Workspace> httpResult = this.workspaceRepository.findById(id);

       if (httpResult.isPresent()){
          Workspace exitingEntity = httpResult.get();
          exitingEntity.setTitle(entity.getTitle());
          exitingEntity.setDescription(entity.getDescription());
          exitingEntity.setType(entity.getType());
          return ResponseMessage.success(TranslateMessage.WORKFLOW_UPDATE_SUCCSESS, exitingEntity);
       }
       return ResponseMessage.notFound();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeWorkspace(@PathVariable("id") int id){

        Optional<Workspace> httpResult = this.workspaceRepository.findById(id);
        if (httpResult.isPresent()){
            return ResponseMessage.success(TranslateMessage.WORKFLOW_REMOVE_SUCCSESS);
        }
        return  ResponseMessage.notFound(TranslateMessage.WORKFLOW_NOT_FOUND);
    }
}
