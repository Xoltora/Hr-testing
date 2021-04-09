package uz.pdp.g42accessoryserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.g42accessoryserver.payload.ApiResponse;
import uz.pdp.g42accessoryserver.service.ReportService;
import uz.pdp.g42accessoryserver.utills.AppConst;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PreAuthorize("hasAnyRole({'ROLE_MANAGER','ROLE_SUPER_ADMIN'})")
    @GetMapping("/getReport")
    public HttpEntity<?> getAll(@RequestParam boolean accepted,
                                @RequestParam(value = "page", defaultValue = AppConst.PAGE_DEFAULT_NUMBER) Integer page,
                                @RequestParam(value = "size", defaultValue = AppConst.PAGE_DEFAULT_SIZE) Integer size) throws IllegalAccessException {
        ApiResponse response = reportService.getReport(accepted,page,size);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

    @PreAuthorize("hasAnyRole({'ROLE_MANAGER','ROLE_SUPER_ADMIN'})")
    @PutMapping("/update")
    public HttpEntity<?> update(boolean accepted){
        ApiResponse response = reportService.updateReport(accepted);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }
}
