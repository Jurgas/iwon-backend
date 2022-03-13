package iwon.iwonbackend.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @NotNull
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @NotBlank
    private String voivodeship;
    @NotBlank
    private String district;
    @NotBlank
    private String name;
    @NotEmpty
    private String category;

    private String address;
    private String phone;
    private String email;
    private String website;
}

