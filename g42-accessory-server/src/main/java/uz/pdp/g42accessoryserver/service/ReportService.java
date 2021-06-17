package uz.pdp.g42accessoryserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.pdp.g42accessoryserver.entity.Report;
import uz.pdp.g42accessoryserver.payload.ApiResponse;
import uz.pdp.g42accessoryserver.payload.ReportDto;
import uz.pdp.g42accessoryserver.repository.ReportRepository;
import uz.pdp.g42accessoryserver.repository.UserRepository;
import uz.pdp.g42accessoryserver.utills.CommonUtills;

import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;


//    public ApiResponse all(Integer page, Integer size) throws IllegalAccessException {
//        Page<User> all = userRepository.findAll(CommonUtills.getPageableByCreatedAtDesc(page, size));
//        return new ApiResponse("Ok",true,all.getContent().stream().map(this::getUserDto).collect(Collectors.toList()),all.getTotalElements(),all.getTotalPages());
//    }

    public ApiResponse getReport(boolean accepted, Integer page, Integer size) throws IllegalAccessException {
        Page<Report> reports = reportRepository.findByAcceptedEquals(accepted, CommonUtills.getPageableByCreatedAtDesc(page, size));
        return new ApiResponse("Ok", true, reports.getContent().stream().map(this::getDto).collect(Collectors.toList()), reports.getTotalElements(), reports.getTotalPages());
    }

    public ApiResponse updateReport(boolean accepted) {
        reportRepository.changeStatus(accepted);
        return new ApiResponse("Ok", true);
    }

    public ReportDto getDto(Report report) {
        ReportDto reportDto = new ReportDto(
                report.getId(),
                report.getShop(),
                report.getSeller(),
                report.getManagerOrDirector(),
                report.isAccepted()
        );
        return reportDto;
    }
}
