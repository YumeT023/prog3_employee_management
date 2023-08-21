package com.example.prog4.model.core.dto.management;

import com.example.prog4.model.core.entity.management.Position;
import com.example.prog4.model.core.enums.Csp;
import com.example.prog4.model.core.enums.Sex;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Employee implements Serializable {
  private String id;
  private String firstName;
  private String lastName;

  private MultipartFile image;
  private String stringImage;

  private Csp csp;
  private Sex sex;
  private String cin;
  private String cnaps;
  private String address;
  private Integer childrenNumber;
  private String personalEmail;
  private String professionalEmail;
  private String registrationNumber;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate entranceDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate departureDate;

  private List<Position> positions;
  private List<Phone> phones;
}
