package com.crio.xharktank.models;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="offers")
public class offers {
    @Id
    private String id;
    @NotNull
    private String investor;
    private Float amount;
    private Float equity;
    private String comment;
}
