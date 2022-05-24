package com.example.datastoreapi.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LikeEntity {
    @Id
    private Long id;

    @NotNull
    private String merchId;

    @NotNull
    private String userId;
}
