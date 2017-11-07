package com.xjxuser.controller;

import com.xjxuser.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {
    public ResponseEntity responseWith(int result, BaseEntity entity) {
        if (result>0) {
            return ResponseEntity.ok(entity);
        } else  {
            return ResponseEntity.badRequest().body("failed");
        }
    }

    public ResponseEntity responseWith(int result) {
        if (result>0) {
            return ResponseEntity.ok("ok");
        } else  {
            return ResponseEntity.badRequest().body("failed");
        }
    }

    public ResponseEntity responseWith(int result, List list) {
        if (result>0) {
            return ResponseEntity.ok(list);
        } else  {
            return ResponseEntity.badRequest().body("failed");
        }
    }
}
