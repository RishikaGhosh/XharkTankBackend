package com.crio.xharktank.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="pitch")
public class pitches {
    @Id
    private String id;
    private String entrepreneur;
    private String pitchTitle;
    private String pitchIdea;
    private Float askAmount;
    private Float equity;
    private List<offers>offers;
}
