package com.crep.vocabulary.model;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vocabulary")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class VocabularyEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @NotEmpty
    @Column(name = "title_unit")
    private String titleUnit;

    @Type(type = "list-array")
    @NonNull
    @NotEmpty
    @Column(
            name = "explains",
            columnDefinition = "text[]"
    )
    private List<String> explains;
}
