package com.trelloclone.trelloclone;

import com.trelloclone.trelloclone.controller.WorkspaceController;
import com.trelloclone.trelloclone.enums.WorkspaceType;
import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.translate.TranslateMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WorkspaceControllerTest {

    @Autowired
    private WorkspaceController controller;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    private final int           FAKE_ID                     = 99999;
    private final String        TEST_ENTITY_TITLE           = "Test Title";
    private final WorkspaceType TEST_ENTITY_TYPE            = WorkspaceType.EDUCATION;
    private final String        TEST_ENTITY_DESCRIPTION     = "Test Entity Description";

    private final String        UPDATE_ENTITY_TITLE         = "Updated Title";
    private final WorkspaceType UPDATE_ENTITY_TYPE          = WorkspaceType.ENGINEERING;
    private final String        UPDATE_ENTITY_DESCRIPTION   = "Updated Entity Description";

    @Test
    public void checkIsAvailable(){
        assertNotNull(this.controller);
    }

    @Test
    public void testIfCanWeGetMessageHelloWorldTest(){

       String message = this.controller.getTestMessage();
       assertEquals("Hello World Testis",message);
    }

    @Test
    public void testCreateNewWorkspaceEntity(){
        Workspace entity = new Workspace("Example Workspace",
                WorkspaceType.EDUCATION,
                "Sample workspace holder");
        ResponseEntity httpResult = this.controller.createWorkspace(entity);


        assertEquals(HttpStatus.OK,httpResult.getStatusCode());
        assertTrue(httpResult.hasBody());
        HashMap<String,Object> httpBodyResult = (HashMap<String, Object>) httpResult.getBody();
        assertEquals(TranslateMessage.WORKFLOW_CREATE_SUCCSESS,httpBodyResult.get("message"));
    }

    @Test
    public void testGetSingleWorkspaceEntity(){
        Workspace entity = new Workspace("Example Workspace",
                WorkspaceType.EDUCATION,
                "Sample workspace holder");

        Workspace resultEntity                  = this.workspaceRepository.save(entity);
        final int RESULT_ENTITY_ID              = resultEntity.getId();
        final String RESULT_ENTITY_TITLE        = resultEntity.getTitle();
        final WorkspaceType RESULT_ENTITY_TYPE  = resultEntity.getType();
        final String RESULT_ENTITY_DESCRIPTION  = resultEntity.getDescription();

        ResponseEntity httpResult = this.controller.getSingleWorkspace(RESULT_ENTITY_ID);

        assertTrue(httpResult.hasBody());

        HashMap<String,Object> httpBodyResult = (HashMap<String, Object>) httpResult.getBody();
        Workspace httpBodyResultEntity = (Workspace) httpBodyResult.get("collection");

        assertEquals(HttpStatus.OK              ,httpResult.getStatusCode());
        assertEquals(RESULT_ENTITY_ID           ,httpBodyResultEntity.getId());
        assertEquals(RESULT_ENTITY_TITLE        ,httpBodyResultEntity.getTitle());
        assertEquals(RESULT_ENTITY_TYPE         ,httpBodyResultEntity.getType());
        assertEquals(RESULT_ENTITY_DESCRIPTION  ,httpBodyResultEntity.getDescription());
    }
    @Test
    public void testNonExistingWorkspaceEntity(){
        ResponseEntity httpResult = this.controller.getSingleWorkspace(FAKE_ID);
        assertEquals(HttpStatus.NOT_FOUND,httpResult.getStatusCode());

    }
    @Test
    public void testGetAllWorkspaceEntities(){
        Workspace entity = new Workspace("Example Workspace",
                WorkspaceType.EDUCATION,
                "Sample workspace holder");
        Workspace entity2 = new Workspace("Example Marketing Workspace",
                WorkspaceType.MARKETING,
                "Sample workspace holder");

        Workspace resultEntity                  = this.workspaceRepository.save(entity);
        final int RESULT_ENTITY_ID              = resultEntity.getId();
        final String RESULT_ENTITY_TITLE        = resultEntity.getTitle();
        final WorkspaceType RESULT_ENTITY_TYPE  = resultEntity.getType();
        final String RESULT_ENTITY_DESCRIPTION  = resultEntity.getDescription();

        Workspace resultEntity2                  = this.workspaceRepository.save(entity2);
        final int RESULT_ENTITY_ID_2              = resultEntity2.getId();
        final String RESULT_ENTITY_TITLE_2        = resultEntity2.getTitle();
        final WorkspaceType RESULT_ENTITY_TYPE_2  = resultEntity2.getType();
        final String RESULT_ENTITY_DESCRIPTION_2  = resultEntity2.getDescription();

        ResponseEntity httpResult = this.controller.getSingleWorkspace(RESULT_ENTITY_ID);

        assertTrue(httpResult.hasBody());

        HashMap<String,Object> httpBodyResult = (HashMap<String, Object>) httpResult.getBody();
        Workspace httpBodyResultEntity = (Workspace) httpBodyResult.get("collection");

        assertEquals(HttpStatus.OK              ,httpResult.getStatusCode());
        assertEquals(RESULT_ENTITY_ID           ,httpBodyResultEntity.getId());
        assertEquals(RESULT_ENTITY_TITLE        ,httpBodyResultEntity.getTitle());
        assertEquals(RESULT_ENTITY_TYPE         ,httpBodyResultEntity.getType());
        assertEquals(RESULT_ENTITY_DESCRIPTION  ,httpBodyResultEntity.getDescription());

        ResponseEntity httpResult2 = this.controller.getSingleWorkspace(RESULT_ENTITY_ID_2);

        assertTrue(httpResult.hasBody());

        HashMap<String,Object> httpBodyResult2 = (HashMap<String, Object>) httpResult2.getBody();
        Workspace httpBodyResultEntity2 = (Workspace) httpBodyResult2.get("collection");

        assertEquals(HttpStatus.OK              ,httpResult2.getStatusCode());
        assertEquals(RESULT_ENTITY_ID_2           ,httpBodyResultEntity2.getId());
        assertEquals(RESULT_ENTITY_TITLE_2        ,httpBodyResultEntity2.getTitle());
        assertEquals(RESULT_ENTITY_TYPE_2         ,httpBodyResultEntity2.getType());
        assertEquals(RESULT_ENTITY_DESCRIPTION_2  ,httpBodyResultEntity2.getDescription());

    }
    @Test
    public void testGetAllWorkspaceEntities2(){
        ArrayList<Workspace> testCollection = new ArrayList<>();

        testCollection.add(new Workspace("T1", WorkspaceType.EDUCATION, "D1"));
        testCollection.add(new Workspace("T2", WorkspaceType.MARKETING, "D2"));
        testCollection.add(new Workspace("T3", WorkspaceType.OPERATION, "D3"));

        ArrayList<Workspace> resultEntityCollection = (ArrayList<Workspace>) this.workspaceRepository.saveAll(testCollection);

       ResponseEntity httpResult = this.controller.getAllWorkspace();
       assertTrue(httpResult.hasBody());
        HashMap<String,Object> httpBodyResult       = (HashMap<String, Object>) httpResult.getBody();
        ArrayList<Workspace>  httpBodyResultCollection = (ArrayList<Workspace>) httpBodyResult.get("collection");

        Workspace testElement =null;
        Workspace resultEntityElement = resultEntityCollection.get(0);

        for(Workspace element: httpBodyResultCollection){
            if (element.getTitle().equals("T1")){
                testElement = element;
            }
        }
        assertEquals(HttpStatus.OK                  ,httpResult.getStatusCode());
        assertEquals(resultEntityElement.getId()    ,testElement.getId());
        assertEquals("T1"                   ,testElement.getTitle());
        assertEquals(WorkspaceType.EDUCATION        ,testElement.getType());
        assertEquals("D1"                   ,testElement.getDescription());

    }
    @Test
    public void testUpdateExistingEntity(){
        Workspace providedEntity = this.provideEntity();
        final int PROVIDED_ENTITY_ID = providedEntity.getId();

        Workspace updateEntity = new Workspace(UPDATE_ENTITY_TITLE,UPDATE_ENTITY_TYPE,UPDATE_ENTITY_DESCRIPTION);
        ResponseEntity httpResult = this.controller.updateWorkspace(updateEntity,PROVIDED_ENTITY_ID);

        HashMap<String,Object> httpBodyResult       = (HashMap<String, Object>) httpResult.getBody();
        Workspace updatedEntity                     = (Workspace) httpBodyResult.get("collection");

        assertEquals(HttpStatus.OK              ,httpResult.getStatusCode());
        assertEquals(providedEntity.getId()     ,updatedEntity.getId());
        assertEquals(UPDATE_ENTITY_TITLE        ,updatedEntity.getTitle());
        assertEquals(UPDATE_ENTITY_TYPE         ,updatedEntity.getType());
        assertEquals(UPDATE_ENTITY_DESCRIPTION  ,updatedEntity.getDescription());


    }
    @Test
    public void testUpdateNonExistentEntity(){
        Workspace updateEntity = new Workspace(UPDATE_ENTITY_TITLE,UPDATE_ENTITY_TYPE,UPDATE_ENTITY_DESCRIPTION);
        ResponseEntity httpResult = this.controller.updateWorkspace(updateEntity,FAKE_ID);
        assertEquals(HttpStatus.NOT_FOUND,httpResult.getStatusCode());
    }
    private Workspace provideEntity(){
        Workspace entity = new Workspace(
                TEST_ENTITY_TITLE,
                TEST_ENTITY_TYPE,
                TEST_ENTITY_DESCRIPTION);
        return this.workspaceRepository.save(entity);

    }
    @Test
    public void testRemoveExistingEntity(){
        Workspace providedEntity = this.provideEntity();
        final int PROVIDED_ENTITY_ID = providedEntity.getId();

       ResponseEntity httpResponse = this.controller.removeWorkspace(PROVIDED_ENTITY_ID);

       assertTrue(httpResponse.hasBody());
        HashMap<String,Object> httpBodyResult       = (HashMap<String, Object>) httpResponse.getBody();
        assertEquals(TranslateMessage.WORKFLOW_REMOVE_SUCCSESS,httpBodyResult.get("message"));
    }
    @Test
    public void removeNonExistingEntity(){
        ResponseEntity httpResult = this.controller.removeWorkspace(FAKE_ID);
        assertEquals(HttpStatus.NOT_FOUND,httpResult.getStatusCode());
    }
}
