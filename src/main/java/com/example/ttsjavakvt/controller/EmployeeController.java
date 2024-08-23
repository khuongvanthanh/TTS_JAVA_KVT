package com.example.ttsjavakvt.controller;

import com.example.ttsjavakvt.dto.ImportExcelHistory;
import com.example.ttsjavakvt.entity.Staff;
import com.example.ttsjavakvt.repository.StaffRepository;
import com.example.ttsjavakvt.service.EmployeeService;
import com.example.ttsjavakvt.utils.FileUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    final EmployeeService employeeService;

    @Autowired
    StaffRepository staffRepository;

    @Value("${excel.prefix.historyImport}")
    private String path;

    @ModelAttribute("staff")
    Staff staff() {
        return new Staff();
    }

    @ModelAttribute("listHistory")
    List<ImportExcelHistory> history() {
        try {
            return FileUtil.readHistoriesFromFile(this.path).reversed();
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("listEmp", this.employeeService.getAllEmp());
        return "component/employee/index";
    }

    @GetMapping("/change-status/{id}")
    public String changeStatus(@PathVariable String id) {
        this.employeeService.updateStatus(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String store(Model model) {
        model.addAttribute("title", "Thêm nhân viên");
        model.addAttribute("action", "/add");
        return "component/employee/addAndUpdate";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("staff") Staff staff, BindingResult result) {
        if (employeeService.existsByAccountFe(staff.getAccountFe())) {
            result.rejectValue("accountFe", "error.staff", "Email đã tồn tại.");
        }
        if (employeeService.existsByAccountFpt(staff.getAccountFpt())) {
            result.rejectValue("accountFpt", "error.staff", "Email đã tồn tại.");
        }
        if (employeeService.existsByStaffCode(staff.getStaffCode())) {
            result.rejectValue("staffCode", "error.staff", "Mã đã tồn tại.");
        }
        if (result.hasErrors()) {
            return "component/employee/addAndUpdate";
        }
        this.employeeService.saveEmp(staff);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("title", "Chỉnh sửa nhân viên");
        model.addAttribute("staff", this.employeeService.getStaffById(id));
        model.addAttribute("action", "/update/" + id);
        return "component/employee/addAndUpdate";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @Valid @ModelAttribute("staff") Staff staff, BindingResult result) {
        Staff isChecked = this.employeeService.getStaffById(id).get();
        if (!Objects.equals(staff.getAccountFe(), isChecked.getAccountFe())) {
            if (employeeService.existsByAccountFe(staff.getAccountFe())) {
                result.rejectValue("accountFe", "error.staff", "Email đã tồn tại.");
            }
        }
        if (!Objects.equals(staff.getAccountFpt(), isChecked.getAccountFpt())) {
            if (employeeService.existsByAccountFpt(staff.getAccountFpt())) {
                result.rejectValue("accountFpt", "error.staff", "Email đã tồn tại.");
            }
        }
        if (!Objects.equals(staff.getStaffCode(), isChecked.getStaffCode())) {
            if (employeeService.existsByStaffCode(staff.getStaffCode())) {
                result.rejectValue("staffCode", "error.staff", "Mã đã tồn tại.");
            }
        }
        if (result.hasErrors()) {
            return "component/employee/addAndUpdate";
        }
        staff.setId(id);
        staff.setCreatedDate(isChecked.getCreatedDate());
        this.employeeService.saveEmp(staff);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Staff> searchResults = this.employeeService.searchByKeyword(keyword);
        model.addAttribute("listEmp", searchResults);
        model.addAttribute("keyword", keyword);
        return "component/employee/index";
    }

    @GetMapping("/filter")
    public String filterByStatus(@RequestParam(value = "status", required = false) Integer status, Model model) {
        List<Staff> filteredStaff;
        if (status != null) {
            filteredStaff = this.employeeService.getStaffByStatus(status);
        }
        else {
            filteredStaff = (List<Staff>) this.employeeService.getAllEmp();
        }
        model.addAttribute("listEmp", filteredStaff);
        return "component/employee/index";
    }

}
