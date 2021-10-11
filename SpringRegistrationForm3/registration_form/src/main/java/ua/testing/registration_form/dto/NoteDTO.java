package ua.testing.registration_form.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NoteDTO {

    private String names;

    private String surname;

    private String nationality;

    private String login;


}
