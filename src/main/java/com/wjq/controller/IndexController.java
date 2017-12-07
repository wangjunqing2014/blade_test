package com.wjq.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.HttpMethod;
import com.wjq.service.TestServiceA;

@Path
public class IndexController {

    @Inject
    private TestServiceA testServiceA;

    @GetRoute("/home")
    public String home(){
        return "index.html";
    }

    @Route(value = "/home2", method = HttpMethod.GET)
    public String home2(){
        testServiceA.getStatistics();
        return "index.html";
    }

//    @PostRoute("/upload")
//    public void upload(@MultipartParam FileItem fileItem){
//        byte[] data = fileItem.getData();
//        // Save the temporary file to the specified path
//        Files.write(Paths.get(filePath), data);
//    }

//    @GetRoute("/savePerson")
//    public void users(@Param Person person){
//        System.out.println("person: " + person);
//    }
}
