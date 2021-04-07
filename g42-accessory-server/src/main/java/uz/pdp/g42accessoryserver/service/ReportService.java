package uz.pdp.g42accessoryserver.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.Report;
import uz.pdp.g42accessoryserver.payload.ApiResponse;
import uz.pdp.g42accessoryserver.repository.ReportRepository;
import uz.pdp.g42accessoryserver.repository.UserRepository;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    UserRepository userRepository;


//    public ApiResponse all(Integer page, Integer size) throws IllegalAccessException {
//        Page<User> all = userRepository.findAll(CommonUtills.getPageableByCreatedAtDesc(page, size));
//        return new ApiResponse("Ok",true,all.getContent().stream().map(this::getUserDto).collect(Collectors.toList()),all.getTotalElements(),all.getTotalPages());
//    }

    public ApiResponse getReport(boolean accepted) {
        List<Report> reports = reportRepository.findByAcceptedEquals(accepted);
        return new ApiResponse("Success", true, reports);
    }

    public ApiResponse updateReport(boolean accepted) {
        reportRepository.changeStatus();
        return new ApiResponse("Success", true);
    }
}
