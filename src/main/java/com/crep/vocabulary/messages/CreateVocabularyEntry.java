package com.crep.vocabulary.messages;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
public class CreateVocabularyEntry {
    @NotEmpty
    @NonNull
    private String titleUnit;

    @NotEmpty
    @NonNull
    private List<String> explains;
}
