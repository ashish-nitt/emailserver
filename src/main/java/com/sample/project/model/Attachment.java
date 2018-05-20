package com.sample.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ashish on 20-05-2018.
 */
@Entity
@Data
@NoArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachementSeq")
    @SequenceGenerator(name = "attachementSeq", sequenceName = "attachementSeq", initialValue = 1)*/
    Long attachmentId;

    @Lob
    @NotNull
    private byte[] data;

    @NotNull
    String attachmentType;
}
